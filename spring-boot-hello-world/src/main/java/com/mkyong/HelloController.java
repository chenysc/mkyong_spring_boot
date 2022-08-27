package com.mkyong;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    String hello() {
        return "Hello World, Spring Boot!";
    }

    
    // My cookie test
    @GetMapping("/myReadCookieTest")
    public String readCookie(@CookieValue(value = "username", 
   		                                  defaultValue = "Atta") String username) {
    	return ("Hey! My username is " + username);
    }

    
    @GetMapping("/change-username")
    public String setCookie(HttpServletResponse response) {
	    // 創建一個 cookie對象
	    //Cookie cookie = new Cookie("username", "Jovan");
    	Cookie cookie = new Cookie("username", "CHENYSC");
	    //將cookie對象加入response響應
	    response.addCookie(cookie);
	    return ("Username is changed!");
    }
    
    
    
    
    
    
    
}