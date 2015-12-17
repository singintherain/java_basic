package testcase;

import action.*;
import org.dom4j.Element;

/**
 * 将测试用例的各种动作翻译成具体的action
 * Created by lvsong on 6/18/15.
 */
public class ActionTranslation {
    private IAction action;
    /**
     * 关联XML格式解析后的最小的元素，因为只有最小的元素定义了action
     */
    private Element element;

    public ActionTranslation(Element element){
        this.element = element;
    }

    public void start(){
        String name = getElement().attributeValue("name");
//        System.out.println(name);

        if(name.equals("click")){
            translateClickAction();
        } else if(name.equals("sendKeys")){
            translateSendKeysAction();
        } else if(name.equals("visit")) {
            translateVisitAction();
        } else if(name.equals("sleep")) {
            translateSleepAction();
        } else if(name.equals("buyerLogin")) {
            translateBuyerLogin();
        } else {
            throw new Error("测试用例中有不能被识别的action");
        }
    }

    public IAction getAction() {
        return this.action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    private void translateClickAction(){
        Click action = new Click();
        action.setElementPath(getElement().attributeValue("xpath"));

        setAction(action);
    }

    private void translateSendKeysAction(){
        String elementPath = getElement().attributeValue("xpath");
        String value = getElement().getTextTrim();
        SendKeys action = new SendKeys(elementPath, value);

        setAction(action);
    }

    private void translateVisitAction(){
        String url = getElement().attributeValue("url");
        Visit action = new Visit(url);

        setAction(action);
    }

    private void translateSleepAction(){
        int time = Integer.valueOf(getElement().attributeValue("time"));
        Sleep action = new Sleep(time);

        setAction(action);
    }

    private void translateBuyerLogin(){
        String username = getElement().attributeValue("username");
        String pwd = getElement().attributeValue("password");

        BuyerLogin action = new BuyerLogin(username, pwd);

        setAction(action);
    }

    private Element getElement(){
        return this.element;
    }

}
