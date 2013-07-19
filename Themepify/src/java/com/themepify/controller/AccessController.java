package com.themepify.controller;

import com.themepify.dto.UserDto;
import com.themepify.entity.Uploader;
import com.themepify.query.QueryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class AccessController {

    @Autowired
    QueryHelper queryhelper;

    @RequestMapping("/login")
    public String login() {
        return "access/login";
    }

    @RequestMapping("/denied")
    public String denied(ModelMap model) {
        model.addAttribute("error", "access.denied");
        return "error";
    }

    @RequestMapping("/login/failure")
    public String loginFailure(ModelMap model) {
        model.addAttribute("status", "login.failure");
        return "access/login";
    }

    @RequestMapping("/logout/success")
    public String logoutSuccess(ModelMap model) {
        model.addAttribute("status", "logout.success");
        return "access/login";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "access/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String createAccount(UserDto dto, ModelMap model) {
        
		if (queryhelper.getUploaderbyName(dto.getUsername()) != null) {
			model.addAttribute("status", "signup.invalid.username.duplicate");
			return "access/signup";
		}
		
		if (dto.getPassword().equals(dto.getRepassword()) == false) {
			model.addAttribute("status", "signup.invalid.password.notmatching");
			return "access/signup";
		}
		
		Uploader user = new Uploader();
                user.setId(2L);
                user.setName(dto.getUsername());
		PasswordEncoder encoder = new Md5PasswordEncoder();
		user.setPassword(encoder.encodePassword(dto.getPassword(), null));
//		user.setRole(new Role(RoleUtil.ROLE_USER, user));
		queryhelper.saveEntity(user);
		return "redirect:/";
	}
}