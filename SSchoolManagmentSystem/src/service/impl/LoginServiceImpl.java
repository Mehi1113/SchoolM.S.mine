package service.impl;

import globalData.GlobalData;
import service.LoginServiceInter;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;
import util.Util;

public class LoginServiceImpl implements LoginServiceInter {
    @Override
    public Person login(String username) {
        boolean isFounded=false;
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);

            if (person instanceof Admin) {
                Admin admin = (Admin) person;
                if (admin.getUsername().equals(username)) {
                    isFounded = true;
                    String password = Util.requireString("Enter password");
                    if (admin.getPassword().equals(password)) {
                        return admin;
                    } else {
                        System.out.println("Password wrong");
                        return null;
                    }
                }
            }


            else if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getUsername().equals(username)) {
                    isFounded = true;
                    if (teacher.isBlocked()){
                        System.out.println("You have been blocked.Please contact with Admin");
                        return null;
                    }
                    for (int j = 0; j < 3; j++) {
                        boolean bamUser = false;
                        String password = Util.requireString("Enter password");
                        if (teacher.getPassword().equals(password)) {
                            return teacher;
                        }
                        System.out.println("Wrong password. Remaining attempt - " + (3 - j - 1));

                        if (j == 2) {
                            teacher.blockTeacher();
                            return null;
                        }
                    }
                }
            }



            else if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getUsername().equals(username)) {
                    isFounded = true;
                    if (student.isBlocked()){
                        System.out.println("You have been blocked.Please contact with Admin");
                        return null;
                    }
                    for (int j = 0; j < 3; j++) {

                        boolean banUser = false;
                        String password = Util.requireString("Enter password");
                        if (student.getPassword().equals(password)) {
                            return student;
                        }
                        System.out.println("Wrong password.Remaning attempt - " + (3 - j - 1));

                        if (j == 2) {
                            student.blockStduent();
                            return null;
                        }
                    }
                }
            }
        }
         if (isFounded=false) {
             System.out.println("Username cannot find");
         }
        return null;
    }


    @Override
    public void exit() {
        System.exit(0);
        System.out.println("Program ended.BYE!");

    }
}
