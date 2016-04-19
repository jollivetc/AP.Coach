package fr.apside.approjects.model;

public class GenericError {

    private String errorMessage;

    public GenericError() {
    }

    public GenericError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
