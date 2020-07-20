package servlet.student;

import entity.Student;
import service.student.StudentService;
import service.student.StudentServiceImpl;
import utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService service=new StudentServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Student student = service.login(username, password);

        if(student!=null){
            HttpSession session = request.getSession();
            session.setAttribute(Constants.USER_SESSION,student);

            response.sendRedirect("jsp/frame.jsp");

        }else {
            request.setAttribute("error","用户名或密码错误，请重新输入");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
