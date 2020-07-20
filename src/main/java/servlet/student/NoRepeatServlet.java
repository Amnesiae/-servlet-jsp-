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
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

public class NoRepeatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("checkUsername".equals(method)) {
            checkUsername(request,response);
        }else if("checkPassword".equals(method)){
            checkPassword(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void checkPassword(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String oldPassword = request.getParameter("oldPassword");
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute(Constants.USER_SESSION);

        if (oldPassword.equals(student.getPassword())){
            out.print("");
        }else {
            out.print("密码错误");
        }
    }

    public void checkUsername(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        StudentService service = new StudentServiceImpl();
        List<Student> list = service.AllStudents();
        for (Student student : list) {
            if (username.equals(student.getUsername())) {
                out.print("用户存在,请重新输入");
                return;
            } else {
                out.print("");
            }
        }
    }
    }

