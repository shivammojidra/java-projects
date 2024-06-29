import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.web_with_maven.dao.UserDao;


@WebServlet("/remove")
public class RemoveUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("webConfig.xml");
		UserDao userDao = context.getBean("userDao",UserDao.class);
		userDao.deleteUser(Integer.parseInt(req.getParameter("deleteId")));
	}
}
