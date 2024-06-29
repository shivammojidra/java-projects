import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web_with_maven.dao.UserDao;
import com.web_with_maven.entities.User;


@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("webConfig.xml");
		
		
//		User user = new User(17,"rakesh","123","rakesh@rakesh.com","male","iit bombay","machine learning");
		UserDao userDao = context.getBean("userDao",UserDao.class);
//		
		List<User> lstList = userDao.getAllUsers();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String string = objectMapper.writeValueAsString(lstList);
		
		resp.getWriter().write(string);
		
	}
	
	
}
