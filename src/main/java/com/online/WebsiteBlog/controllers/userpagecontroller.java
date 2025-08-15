package com.online.WebsiteBlog.controllers;

import com.online.WebsiteBlog.users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.HashMap;
import java.util.Map;


//@RestController
@Controller
public class userpagecontroller {


    @PostMapping("/submitLogin")
    public String submitLogin(@ModelAttribute("loginFormData") User data, Model model){
        model.addAttribute("user", data.getUsername());
        model.addAttribute("texts", homepagecontroller.stringOfText);
        homepagecontroller.user = data;
        return "homepage";
    }

}
