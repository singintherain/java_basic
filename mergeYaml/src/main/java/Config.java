import org.ho.yaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by lvsong on 6/25/15.
 */
public class Config {
    public static List<Object> contents = new ArrayList<Object>();

    static{
        HashMap<String, HashMap<String, HashMap<String, String>>> content;
        System.out.println("config static");
        for(InputStream inputStream : Resources.inputStreams){
            content = (HashMap<String, HashMap<String, HashMap<String, String>>>)Yaml.load(inputStream);
            for(String key1 : content.keySet()){
                System.out.println(key1);
                HashMap<String, HashMap<String, String>> headContent = content.get(key1);
                for(String key2 : headContent.keySet()){
                    HashMap<String, String> content2 = headContent.get(key2);
                    for(String key3 : content2.keySet()){
                        System.out.println(content2.get(key3));
                    }
                }
            }
            System.out.println(content.keySet().size());
            contents.add(content);
        }
    }
}
