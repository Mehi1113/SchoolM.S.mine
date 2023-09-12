package service.impl;
import baseSystem.GlobalStrings;
import classes.Classes;
import globalData.GlobalData;
import service.AdminServiceInter;
import users.Person;
import users.Student;
import users.Teacher;
import util.FileUtils;
import util.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class AdminServiceImpl implements AdminServiceInter {
    @Override
    public void addStudent() {

        String name = Util.requireString("Enter name");
        String surname = Util.requireString("Enter surname");
        String username = getUsername(name,surname);
        String password = Util.requireString("Enter password");
        LocalDate birthDate = getBirthDate();
        String email = Util.requireString("Enter email");

        Student student = new Student(name,surname,username,password,birthDate, GlobalData.id++,email);
        GlobalData.personDinamicArray.add(student);
        String log = "New Student added " + name + "  " +surname + " Time : " + LocalDateTime.now();
        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
        System.out.println("Student  " + name.toUpperCase() + "  added succesfully" + "\n  Username : "+ username + " Password : " +password);
    }

    @Override
    public void addTeacher() {
        String name = Util.requireString("Enter name");
        String surname = Util.requireString("Enter surname");
        String username = getUsername(name,surname);
        String password = Util.requireString("Enter password");
        LocalDate birthDate = getBirthDate();
        double salary = Util.requireDouble("Enter salary");
        String email = Util.requireString("Enter email");
        Classes classes = getClasses();
        int id = GlobalData.id++;


        Teacher teacher = new Teacher(name,surname,username,password,birthDate,salary,id,email,classes);
        GlobalData.personDinamicArray.add(teacher);
        String log = "New Teacher added with " + id + " " + username + " Time : " + LocalDateTime.now();
        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
        System.out.println("Teacher  " + name.toUpperCase() + "  added succesfully" + "\n  Username : "+ username + " Password : " +password);
    }

    @Override
    public void deleteUserById(int id) {
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student){
                Student student =(Student) person;
                if (student.getId()==id){
                   try {
                       GlobalData.personDinamicArray.delete(i);
                       String log = "Person deleted with this id " + id + " " + person.getName() +" "+ person.getSurname() + " Time : " + LocalDateTime.now() +" by: "+GlobalData.loggedInPerson.getName();
                       FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
                   }catch (IllegalAccessException ex) {
                       ex.getMessage();
                   }
                    System.out.println("Student id : " + student.getId() + " was deleted successfully");
                   return;
                }
            }

            if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                if (teacher.getId()==id){
                 try {
                     GlobalData.personDinamicArray.delete(i);
                     String log = "Person deleted with this id " + id + " " + person.getName() +" "+ person.getSurname() + " Time : " + LocalDateTime.now()+" by: "+GlobalData.loggedInPerson.getName();
                     FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
                 }catch (IllegalAccessException ex){
                     ex.getMessage();
                 }
                    System.out.println("Teacher id : " + teacher.getId() + " was deleted successfully");
                 return;
                }
            }
        }
    }

    @Override
    public void updateUserById(int id) {
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student){
                Student student = (Student) person;
                if (id==student.getId()){
                    student.setName(Util.requireString("Name "));
                    student.setSurname(Util.requireString("Surname "));
                    student.setUsername(Util.requireString("Username "));
                    student.setPassword(Util.requireString("Password "));
                    student.setBirthDate(Util.requireLocalDate("Birth Date "));
                    student.setEmail(Util.requireString("Email "));
                    String log = "Student's info was updated with this id  " + student.getId() + " " + student.getName() + " "+ student.getSurname() + " Time : " + LocalDateTime.now();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                    return;
                }
            }
            if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                if (id==teacher.getId()){
                    teacher.setName(Util.requireString("Name "));
                    teacher.setSurname(Util.requireString("Surname "));
                    teacher.setUsername(Util.requireString("Username "));
                    teacher.setPassword(Util.requireString("Password "));
                    teacher.setBirthDate(Util.requireLocalDate("Birth Date "));
                    teacher.setEmail(Util.requireString("Email "));
                    teacher.setSalary(Util.requireDouble("Salary "));
                    String log = "Teacher's info was updated with this id  " + teacher.getId() + " " + teacher.getName() + " "+ teacher.getSurname() + " Time : " + LocalDateTime.now();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                    return;
                }
            }
        }
        System.out.println("There is not any Student or Teacher with that id " + id);
    }

    @Override
    public void blockUserById(int id) {
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student ){
                Student student = (Student) person;
                if (id == student.getId()){
                    student.blockStduent();
                    System.out.println("Student id : " + student.getId() + " blocked successfully" );
                    String log = "Student blocked with this id " +id +" " + student.getName() + "  " +student.getSurname() + " Time : " + LocalDateTime.now()+" by: "+GlobalData.loggedInPerson.getName();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
                    return;
                }
            }
            if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                if (id==teacher.getId()){
                    teacher.blockTeacher();
                    System.out.println("Teacher id : " + teacher.getId() + " blocked successfully");
                    String log = "Teacher blocked with this id" + id+" " + teacher.getName() + "  " +teacher.getSurname() + " Time : " + LocalDateTime.now()+" by: "+GlobalData.loggedInPerson.getName();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
                    return;
                }
            }
        }
    }

    @Override
    public void openBlockById(int id) {
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student ){
                Student student = (Student) person;
                if (id == student.getId() && student.isBlocked() ){
                    student.unBlockedStudent();
                    System.out.println("Student id : " + student.getId() + " unblocked successfully" );
                    String log = "Student unblocked with this id " + id + " " + student.getName() + "  " +student.getSurname() + " Time : " + LocalDateTime.now();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
                    return;
                }if (!student.isBlocked()){
                    System.out.println("That person is not block");
                    return;
                }
            }
            if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                if (id==teacher.getId() && teacher.isBlocked()){
                    teacher.unBlockedTeacher();
                    System.out.println("Teacher id : " + teacher.getId() + " unblocked successfully");
                    String log = "Teacher unblocked with this id " + id + " " + teacher.getName() + "  " +teacher.getSurname() + " Time : " + LocalDateTime.now();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
                    return;
                }if(!teacher.isBlocked()){
                    System.out.println("That Teacher is not block");
                }
            }
        }
    }

    @Override
    public void searchUserByName() {
        String name =Util.requireString("Insert name ").toLowerCase();
        for (int i = 0 ; i < GlobalData.personDinamicArray.getSize();i++){
            Person person = GlobalData.personDinamicArray.get(i);
            if (person.getName().toLowerCase().contains(name)){
                System.out.println(person);
                return;
            }
        }
        System.out.println("There is not any Student or Teacher with  name " + name);
    }



    @Override
    public void changePasswordById() {
        Util.printUserExceptAdmin();
        int idChangePassword = Util.requireInt("Enter id,which want to change password ");
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);

            if (person instanceof Student){
            Student student = (Student) person;
            if (idChangePassword==student.getId()){
                String newPassword = Util.requireString("Please insert new password");
                student.setPassword(newPassword);
                System.out.println("Password was changed successfully");
                String log = "Student's password was changed with this id  " + student.getId() + " " + student.getName() + " "+ student.getSurname() + " Time : " + LocalDateTime.now();
                FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                return;
            }
           }
            else if (person instanceof Teacher){
                Teacher teacher = (Teacher) person;
                if (idChangePassword == teacher.getId()){
                    String newPassword = Util.requireString("Please insert new password");
                    teacher.setPassword(newPassword);
                    System.out.println("Password was changed successfully");
                    String log = "Teacher's password was changed with this id  " + teacher.getId() + " " + teacher.getName() + " "+ teacher.getSurname() + " Time : " + LocalDateTime.now();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                    return;
                }
            }

        }
        System.out.println("There is not any Student or Teacher with this id");

    }

    @Override
    public void searchUserById() {
        int id =Util.requireInt("Insert id number");
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);

            if (person instanceof Student){
                Student student = (Student) person;
                if (id == student.getId()) {
                    System.out.println(student);
                    return;
                }
            }
            else if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (id==teacher.getId()){
                    System.out.println(teacher);
                    return;
                }
            }
        }
        System.out.println("There is not any Student or Teacher with this id ");
    }

    @Override
    public boolean backToLogin() {
        return true;
    }

    @Override
    public void seeAllUser() {
        Util.printAllUsers();
    }

    @Override
    public void exit() {
        System.out.println("Program ended.BYE!");
        System.exit(0);
    }

    private String getUsername(String name ,String surname){

        Random random = new Random();
        int randomNum = random.nextInt(10000);
        String username = name.substring(0,3) + surname.substring(0,3)+randomNum;
        return username;
    }

    private LocalDate getBirthDate(){

        int year = Util.requireInt("Enter birth year ");
        int month = Util.requireInt("Enter birth month ");
        int day = Util.requireInt("Enter birth day ");

        return LocalDate.of(year,month,day);
    }

    private  Classes getClasses (){
        Util.printClasses();
        String className = Util.requireString("Please insert class name which you want to add Teacher");
        for (int i = 0; i < GlobalData.classesDinamicArray.getSize(); i++) {
            Classes classes = GlobalData.classesDinamicArray.get(i);
            if (classes.getClassName().equalsIgnoreCase(className)){
                return classes;
            }
        }
        return null;
    }
}
