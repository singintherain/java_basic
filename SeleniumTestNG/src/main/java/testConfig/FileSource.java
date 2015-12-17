package testConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by lvsong on 6/18/15.
 */
public class FileSource implements TestSourceLoader {
    private String filePath = "src/main/resources/testcases.xml";

    public FileSource(){}

    public FileSource(String filePath){
        this.filePath = filePath;
    }

    public InputStream testSource() {
        try {
            return new FileInputStream(new File(this.filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new Error("filePath not find");
        }
    }
}
