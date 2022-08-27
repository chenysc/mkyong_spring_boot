package com.mkyong;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
    
    
    
    @GetMapping("/addCookies")
    public String addCookies(HttpServletResponse response) {
	    // 創建一個 cookie對象
    	Cookie cookie = new Cookie("A4SSOKey", "A4SSOCookieTest");
    	//將cookie對象加入response響應
    	//cookie.setMaxAge(7 * 24 * 60 * 60); // 7天過期
    	cookie.setMaxAge(1); // 1 sec
    	response.addCookie(cookie);
    	
    	Cookie cookie2 = new Cookie("MyAge", "28");
    	response.addCookie(cookie2);

    	Cookie cookie3 = new Cookie("MyGender", "Male");
    	response.addCookie(cookie3);
    		   
	    return ("Add cookies success!");
    }
    
    
    @GetMapping("/all-cookies")
    public String readAllCookies(HttpServletRequest request) {
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
		    return (Arrays.stream(cookies)
		                  .map(c -> c.getName() + "=" + c.getValue())
		                  .collect(Collectors.joining(", ")));
	    }
	    
	    return ("No cookies");
    }
    
    
    
}