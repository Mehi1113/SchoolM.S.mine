package service.impl;

import baseSystem.GlobalStrings;
import service.StudentServiceInter;
import users.Person;
import users.Student;
import util.FileUtils;
import util.Util;

import java.time.LocalDateTime;
import java.util.Set;

public class StudentServiceImpl implements StudentServiceInter {
    @Override
    public void seeOwnInfo(Person person) {
        Student student = (Student) person;
        System.out.println(student);

    }

    @Override
    public void resetPassword(Person person) {
        Student student =(Student) person;
        String oldPassword = Util.requireString("Please insert old password : ");

        if (oldPassword.equals(student.getPassword())){
            String newPassword = Util.requireString("Insert new password : ");
            student.setPassword(newPassword);
            System.out.println("Password was changed successfully");
            String log = "Student reset own password  " + student.getName() + " "+ student.getSurname() + " Time : " + LocalDateTime.now();
            FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
        }else {
            System.out.println("Wrong password ");

        }

    }

    @Override
    public boolean backToLogin() {
    return true;
    }

    @Override
    public void exit() {
        System.exit(0);
        System.out.println("Program ended.BYE!");


    }
}
