package service;

public interface AdminServiceInter {

    void addStudent();
    void addTeacher();
    void deleteUserById(int id);
    void updateUserById(int id);
    void blockUserById(int id);
    void openBlockById(int id);
    void searchUserByName();
    void changePasswordById();
    void searchUserById();
    boolean backToLogin();
    void seeAllUser();
    void exit();
}

