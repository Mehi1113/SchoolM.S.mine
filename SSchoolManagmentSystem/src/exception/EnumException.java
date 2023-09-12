package exception;

public enum EnumException {

    USER_NOT_FOUND_EXCEPTION("There is not user in System");

    private String message;
    private EnumException(String message){
     this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
