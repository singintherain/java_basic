package config;

/**
 * Created by lvsong on 6/25/15.
 */
public class BuyerLoginElement {
    private String username_input;
    private String password_input;
    private String submit_button;

    public BuyerLoginElement(){}

    public String getUsername_input() {
        return username_input;
    }

    public void setUsername_input(String username_input) {
        this.username_input = username_input;
    }

    public String getPassword_input() {
        return password_input;
    }

    public void setPassword_input(String password_input) {
        this.password_input = password_input;
    }

    public String getSubmit_button() {
        return submit_button;
    }

    public void setSubmit_button(String submit_button) {
        this.submit_button = submit_button;
    }
}
