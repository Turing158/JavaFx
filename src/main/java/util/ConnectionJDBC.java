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
        ResultSet resultSet = getCon().prepareStatement(sql).executeQuery(sql);
        con.close();
        return resultSet;
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
        result.close();
        con.close();
        if(students.size() == 1){
            return students.get(0);
        }
        return students;
    }
    public static String queryColum(String sql,String colum) throws SQLException {
        ResultSet resultSet = querySQL(sql);
        String result = "";
        while (resultSet.next()){
            result =  resultSet.getString(colum);
        }
        resultSet.close();
        con.close();
        return result;
    }
    public static void updateSQL(String sql) throws SQLException {
        getCon().prepareStatement(sql).executeUpdate(sql);
        con.close();
    }

}
