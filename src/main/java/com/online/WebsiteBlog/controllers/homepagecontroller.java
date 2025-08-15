package com.online.WebsiteBlog.controllers;

import com.online.WebsiteBlog.form.Form;
import com.online.WebsiteBlog.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


//@RestController
@Controller
public class homepagecontroller {
    @Value("${spring.application.name}")
    String appName;

    public static User user;

    public static List<String> stringOfText;

    Map<String, Integer> inv;

    @GetMapping("/")
    public String homePage(Model model){
        return "homepage";
    }

    @GetMapping("/logout")
    public String logoutPage(Model model){
        user = null;
        return "homepage";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "loginpage";
    }

    @GetMapping("/notes")
    public String noteNavBar(){
        return "notes";
    }

    @GetMapping("/form")
    public String showForm(Model model){
//        model.addAttribute("form", new Form());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("textInputForm") Form form, Model model){
        if(stringOfText == null){
            stringOfText = new ArrayList<String>();
        }
        stringOfText.add(form.getText());
        model.addAttribute("texts", stringOfText);
        model.addAttribute("user", user.getUsername());
        return homePage(model);
    }

//    @RequestMapping("/addUser")
//    @PostMapping
//    public ResponseEntity<HttpStatus> addUser(@RequestBody CustomerInformation custInfo){
//        loggedInUser = custInfo;
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping("/userLoggedIn")
//    public ResponseEntity<CustomerInformation> getUser(){
//        return new ResponseEntity<>(loggedInUser, HttpStatus.FOUND);
//    }
}
