package entity;

public class Student {
    int id;
    String name;
    String password;
    String classname;
    String gender;
    int phone;
    String born;

    public Student(int id, String name, String password, String classname, String gender, int phone, String born) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.classname = classname;
        this.gender = gender;
        this.phone = phone;
        this.born = born;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }
    public Student(){}

}
