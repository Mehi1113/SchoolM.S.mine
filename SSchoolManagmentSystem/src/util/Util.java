package util;

import globalData.GlobalData;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;

import java.time.LocalDate;
import java.util.Scanner;

public class Util {

    public static int requireInt(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + " : ");
        return sc.nextInt();
    }

    public static String requireString(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + " : ");
        return sc.nextLine();
    }

    public static double requireDouble(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + " : ");
        return sc.nextDouble();
    }

    public static LocalDate requireLocalDate(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + " : ");
        System.out.println("Year : ");
        int year = sc.nextInt();
        System.out.println("Month : ");
        int month = sc.nextInt();
        System.out.println("Day : ");
        int day = sc.nextInt();
        LocalDate localDate = LocalDate.of(year, month, day);

        return localDate;
    }


    public static boolean printUserExceptAdmin() {
        boolean isFound = false;
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student) {
                isFound = true;
                Student student = (Student) person;
                System.out.println(student);
            }
            if (person instanceof Teacher) {
                isFound = true;
                Teacher teacher = (Teacher) person;
                System.out.println(teacher);
            }
        }
        return isFound;
    }

    public static boolean printStudent() {
        boolean isFound = false;
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                isFound=true;
                System.out.println(student);
            }
        }
        return isFound;
    }

    public static void printClasses(){
        for (int i = 0; i < GlobalData.classesDinamicArray.getSize(); i++) {
            System.out.println(GlobalData.classesDinamicArray.get(i).getClassName());
        }
    }

    public static void printAllUsers(){
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (!(person instanceof Admin)){
                System.out.println(person);
            }
        }
    }

}

