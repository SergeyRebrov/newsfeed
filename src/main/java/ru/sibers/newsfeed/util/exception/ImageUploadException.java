package ru.sibers.newsfeed.util.exception;

/**
 * Image upload exception
 */
public class ImageUploadException extends RuntimeException {
    public ImageUploadException(String message) {
        super(message);
    }

    public ImageUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}