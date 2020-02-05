package team.wsfp.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/pageController")
public class PageController {
    @RequestMapping(value = "/test.do", method = RequestMethod.POST)
    @ResponseBody
    public Map test(@RequestParam("data") String data) {
        System.out.println("data:" + data);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        return map;
    }
}
