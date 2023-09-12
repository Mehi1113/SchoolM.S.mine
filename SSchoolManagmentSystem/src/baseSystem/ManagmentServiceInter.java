package baseSystem;

import users.Person;

public interface ManagmentServiceInter {

    boolean adminSpefication();
    boolean teacherSpefication();
    boolean studentSpefication(Person person);
    void printFirstMenu();
}
