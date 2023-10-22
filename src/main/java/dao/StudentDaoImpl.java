package dao;

import entity.Student;
import util.ConnectionJDBC;

import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao{
    @Override
    public int studentExist(String username) throws SQLException {
        Object object = ConnectionJDBC.queryStudent("select * from student where id = " + username);
        return object instanceof Student ? 1 : 0;
    }

    @Override
    public Student getStudent(String username) throws SQLException {
        Object object = ConnectionJDBC.queryStudent("select * from student where id = " + username);
        return (Student) object;
    }
    @Override
    public String getStudentPassword(String username) throws SQLException {
        return ConnectionJDBC.queryColum("select password from student where name = " + username,"password");
    }
}
