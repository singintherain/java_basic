package lvsong.club.jdk;

import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by lvsong on 1/3/16.
 */
public class StudentSexPropertyEditor extends PropertyEditorSupport {
    private Map<String, Sex> stringSexMap;

    {
        stringSexMap = new HashMap<String, Sex>();
        stringSexMap.put("male", Sex.MALE);
        stringSexMap.put("female", Sex.FEMAL);
    }

    @Override
    public String[] getTags() {
        return stringSexMap.keySet().toArray(new String[]{});
    }

    @Override
    public String getJavaInitializationString() {
        return "" + getValue();
    }

    @Override
    public String getAsText() {
        Sex value = (Sex) getValue();

        for(Map.Entry<String, Sex> entry : stringSexMap.entrySet()) {
            if(value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }

        return "null";
    }

    @Override
    public void setAsText(String s) {
        for(String key : stringSexMap.keySet()) {
            if(s.equals(key)) {
                setValue(stringSexMap.get(key));
            }
        }
    }
}
