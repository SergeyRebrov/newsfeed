package ru.sibers.newsline.util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.sibers.newsline.util.exception.ImageUploadException;

import java.io.File;
import java.io.IOException;

/**
 * Utility for validate and uploading images.
 */
public class ImageUtil {

    /**
     * Checks MultipartFile
     * If there is an exception, throws ImageUploadException
     */
    private static void validateImage(MultipartFile image) throws ImageUploadException {

        if (image.isEmpty() || image.getSize() == 0)
            throw new ImageUploadException("Please select a file");

        if (image.getSize() > 1024 * 1024 * 5)
            throw new ImageUploadException("The file size should be no more than 5 MB");

        if (!(image.getContentType().equalsIgnoreCase("image/jpg")
                || image.getContentType().equalsIgnoreCase("image/jpeg")
                || image.getContentType().equalsIgnoreCase("image/png"))) {
            throw new ImageUploadException("Only jpeg, jpg, png images accepted");
        }
    }

    /**
     * Uploads the image into the file system
     * */
    public static String saveImage(MultipartFile image) throws ImageUploadException {
        validateImage(image);

        String pathToImage = null;
        try {
            File file = new File("C:/resources/images/" + image.getOriginalFilename());
            pathToImage = file.getAbsolutePath();
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new ImageUploadException("Unable to save image", e);
        }

        return pathToImage;
    }
}