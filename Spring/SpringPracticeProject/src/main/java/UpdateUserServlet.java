import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web_with_maven.dao.UserDao;
import com.web_with_maven.entities.User;

@WebServlet("/editUser")
public class UpdateUserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("webConfig.xml");

		ObjectMapper objectMapper = new ObjectMapper();

		String jsonString = req.getParameter("jsonString");
		
		User user = objectMapper.readValue(jsonString, User.class);
		
//		System.out.println(req.getParameter("jsonString")+ "  This is needed");
//		
//		System.out.println(user.getName() + " To string of user");
		
//		User user = objectMapper.readValue("", User.class);
		
		UserDao userDao = context.getBean("userDao", UserDao.class);
		
		try {
			userDao.updateUser(user);
			resp.getWriter().write("continue");
		} catch (Exception e) {
			if ("org.springframework.dao.DataIntegrityViolationException".equals(e.getClass().getName().toString())) {
				resp.getWriter().write("exists");
				
			}else {
				
				resp.getWriter().write("exception");
			}
			
			
		}
		
		

	}
}
