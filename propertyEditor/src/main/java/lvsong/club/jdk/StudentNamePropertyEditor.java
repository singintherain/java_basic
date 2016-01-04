package lvsong.club.jdk;

import java.beans.PropertyEditorSupport;

/**
 * Created by lvsong on 1/3/16.
 */
public class StudentNamePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String value) {
        setValue(value);
    }
}
