package service.student;

import dao.BaseDao;
import dao.student.StudentDao;
import dao.student.StudentDaoImpl;
import entity.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//登录
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public Student login(String username, String password) {
        Student student=null;
        try {
            student = studentDao.getStudent(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    //获得所有的学生
    @Override
    public List<Student> AllStudents() {
        List<Student> list=new ArrayList<>();

        try {
            list = studentDao.AllStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //添加学生
    @Override
    public int addStudent(Student student) {
        int count=0;

        if(student!=null){
         count = studentDao.InsertStudent(student);
        }
        return count;
    }
    //按条件查询学生
    @Override
    public List<Student> getStudentList(String queryUserName,String queryUserId) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<Student> userList = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserId);
        try {
            connection = BaseDao.getConnection();
            userList = studentDao.getStudentList(connection,queryUserName,queryUserId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.close(connection, null, null);
        }
        return userList;
    }

    @Override
    public int getUserCount(String queryUserName, String queryUserId) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int count = 0;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserId);
        try {
            connection = BaseDao.getConnection();
            count = studentDao.getStudentCount(queryUserName,queryUserId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.close(connection, null, null);
        }
        //System.out.println("count"+count);
        return count;
    }

    @Override
    public int modifyPassword(String username, String newPassword) {
        int count = studentDao.updatePwd(username, newPassword);
        return count;
    }

    public int deleteStudent(int id){
        int count=0;
         count = studentDao.deleteStudent(id);
        return count;
    };
}
