package service.impl;

import baseSystem.GlobalStrings;
import classes.Classes;
import globalData.GlobalData;
import service.ClassesServiceInter;
import users.Person;
import users.Student;
import util.FileUtils;
import util.Util;

import java.time.LocalDateTime;

public class ClassesServiceImpl implements ClassesServiceInter {
    @Override
    public void addStudentToClass() {
        Util.printStudent();
        int studentId = Util.requireInt("Please insert student id which want to add to class");
        Student selectedStudent = getStudentById(studentId);

        Util.printClasses();
        String selectedClassName = Util.requireString("Please enter class to add student ");
        Classes selectedClass = null;
        for (int i = 0; i < GlobalData.classesDinamicArray.getSize(); i++) {
            Classes classes = GlobalData.classesDinamicArray.get(i);
            if (classes.getClassName().equalsIgnoreCase(selectedClassName)){
                selectedClass = classes;
            }
        }

        selectedClass.getStudentsDinamicArray().add(selectedStudent);
        System.out.println("Student " + selectedStudent.getName() +  " added new class " + selectedClass.getClassName());
        String log ="Student " + selectedStudent.getName() +  " added new class " + selectedClass.getClassName() + " Time : " + LocalDateTime.now() ;
        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
    }


    private Student getStudentById (int id){
        Student student = null;
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof  Student){
                Student selectedStudent = (Student) person;
                if (selectedStudent.getId() == id){
                    student = selectedStudent;
                    return student;
                }
            }
        }
        return student;
    }
}
