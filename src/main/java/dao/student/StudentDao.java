package dao.student;

import entity.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //根据账号密码拿到学生
    Student getStudent(String username,String password) throws SQLException;

    //得到学生总数
    int getStudentCount(String userName, String userId) throws Exception;

    //通过条件查询-StudentList
     List<Student> getStudentList(Connection connection, String userName, String userId) throws SQLException;

    //新增学生
    int InsertStudent(Student student);

    //获得学生列表
    List<Student> AllStudents() throws SQLException;

    //修改密码
    int updatePwd(String username,String newPassword);

    //根据id删除用户
    int deleteStudent(int id);
}
