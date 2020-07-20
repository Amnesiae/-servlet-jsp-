package dao.student;

import com.mysql.jdbc.StringUtils;
import dao.BaseDao;
import entity.Student;
import service.student.StudentService;
import service.student.StudentServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//根据账号密码返回该用户
public class StudentDaoImpl implements StudentDao {
    @Override
    public Student getStudent(String username, String password) throws SQLException {
        Connection conn = null;
        Student student = null;
        conn = BaseDao.getConnection();
        String sql = "select * from student where username=? and password=?";
        Object[] params = {username, password};

        ResultSet rs = BaseDao.queryStudents(conn, sql, params);

        while (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setAge(rs.getInt("age"));
            student.setUsername(rs.getString("username"));
            student.setPassword(rs.getString("password"));
        }
        return student;
    }

    //根据用户名或者id查询用户总数
    @Override
    public int getStudentCount( String userName, String userId) throws Exception {
        Connection conn=null;
        // TODO Auto-generated method stub
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;
        conn=BaseDao.getConnection();
        if(conn != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from student");
            List<Object> list = new ArrayList<Object>();//存放我们的参数

            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and username like ?");
                list.add("%"+userName+"%");
            }

            StudentService service = new StudentServiceImpl();
            List<Student> list1 = service.AllStudents();
            int studentId=0;
                if(userId!="") {
                    studentId = Integer.parseInt(userId);
                }
            for (Student student1 : list1) {
                if (studentId == student1.getId()) {
                    sql.append(" and id = ?");
                    list.add(userId);
                    break;
                }}

            //怎么把List 转成数组
            Object[] params = list.toArray();

            rs = BaseDao.queryStudents(conn, sql.toString(), params);

            if(rs.next()) {
                count = rs.getInt("count");//从结果集中获取最终数量

            }
            BaseDao.close(null, pstm, rs);
        }
        return count;
    }

    //添加学生
    @Override
    public int InsertStudent(Student student) {
        Connection conn=null;
        conn = BaseDao.getConnection();
        String sql="insert into student values(null,?,?,?,?,?,?,?)";
        Object[] param={student.getUsername(),student.getSex(),student.getEmail(),student.getAge(),student.getAddress(),student.getUsername(),student.getPassword()};

        int count = BaseDao.updateStudents(conn, sql, param);

        return count;
    }

    //获取学生列表
    @Override
    public List<Student> AllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        Student student = null;
        conn = BaseDao.getConnection();
        String sql = "select * from student";

        ResultSet rs = BaseDao.queryStudents(conn, sql, null);

        while (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setSex(rs.getString("sex"));
            student.setEmail(rs.getString("email"));
            student.setAge(rs.getInt("age"));
            student.setAddress(rs.getString("address"));
            student.setPassword(rs.getString("password"));
            student.setUsername(rs.getString("username"));
            list.add(student);
        }
        return list;
    }


    //通过条件查询-userList
    @Override
    public List<Student> getStudentList(Connection connection, String userName,String userId) throws SQLException {
        // TODO Auto-generated method stub
        int studentId=0;
                if(userId!=""&&userId!=null) {
                    studentId=(Integer.parseInt(userId));
                }
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Student> userList = new ArrayList<Student>();
        if (connection != null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from student where 1=1");
            List<Object> list = new ArrayList<Object>();
            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and name like ?");
                list.add("%" + userName + "%");
            }
            StudentService service = new StudentServiceImpl();
            List<Student> list1 = service.AllStudents();
            for (Student student1 : list1) {
                if (studentId == student1.getId()) {
                    sql.append(" and id = ?");
                    list.add(userId);
                    break;
                }}

                Object[] params = list.toArray();
                System.out.println("sql ----> " + sql.toString());

                rs = BaseDao.queryStudents(connection, sql.toString(), params);
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setSex(rs.getString("sex"));
                    student.setEmail(rs.getString("email"));
                    student.setAge(rs.getInt("age"));
                    student.setAddress(rs.getString("address"));
                    student.setPassword(rs.getString("password"));
                    student.setUsername(rs.getString("username"));
                    userList.add(student);
                }
                BaseDao.close(null, pstm, rs);
            }
        return userList;
    }

    //修改当前用户的密码
    @Override
    public int updatePwd(String username ,String newPassword) {
        int count=0;
        Connection conn=null;
        conn=BaseDao.getConnection();
        String sql="update student set password=? where username=?";
        Object[] param={newPassword,username};
         count = BaseDao.updateStudents(conn, sql, param);
        return count;
    }

    //根据id删除用户
    public int deleteStudent(int id){
        Connection conn=null;
        int count=0;
        conn=BaseDao.getConnection();
        String sql="delete from student where id=? ";
        Object[] param={id};
        count = BaseDao.updateStudents(conn, sql, param);
        return count;
    };
}