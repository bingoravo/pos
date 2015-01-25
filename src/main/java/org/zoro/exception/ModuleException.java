package org.zoro.exception;

public class ModuleException extends Exception {

    String message = "Please try again later";

    /**
     * 
     */
    private static final long serialVersionUID = -1093113587158759237L;

    public ModuleException(String message) {
	this.message = message;
    }

    public String getMessage() {
	return message;
    }

}
