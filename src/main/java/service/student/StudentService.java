package service.student;

import entity.Student;

import java.util.List;

public interface StudentService {
    //登录
    Student login(String username, String password);

    //获得所有的学生
    List<Student> AllStudents();

    //添加学生
    int addStudent(Student student);

    //根据条件查询用户列表
     List<Student> getStudentList(String queryUserName, String queryUserId);

    //根据条件获取学生数目
     int getUserCount(String queryUserName, String queryUserId);

    //修改密码
    int modifyPassword(String username,String newPassword);

    //根据id删除学生
    int deleteStudent(int id);
}
