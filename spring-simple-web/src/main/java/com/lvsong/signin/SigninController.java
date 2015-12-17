package com.lvsong.signin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SigninController {

	@RequestMapping(value = "signin")
	public String signin(Model model) {
        String text = "text2";
        model.addAttribute("text", text);
        return "signin/signin";
    }
}
