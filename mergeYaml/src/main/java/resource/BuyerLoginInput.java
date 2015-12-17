package resource;

import config.BuyerLoginElement;
import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by lvsong on 6/25/15.
 */
public class BuyerLoginInput {
    public static BuyerLoginElement element;
    private final static String loginFilePath = "src/main/resources/buyer_login_page.yml";

    static {
        File file = new File(loginFilePath);
        HashMap<String, BuyerLoginElement> elements = null;
        try {
            elements = (HashMap<String, BuyerLoginElement>) Yaml.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println(elements.get("buyer_login").getClass().getName());
//        System.out.println(elements.get("buyer_login").getClass().getName());
//        HashMap<String, BuyerLoginElement> elementHashMap =
//                (HashMap<String, BuyerLoginElement>) Yaml.load(loginFilePath);
//        element = elementHashMap.get("buyer_login");
        element = elements.get("buyer_login");
    }
}
