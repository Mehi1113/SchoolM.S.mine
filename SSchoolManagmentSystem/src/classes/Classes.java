package classes;

import dinamicArray.PersonDinamicArray;

import java.io.Serializable;

public class Classes implements Serializable {
    private String classname;
    private PersonDinamicArray studentsDinamicArray;

    public Classes(){

    }
    public Classes(String classname, PersonDinamicArray studentsDinamicArray) {
        this.classname = classname;
        this.studentsDinamicArray = studentsDinamicArray;
    }

    public String getClassName() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public PersonDinamicArray  getStudentsDinamicArray() {
        return studentsDinamicArray;
    }

    public void setStudentsDinamicArray(PersonDinamicArray studentsDinamicArray) {
        this.studentsDinamicArray = studentsDinamicArray;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classname='" + classname + '\'' +
                ", studentsDinamicArray=" + studentsDinamicArray +
                '}';
    }
}
