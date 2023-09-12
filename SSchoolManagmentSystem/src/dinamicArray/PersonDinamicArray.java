package dinamicArray;
import users.Person;

import java.io.Serializable;

public class PersonDinamicArray implements Serializable {

    private Person[] persons;

    public PersonDinamicArray(){
        persons= new Person[0];
    }


    public void add(Person person){
        Person[] newPersonArray= new Person[persons.length+1];

        for (int i = 0; i < persons.length; i++) {
            newPersonArray[i]=persons[i];
        }
        newPersonArray[newPersonArray.length-1]=person;
        persons=newPersonArray;
    }

    public void delete(int index) throws IllegalAccessException{
        if (index>=persons.length || index<0){
            throw new IllegalAccessException();
        }

        Person[] newPersonArray = new Person[persons.length-1];

            for (int i = 0 ,k=0; i < persons.length; i++) {
                if (index == i) {
                    continue;
                }
                newPersonArray[k++] = persons[i];
            }
            persons=newPersonArray;
    }

    public Person get(int index){
        if (index<0 || index>= persons.length){
            throw new IllegalArgumentException();
        }
        return persons[index];
    }

    public int getSize(){
        return persons.length;
    }



}
