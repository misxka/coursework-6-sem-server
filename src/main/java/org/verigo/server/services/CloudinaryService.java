package org.verigo.server.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Cloudinary cloudinaryConfig;

    public String upload(MultipartFile multipartFile, String resourceType) {
        try {
            File file = convertMultiPartToFile(multipartFile);
            Map params = ObjectUtils.asMap(
                "resource_type", resourceType
            );
            Map uploadResult = cloudinaryConfig.uploader().upload(file, params);
            file.delete();
            String publicId = uploadResult.get("public_id").toString();
            logger.info("File " + publicId + " successfully uploaded.");
            return publicId;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
