package com.github.sergeyrebrov.newsfeed.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import com.github.sergeyrebrov.newsfeed.util.exception.ImageUploadException;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Utility for validate and uploading images.
 */

public class ImageUtil {

    private static final ResourceBundle resources = ResourceBundle.getBundle("app");

    /**
     * Checks MultipartFile
     * If there is an exception, throws ImageUploadException
     */
    private static void validateImage(MultipartFile image) throws ImageUploadException {

        if (image.isEmpty() || image.getSize() == 0)
            throw new ImageUploadException("Please select a file");

        int maxSize = 5;

        try {
            maxSize = Integer.parseInt(resources.getString("file.maxSize")); // Get the value from properties
        } catch (NumberFormatException ignore) {
        }

        if (image.getSize() > 1024 * 1024 * maxSize)
            throw new ImageUploadException("The file size should be no more than " + maxSize + " MB");

        if (!(image.getContentType().equalsIgnoreCase("image/jpg")
                || image.getContentType().equalsIgnoreCase("image/jpeg")
                || image.getContentType().equalsIgnoreCase("image/png"))) {
            throw new ImageUploadException("Only jpeg, jpg, png images accepted");
        }
    }

    /**
     * Uploads the image into the file system
     */
    public static String saveImage(MultipartFile image) throws ImageUploadException {
        validateImage(image);

        String pathToImage = null;
        try {
            File file = new File(resources.getString("file.directory") + File.separator + image.getOriginalFilename());
            pathToImage = file.getAbsolutePath();
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new ImageUploadException("Unable to save image", e);
        }

        return pathToImage;
    }
}