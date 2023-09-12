package menuEnums;

public enum StudentMenu {

    SEE_OWN_INFO(1,"See own information"),
    RESET_PASSWORD(2,"Reset password"),
    BACK_TO_LOGIN(3,"Back to login"),
    EXIT(0,"Exit!!!");
    private int id;
    public String option;

    StudentMenu(int id,String option){
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
