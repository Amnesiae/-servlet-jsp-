package servlet.student;

import entity.Student;
import service.student.StudentService;
import service.student.StudentServiceImpl;
import utils.Constants;
import utils.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("query".equals(method)){
           query(request,response);
        }else if("add".equals(method)){
            addStudent(request,response);
        }else if("modify".equals(method)){
            modify(request,response);
        }else if("delete".equals(method)){
            delete(request,response);
        }
    }

    //获得学生列表
    public void getAllStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        StudentService service=new StudentServiceImpl();
        List<Student> list = service.AllStudents();
        request.setAttribute("studentList",list);
        request.getRequestDispatcher("/jsp/userlist.jsp").forward(request,response);
    }

    //插入学生
    public void addStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        StudentService service=new StudentServiceImpl();
        Student student=new Student();
        student.setUsername(request.getParameter("name"));
        student.setSex(request.getParameter("sex"));
        student.setEmail(request.getParameter("email"));
        student.setAge((Integer.parseInt(request.getParameter("age"))));
        student.setAddress(request.getParameter("address"));
        student.setUsername(request.getParameter("username"));
        student.setPassword(request.getParameter("password"));

        int count = service.addStudent(student);
        if(count<1){
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("addSuccess.jsp").forward(request,response);
        }
    }

    public void query(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String nameSer = request.getParameter("nameSer");
        String idSer=request.getParameter("idSer");
        StudentService service=new StudentServiceImpl();
        List<Student> studentList = service.getStudentList(nameSer, idSer);
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("userlist.jsp").forward(request,response);
    }

    public void modify(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String newPassword=request.getParameter("newPassword");
        StudentService service=new StudentServiceImpl();
        Student student = (Student) request.getSession().getAttribute(Constants.USER_SESSION);

        int count = service.modifyPassword(student.getUsername(), newPassword);

        if(count>0){
            request.getRequestDispatcher("modifySuccess.jsp").forward(request,response);
        }

    }

    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentService service=new StudentServiceImpl();
        service.deleteStudent(id);
        query(request,response);
    }
}
