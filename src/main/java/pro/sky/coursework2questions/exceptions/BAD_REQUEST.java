package pro.sky.coursework2questions.exceptions;

public class BAD_REQUEST extends RuntimeException {

    public BAD_REQUEST() {
    }

    public BAD_REQUEST(String message) {
        super(message);
    }

    public BAD_REQUEST(String message, Throwable cause) {
        super(message, cause);
    }

    public BAD_REQUEST(Throwable cause) {
        super(cause);
    }

    public BAD_REQUEST(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
