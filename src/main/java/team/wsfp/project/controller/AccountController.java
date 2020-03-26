package team.wsfp.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.wsfp.project.log.annotation.AccountAccess;
import team.wsfp.project.service.AccountService;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "accountController")
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @AccountAccess
    @RequestMapping(value = "checkLogin.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkLogin(@RequestParam("userName") String userName,
                                          @RequestParam("password") String password) {
        System.out.println(userName + "  " + password);
        Map<String, Object> map = new HashMap<>();
        Boolean flag = accountService.checkAccountByUser(userName, password);
        if(flag) {
            map.put("code", "1");
        } else {
            map.put("code", "0");
        }
        return map;
    }

    /**
     * 注册
     * @param regUserName
     * @param regPassword
     * @param reRegPassword
     * @return
     */
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public Map register(@RequestParam("regUserName") String regUserName,
                        @RequestParam("regPassword") String regPassword,
                        @RequestParam("reRegPassword") String reRegPassword) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(regUserName + "  " + regPassword + "  " + reRegPassword);
//        map.put("status", "200");
//        if (regPassword.equals(reRegPassword)) {
//            if (accountService.registerAccount(regUserName, regPassword)) {
//                map.put("code", "1");
//            } else {
//                map.put("code", "2");
//            }
//        } else {
//            map.put("code", "0");
//        }
        if (!accountService.havingAccount(regUserName)) {
            if (regPassword.equals(reRegPassword)) {
                if (accountService.registerAccount(regUserName, regPassword)) {
                    map.put("code", "success");
                } else map.put("code", "failed");
            } else map.put("code", "passwords are not equal twice");
        } else map.put("code", "the account already exists");
        return map;
    }

}
