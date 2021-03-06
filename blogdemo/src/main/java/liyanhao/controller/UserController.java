package liyanhao.controller;

import liyanhao.model.User;
import liyanhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        //用户名/密码校验，省略，只做空的判断，跳转到login页面，校验通过，跳转首页/
        if(username == null || password == null)
            return "login";
        User user = userService.login(username, password);
        if(user == null)
            return "login";
        else{
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "/";
        }
    }
}
