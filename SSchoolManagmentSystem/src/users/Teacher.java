package users;

import classes.Classes;
import users.Employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Teacher extends Employee implements Serializable {
    private int id;
    private String email;
    private String username;
    private String password;
    private boolean isBlocked = false;

    private Classes classes ;

    public Teacher(String name, String surname,String username,String password, LocalDate birthDate, double salary,int id,String email, Classes classes) {
        super(name, surname, birthDate, salary);
        this.id=id;
        this.email=email;
        this.username=username;
        this.password=password;
        this.classes=classes;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean blockTeacher(){
      //  System.out.println("Teacher : " + this.id + " "+ this.username + " was blocked!");
        return this.isBlocked=true;
    }

    public boolean unBlockedTeacher(){
      //  System.out.println("Teacher : " + this.id + " " +this.username + " was unblocked!");
        return this.isBlocked=false;

    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", classes=" + classes +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + Period.between(birthDate,LocalDate.now()).getYears() +
                '}' ;
    }
}
