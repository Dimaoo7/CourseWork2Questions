package pro.sky.coursework2questions.exceptions;

public class AmountOutOfCollectionBoundException extends RuntimeException {
    public AmountOutOfCollectionBoundException() {
    }

    public AmountOutOfCollectionBoundException(String message) {
        super(message);
    }

    public AmountOutOfCollectionBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountOutOfCollectionBoundException(Throwable cause) {
        super(cause);
    }

    public AmountOutOfCollectionBoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
