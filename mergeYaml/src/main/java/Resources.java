import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvsong on 6/25/15.
 */
public class Resources {
    private final static String sourceDir = "src/main/resources";

    public static List<InputStream> inputStreams;

    static{
        inputStreams = new ArrayList<InputStream>();

        File file = new File(sourceDir);

        readAllYamlFiles(inputStreams, file);
    }

    private static void readAllYamlFiles(List<InputStream> resources, File file){
        if(file.isFile()){
            try {
                resources.add(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            File[] files = file.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    String fileName = pathname.getName();

                    return fileName.matches(".*\\.yml$");
                }
            });

            for(int i = 0; i < files.length; i++){
                readAllYamlFiles(resources, files[i]);
            }
        }
    }
}
