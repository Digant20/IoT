package com.iot.sample.json.schema.validation;

public class JsonSchemaLoadingFailedException extends RuntimeException {

    
	private static final long serialVersionUID = 1L;

	public JsonSchemaLoadingFailedException(String message) {
        super(message);
    }

    public JsonSchemaLoadingFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
