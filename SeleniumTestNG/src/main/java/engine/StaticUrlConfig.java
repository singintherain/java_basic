package engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lvsong on 6/18/15.
 */
public class StaticUrlConfig {
    private static final String urlConfigPath = "src/main/resources/staticUrls.properties";

    private static Properties properties(){
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(urlConfigPath);
            prop.load(fileInputStream);

            return prop;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new Error("没有发现静态url配置文件");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error("静态url配置文件读取出错：" + e.getMessage());
        }
    }

    public static String url(String key){
        return properties().getProperty(key);
    }
}
