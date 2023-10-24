package service;

import dao.StudentDaoImpl;
import entity.Student;

import java.sql.SQLException;

public class StudentService {
    public String LoginVerify(String id,String password) throws SQLException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        if(studentDao.studentExist(id) == 0){
            return "userError";
        }
        else if(!password.equals(studentDao.getStudentPassword(id))){
            return "passwordError";
        }
        return "success";
    }
    public String RegOperate(Student student) throws SQLException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        if(studentDao.studentExist(String.valueOf(student.getId())) != 0){
            return "userError";
        }
        else if(student.getPassword().length() < 6){
            return "passwordError";
        }
        else if(student.getGender().isEmpty()){
            return "InfoError";
        }
        return "success";
    }
}
