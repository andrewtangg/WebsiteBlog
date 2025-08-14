package com.online.WebsiteBlog.controllers;

import com.online.WebsiteBlog.form.Form;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


//@RestController
@Controller
public class homepagecontroller {
    @Value("${spring.application.name}")
    String appName;

    Map<String, Integer> inv;

    @GetMapping("/")
    public String homePage(Model model){
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
        model.addAttribute("text", form.getText());
        return homePage(model);
    }

    @GetMapping("/inventory")
    public String inventoryList(Model model){
        inv = new HashMap<>();
        inv.put("Apples", 3);
        inv.put("Oranges", 5);
        inv.put("Bananas", 0);
        model.addAttribute("inv", this.inv);
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
