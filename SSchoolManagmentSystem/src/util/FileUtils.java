package util;

import dinamicArray.ClassesDinamicArray;
import dinamicArray.PersonDinamicArray;
import globalData.GlobalData;

import java.io.*;

public class FileUtils {

    public static void saveAll(String fileName) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(GlobalData.personDinamicArray);
            objectOutputStream.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public  static void saveClasses(String fileName){
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(GlobalData.classesDinamicArray);
            objectOutputStream.flush();

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static ClassesDinamicArray readClassesFile(String fileName){
        try(FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
           ClassesDinamicArray classesDinamicArray = (ClassesDinamicArray) objectInputStream.readObject();
           return classesDinamicArray;
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static PersonDinamicArray readALl(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            PersonDinamicArray personDinamicArray = (PersonDinamicArray) objectInputStream.readObject();
            return personDinamicArray;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public static void writeLogToFile(String fileName, String log) {
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName,true));
            buffer.write(log);
            buffer.newLine();
            buffer.flush();
            buffer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
