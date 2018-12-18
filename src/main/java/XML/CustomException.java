package XML;

public class CustomException extends Exception {
    String error;
    public CustomException(String error) {
        this.error = error;
    }
    public String getError() {
        return error;
    }
}
