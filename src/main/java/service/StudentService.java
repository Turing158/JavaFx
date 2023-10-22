package service;

import dao.StudentDaoImpl;

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
}
