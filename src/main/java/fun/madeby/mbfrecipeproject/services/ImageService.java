package fun.madeby.mbfrecipeproject.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

/**
 * Created by Gra_m on 2022 04 25
 */


public interface ImageService {
    Set<MultipartFile> getImages();
    MultipartFile getImageById(String aString);
    void saveImage(MultipartFile image, String id);
    void deleteImageById(String id);
}
