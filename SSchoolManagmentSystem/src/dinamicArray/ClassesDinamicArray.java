package dinamicArray;

import classes.Classes;
import users.Person;

import java.io.Serializable;

public class ClassesDinamicArray implements Serializable {

    private Classes[] classes;

    public ClassesDinamicArray(){
        classes= new Classes[0];
    }


    public void add(Classes cls){
        Classes[] newClassesArray= new Classes[classes.length+1];

        for (int i = 0; i < classes.length; i++) {
            newClassesArray[i]=classes[i];
        }
        newClassesArray[newClassesArray.length-1]=cls;
        classes=newClassesArray;
    }

    public void delete(int index) throws IllegalAccessException{
        if (index>=classes.length || index<0){
            throw new IllegalAccessException();
        }

        Classes[] newClassesArray= new Classes[classes.length-1];


        for (int i = 0 ,k=0; i < classes.length; i++) {
            if (index == i) {
                continue;
            }
            newClassesArray[k++] =classes[i];
        }
        classes=newClassesArray;
    }

    public Classes get(int index){
        if (index<0 || index>= classes.length){
            throw new IllegalArgumentException();
        }
        return classes[index];
    }

    public int getSize(){
        return classes.length;
    }


}
