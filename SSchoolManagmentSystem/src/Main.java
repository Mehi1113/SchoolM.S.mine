import baseSystem.GlobalStrings;
import baseSystem.Managment;
import baseSystem.ManagmentServiceInter;
import globalData.GlobalData;
import service.LoginServiceInter;
import service.impl.LoginServiceImpl;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;
import util.FileUtils;
import util.Util;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        LoginServiceInter loginService = new LoginServiceImpl();
        ManagmentServiceInter managmentService = new Managment();

        while (true){
            managmentService.printFirstMenu();
            int option = 0;
            try {
                option = Util.requireInt("Choose option");
            }catch (InputMismatchException ex){
                System.out.println("Wrong input!");
                continue;
            }

            Person logedinPerson;
            switch (option){
                case 1:
                    String username = Util.requireString("Enter username");
                    boolean backToLogin =false;
                    logedinPerson = loginService.login(username);
                    GlobalData.loggedInPerson=logedinPerson;
                    if (logedinPerson!=null){
                        String log = "Person logged in " + logedinPerson.getName()+" "+logedinPerson.getSurname()  + "  Time " + LocalDateTime.now().toString();
                        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME,log);
                    }
                    if (logedinPerson instanceof Admin){
                        System.out.println("WELCOME dear "+logedinPerson.getName());
                       while (!backToLogin){
                           backToLogin=managmentService.adminSpefication();}

                    }else if (logedinPerson instanceof Teacher) {
                        System.out.println("WELCOME dear "+logedinPerson.getName());
                        while (!backToLogin){
                            backToLogin = managmentService.teacherSpefication();}

                    }else if (logedinPerson instanceof Student){
                        System.out.println("WELCOME dear "+logedinPerson.getName());
                        while (!backToLogin){
                            backToLogin = managmentService.studentSpefication(logedinPerson);}
                    }
                    break;
                case 0:
                    FileUtils.saveAll("person.ser");
                    FileUtils.saveClasses(GlobalStrings.SAVE_CLASSES_FILE_NAME);
                    loginService.exit();

                    break;
                default:
                    System.err.println("Choose correct option!!!");
            }
        }


    }
}