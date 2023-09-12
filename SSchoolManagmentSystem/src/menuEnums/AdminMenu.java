package menuEnums;

public enum AdminMenu {
    ADD_STUDENT(1,"Add student"),
    ADD_TEACHER(2,"Add teacher"),
    DELETE_USER_BY_ID(3,"Delete user by id"),
    UPDATE_USER_BY_ID(4,"Update user by id"),
    BLOCK_USER_BY_ID(5,"Block user by id"),
    OPEN_BLOCK_BY_ID(6,"Open block by id"),
    SEARCH_USER_BY_NAME(7,"Search user by name"),
    CHANGE_PASSWORD_BY_ID(8,"Change password by id"),
    SEARCH_USER_BY_ID(9,"Search user by id"),
    BACK_TO_LOGIN(10,"Back to login"),
    SEE_ALL_USER(11,"See all user"),
    EXIT(0,"Exit!!!");



    private int id;
    private String option;
    AdminMenu(int id,String option){
        this.id=id;
        this.option=option;
    }

    public int getId(){
        return id;
    }
    public String getOption(){
        return option;
    }

}
