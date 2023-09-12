package users;

import users.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Student extends Person implements Serializable {
    private int id;
    private String email;
    private String username;
    private String password;
    private boolean isBlocked = false;


    public Student(String name , String surname,String username,String password, LocalDate birthDate,int id, String email ) {
        super(name,surname,birthDate);
        this.id = id;
        this.email = email;
        this.username = username;
        this.password=password;
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

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void blockStduent(){
        this.isBlocked=true;
       // System.out.println("Student : " + this.id + " " + this.username + " was blocked!");
    }
    public void unBlockedStudent(){
        this.isBlocked=false;
        // System.out.println("Student : " + this.id + " " +  this.username + "was unblocked");
    }


    public String getDetails() {
        LocalDate localDate = LocalDate.now();
        int age = Period.between(birthDate,localDate).getYears();
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate + '\'' +
                ", age " + age + " \n" +
                '}'+ "\n";
    }

    @Override
    public String toString() {

        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate + '\'' +
                ", age=" + Period.between(birthDate,LocalDate.now()).getYears() +
                '}';
    }
}
