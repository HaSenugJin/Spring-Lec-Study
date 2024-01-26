package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@RestController // 리턴시에 그 문자를 그대로 응답 (메시지를 그대로 응답)
@Controller // 리턴시에 파일을 응답한다 (파일을 찾아서 포워드해줌)
public class UserController {

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }


    @PostMapping("/join")
    public String join(String username, String password, String email) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");

        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("email: " + email);

        if (username.length() > 10) {
            return "error-404";
        }

        // 메인컨트롤러를 이미 만들어 둿으니 리다이랙션 해야 한다.
        // 절대 뷰를 리턴하면 안되고 만들어둔 컨트롤러를 찾아줘야 한다.
        return "redirect:/main";
    }
}