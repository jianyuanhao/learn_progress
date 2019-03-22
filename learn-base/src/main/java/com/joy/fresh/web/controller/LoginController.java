package com.joy.fresh.web.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joy.fresh.model.AccountInfo;
import com.joy.fresh.service.AccountInfoService;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private AccountInfoService accountInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public String loginHome(Model model) {
        model.addAttribute("accountInfo", new AccountInfo());
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginDeal(@Validated AccountInfo accountInfo, Errors errors, Model model, HttpServletRequest req,
            HttpServletResponse httpServletResponse) throws UnsupportedEncodingException {
        if (errors.hasErrors()) {
            return "login";
        } else {
            if (accountInfoService.queryAccountInfo(accountInfo)) {
                logger.info("校验成功！");
                model.addAttribute("userName", accountInfo.getUserName());
                return "redirect:/";
            } else {
                model.addAttribute("login_Failed", true);
                return "login";
            }
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutDeal(HttpServletResponse httpServletResponse) {
        return "redirect:/";
    }

}
