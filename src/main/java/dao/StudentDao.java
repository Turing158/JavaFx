package dao;

import entity.Student;

import java.sql.SQLException;

public interface StudentDao {
    int studentExist(String username) throws SQLException;
    Student getStudent(String username) throws SQLException;

    String getStudentPassword(String username) throws SQLException;
    void addStudent(Student student) throws SQLException;
}
