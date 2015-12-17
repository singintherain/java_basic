package com.lvsong.web;

import com.lvsong.domain.User;

/**
 * Created by lvsong on 7/21/15.
 */
public class BaseController {
    protected User getSessionUser() {
        User user = new User();

        return user;
    }

    protected void redirectTo(String url) {

    }

    protected boolean checkLogined() {
        return true;
    }
}
