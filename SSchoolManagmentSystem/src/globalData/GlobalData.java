package globalData;

import baseSystem.GlobalStrings;

import dinamicArray.ClassesDinamicArray;
import dinamicArray.PersonDinamicArray;

import users.Person;

import util.FileUtils;




public class GlobalData {

    public static int id=1;
    public static Person loggedInPerson = null;


    public static PersonDinamicArray  personDinamicArray=new PersonDinamicArray();
    public  static ClassesDinamicArray classesDinamicArray = new ClassesDinamicArray();

    static {

//        Classes classes = new Classes();
//        classes.setClassname("11A");
//        classes.setStudentsDinamicArray(new PersonDinamicArray());
//
//        Classes classes2 = new Classes();
//        classes2.setClassname("10A");
//        classes2.setStudentsDinamicArray(new PersonDinamicArray());
//        classesDinamicArray.add(classes);
//        classesDinamicArray.add(classes2);

        classesDinamicArray=FileUtils.readClassesFile(GlobalStrings.SAVE_CLASSES_FILE_NAME);
        personDinamicArray= FileUtils.readALl("person.ser");
        id = personDinamicArray.getSize();
//
//
//        Admin admin = new Admin("Mehi","MeR", LocalDate.of(1996,10,6),1000,id++,
//                "admin@gmail.com","mehman","1234");
//
//
//        Teacher teacher = new Teacher("Teacher","Teacher","teacher", "1234",
//                LocalDate.of(1990,01,01),850,id++,"teacher@gmail.com",new Classes());
//
//
//        Student student = new Student("Student","Student","student", "1234",
//                LocalDate.of(2005,1,1),id++,"student@gmail.com");
//
//
//        personDinamicArray.add(admin);
//        personDinamicArray.add(student);
//        personDinamicArray.add(teacher);

   }

}
