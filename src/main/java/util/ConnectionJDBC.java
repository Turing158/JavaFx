package util;

import entity.Student;

import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionJDBC{
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/study?characterEncoding=UTF-8";
    static String user = "root";
    static String password = "xwh2003";
    static Connection con;
    public static Connection getCon() throws SQLException {
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        con = DriverManager.getConnection(url,user,password);
        return con;
    }
    public static ResultSet querySQL(String sql) throws SQLException {
        return getCon().prepareStatement(sql).executeQuery(sql);
    }
    public static Object queryStudent(String sql) throws SQLException {
        ResultSet result = querySQL(sql);
        List<Student> students = new ArrayList<>();
        while (result.next()){
            Student student = new Student();
            student.setId(result.getInt("id"));
            student.setName(result.getString("name"));
            student.setPassword(result.getString("password"));
            student.setClassname(result.getString("class"));
            student.setGender(result.getString("gender"));
            student.setBorn(result.getString("born"));
            students.add(student);
        }
        if(students.size() == 1){
            return students.get(0);
        }
        return students;
    }
    public static String queryColum(String sql,String colum) throws SQLException {
        ResultSet result = querySQL(sql);
        while (result.next()){
            return result.getString(colum);
        }
        return null;
    }
}
