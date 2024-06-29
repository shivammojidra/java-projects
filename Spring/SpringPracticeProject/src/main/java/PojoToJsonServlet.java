import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.web_with_maven.dao.UserDao;
import com.web_with_maven.entities.User;


@WebServlet("/getUserData")
public class PojoToJsonServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("webConfig.xml");
		
		UserDao userDao = context.getBean("userDao",UserDao.class);
		
		User user = userDao.getSingleUser(Integer.parseInt(req.getParameter("userId")));
		resp.setContentType("application/json");
//		JSONObject jsonObject = new JSONObject(user);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String string = objectMapper.writeValueAsString(user);
		
//		System.out.println(string);
		resp.getWriter().write(string);
	}
}
