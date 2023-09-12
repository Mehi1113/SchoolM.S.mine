package service.impl;

import classes.Classes;
import globalData.GlobalData;
import service.ClassesServiceInter;
import service.TeacherServiceInter;
import users.Student;
import util.Util;

public class TeacherServiceImpl implements TeacherServiceInter {

    ClassesServiceInter classesServiceInter = new ClassesServiceImpl();
    @Override
    public void seeAllStudents() {

        Util.printStudent();

    }

    @Override
    public void seeAllClasses() {

        for (int i = 0; i < GlobalData.classesDinamicArray.getSize(); i++) {
            Classes classes = GlobalData.classesDinamicArray.get(i);
            System.out.println(classes.getClassName() + " da oxuyan şagirdler : ");
            for (int j = 0; j <classes.getStudentsDinamicArray().getSize(); j++) {
                Student student = (Student) classes.getStudentsDinamicArray().get(j);
                System.out.println(student);
            }
            System.out.println();
        }
    }

    @Override
    public void addStudentToClasses() {

        classesServiceInter.addStudentToClass();

    }

    @Override
    public boolean backToLogin() {
    return true;
    }

    @Override
    public void exit() {
        System.out.println("Program ended.BYE!");
        System.exit(0);

    }
}
