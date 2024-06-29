import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.web_with_maven.dao.UserDao;
import com.web_with_maven.entities.User;


@WebServlet("/insert")
public class InsertRecordServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("webConfig.xml");
		
		ObjectMapper objectMapper = new ObjectMapper();

		String jsonString = req.getParameter("jsonString");
		
		User user = objectMapper.readValue(jsonString, User.class);
		
		UserDao userDao = context.getBean("userDao",UserDao.class);
		
		try {
			int i = userDao.insert(user);
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
