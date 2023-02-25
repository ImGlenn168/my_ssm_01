package com.java.controller;

import com.java.domain.Account;
import com.java.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/account/findAll")
    public String findAll(Model model) {
        System.out.println("Controller表现层：查询所有账户...");
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";  //在视图解析器中配置了前缀后缀
    }

    @PostMapping("/account/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Controller表现层：查询所有账户...");
        boolean b = accountService.addAccount(account);
        if (b) {
            System.out.println("添加成功！！！");
        } else {
            System.out.println("添加失败！！！");
        }
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

}
