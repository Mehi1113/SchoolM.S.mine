package baseSystem;
import exception.AppException;
import exception.EnumException;
import menuEnums.AdminMenu;
import menuEnums.FirstMenu;
import menuEnums.StudentMenu;
import menuEnums.TeacherMenu;
import service.AdminServiceInter;
import service.StudentServiceInter;
import service.TeacherServiceInter;
import service.impl.AdminServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;
import users.Person;
import util.FileUtils;
import util.Util;

public class Managment implements ManagmentServiceInter {

    AdminServiceInter adminService = new AdminServiceImpl();
    TeacherServiceInter teacherService = new TeacherServiceImpl();
    StudentServiceInter studentService = new StudentServiceImpl();

    @Override
    public boolean adminSpefication() {
        boolean backToLogin = false;
        printMenuForAdmin();
        int option = Util.requireInt("Choose option");
        int id = 0;
        boolean isTeacherOtStudentValid;

        switch (option) {
            case 1:
                adminService.addStudent();
                FileUtils.saveAll("person.ser");
                break;
            case 2:
                adminService.addTeacher();
                FileUtils.saveAll("person.ser");
                break;
            case 3:
                isTeacherOtStudentValid = Util.printUserExceptAdmin();
                try {
                    if (!isTeacherOtStudentValid) {
                        throw new AppException(EnumException.USER_NOT_FOUND_EXCEPTION);
                    }
                    int userId = Util.requireInt("Enter user's id,which want to delete");
                    adminService.deleteUserById(userId);
                } catch (AppException ex) {
                    System.out.println(ex.getMessage());
                }
                break;

            case 4:
                Util.printUserExceptAdmin();
                int idForUpdate = Util.requireInt("Enter person's id");
                adminService.updateUserById(idForUpdate);
                break;

            case 5:
                isTeacherOtStudentValid = Util.printUserExceptAdmin();
                if (isTeacherOtStudentValid) {
                    int userId = Util.requireInt("Enter user id,which want to block");
                    adminService.blockUserById(userId);

                } else System.err.println("There is not Student or Teacher in system with this id !");
                break;

            case 6:
                isTeacherOtStudentValid = Util.printUserExceptAdmin();
                if (isTeacherOtStudentValid) {
                    int userId = Util.requireInt("Enter user id,which want to unblock");
                    adminService.openBlockById(userId);
                } else System.err.println("There is not Student or Teacher in system with this id !");
                break;

            case 7:
                adminService.searchUserByName();
                break;
            case 8:
                adminService.changePasswordById();
                break;
            case 9:
                adminService.searchUserById();
                break;
            case 10:
                backToLogin = adminService.backToLogin();
                return backToLogin;
            case 11:
                adminService.seeAllUser();
                break;
            case 0:
                FileUtils.saveAll("person.ser");
                FileUtils.saveClasses(GlobalStrings.SAVE_CLASSES_FILE_NAME);
                adminService.exit();
                break;
            default:
                System.err.println("Choose correct option!");

        }

        return backToLogin;

    }

    @Override
    public boolean teacherSpefication() {
        printMenuForTeacher();
        int option = Util.requireInt("Choose option");
        switch (option) {
            case 1:
                teacherService.seeAllStudents();
                break;
            case 2:
                teacherService.seeAllClasses();
                break;
            case 3:
                teacherService.addStudentToClasses();
                FileUtils.saveAll("person.ser");
                break;
            case 4:
                return teacherService.backToLogin();

            case 0:
                FileUtils.saveAll("person.ser");
                FileUtils.saveClasses(GlobalStrings.SAVE_CLASSES_FILE_NAME);
                teacherService.exit();
                break;
            default:
                System.out.println("Choose correct option");
        }
        return false;
    }

    @Override
    public boolean studentSpefication(Person loggedInPerson) {
        printMenuForStudent();
        int option = Util.requireInt("Choose option");
        switch (option) {
            case 1:
                studentService.seeOwnInfo(loggedInPerson);
                break;
            case 2:
                studentService.resetPassword(loggedInPerson);
                break;
            case 3:
                return studentService.backToLogin();

            case 0:
                FileUtils.saveAll("person.ser");
                FileUtils.saveClasses(GlobalStrings.SAVE_CLASSES_FILE_NAME);
                studentService.exit();
                break;
            default:
                System.out.println("Choose correct option!");
        }

        return false;
    }

    public void printMenuForAdmin() {
        for (AdminMenu adminMenu : AdminMenu.values()) {
            System.out.println("[" + adminMenu.getId() + "]" + " ---->>>> " + adminMenu.getOption());
        }
    }


    public void printMenuForStudent() {
        for (StudentMenu studentMenu : StudentMenu.values()) {
            System.out.println("[" + studentMenu.getId() + "]" + " ---->>>> " + studentMenu.getOption());
        }
    }

    public void printMenuForTeacher() {
        for (TeacherMenu teacherMenu : TeacherMenu.values()) {
            System.out.println("[" + teacherMenu.getId() + "]" + " ---->>>> " + teacherMenu.getOption());
        }
    }

    public void printFirstMenu() {
        for (FirstMenu menu : FirstMenu.values()) {
            System.out.println("[" + menu.getId() + "]" + " ---->>>> " + menu.getOption());
        }
    }

}
