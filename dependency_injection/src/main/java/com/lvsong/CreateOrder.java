package com.lvsong;

import java.util.List;

/**
 * Created by lvsong on 7/10/15.
 */
public class CreateOrder implements IAction {
    private List<IAction> actionList;

    public void run() {
        for(IAction action : getActionList()) {
            action.run();
        }
    }

    public List<IAction> getActionList() {
        return actionList;
    }

    public void setActionList(List<IAction> actionList) {
        this.actionList = actionList;
    }
}
