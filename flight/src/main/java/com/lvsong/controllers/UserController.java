package com.lvsong.controllers;

import com.lvsong.models.User;
import com.lvsong.services.UserService;
import com.lvsong.validators.UserFormValidator;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

/**
 * Created by lvsong on 7/17/15.
 */
@Controller
public class UserController {
//    private static Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    UserFormValidator userFormValidator;
//
//    // set a form validator
////    @InitBinder
////    protected void initBinder(WebDataBinder binder) {
////        binder.setValidator(userFormValidator);
////    }
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(Model model) {
//        logger.debug("user index");
//
//        return "index";
//    }
//
//    // list page
//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String showAllUsers(Model model) {
//        logger.debug("show all users");
//        model.addAttribute("users", userService.findAll());
//        return "list";
//    }
//
//    // save or update user
//    // 1. @ModelAttribute bind form value
//    // 2. @Validated form validator
//    // 3. RedirectAttibutes for flash value
//    @RequestMapping(value = "/users", method = RequestMethod.POST)
//    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
//                                   BindingResult result, Model model,
//                                   final RedirectAttributes redirectAttributes) {
//
//        logger.debug("save or update user: {}", user);
//
//        if(result.hasErrors()) {
//            populateDefaultModel(model);
//
//            return "user/userForm";
//        } else {
//            redirectAttributes.addFlashAttribute("css", "success");
//            if(user.isNew()) {
//                redirectAttributes.addFlashAttribute("msg", "User added successfully");
//            } else {
//                redirectAttributes.addFlashAttribute("msg", "User updated successfully");
//            }
//
//            userService.saveOrUpdate(user);
//
//            return "redirect:/users/" + user.getId();
//        }
//    }
//
//    // show add user form
//    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
//    public String showAddUserForm(Model model) {
//        logger.debug("show add user form");
//
//        User user = new User();
//
//        user.setName("mkyong123");
//        user.setEmail("test@gmail.com");
//        user.setAddress("abc 88");
//        user.setNewsletter(true);
//        user.setSex("M");
//        user.setFramework(new ArrayList<String>(Arrays.asList("Spring MVC", "GWT")));
//        user.setSkill(new ArrayList<String>(Arrays.asList("Spring", "Grails", "Groovy")));
//        user.setCountry("SG");
//        user.setNumber(2);
//        model.addAttribute("userForm", user);
//
//        populateDefaultModel(model);
//
//        return "users/userform";
//    }
//
//    // show updated user form
//    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
//    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {
//        logger.debug("showUpdateUserForm() : {}", id);
//
//        User user = userService.findById(id);
//
//        model.addAttribute("userForm", user);
//
//        populateDefaultModel(model);
//
//        return "users/userform";
//    }
//
//    // delete user
//    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
//    public String deleteUser(@PathVariable("id") int id,
//                             final RedirectAttributes redirectAttributes) {
//        logger.debug("delete user : {}", id);
//
//        userService.delete(id);
//
//        redirectAttributes.addFlashAttribute("css", "success");
//        redirectAttributes.addFlashAttribute("msg", "User is deleted!");
//
//        return "redirect:/users";
//    }
//
//    // show user
//    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
//    public String showUser(@PathVariable("id") int id, Model model) {
//        logger.debug("show user : {}", id);
//
//        User user = userService.findById(id);
//        if(user == null) {
//            model.addAttribute("css", "danger");
//            model.addAttribute("msg", "User not found");
//        }
//
//        model.addAttribute("user", user);
//
//        return "users/show";
//    }
//
//    private void populateDefaultModel(Model model) {
//
//        List<String> frameworksList = new ArrayList<String>();
//        frameworksList.add("Spring MVC");
//        frameworksList.add("Struts 2");
//        frameworksList.add("JSF 2");
//        frameworksList.add("GWT");
//        frameworksList.add("Play");
//        frameworksList.add("Apache Wicket");
//        model.addAttribute("frameworkList", frameworksList);
//
//        Map<String, String> skill = new LinkedHashMap<String, String>();
//        skill.put("Hibernate", "Hibernate");
//        skill.put("Spring", "Spring");
//        skill.put("Struts", "Struts");
//        skill.put("Groovy", "Groovy");
//        skill.put("Grails", "Grails");
//        model.addAttribute("javaSkillList", skill);
//
//        List<Integer> numbers = new ArrayList<Integer>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(5);
//        model.addAttribute("numberList", numbers);
//
//        Map<String, String> country = new LinkedHashMap<String, String>();
//        country.put("US", "United Stated");
//        country.put("CN", "China");
//        country.put("SG", "Singapore");
//        country.put("MY", "Malaysia");
//        model.addAttribute("countryList", country);
//
//    }


}
