package bookstoreinventorymanagementsystem;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 *
 * @author coco1
 */
public class EmailTemplateLoader {
    
    public static String loadTemplate(String templateName) throws IOException {
        File templateFile = new File(templateName);
        if (!templateFile.exists()) {
            throw new IOException("Template file not found: " + templateName);
        }
        return Files.readString(templateFile.toPath(), StandardCharsets.UTF_8);
    }
}
