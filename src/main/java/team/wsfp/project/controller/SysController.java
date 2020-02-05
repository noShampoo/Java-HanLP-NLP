package team.wsfp.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.wsfp.project.service.ProblemService;
import team.wsfp.project.service.impl.AccountServiceImpl;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sysController")
public class SysController {
    @Autowired
    ProblemService problemService;

    @RequestMapping(value = "/getInformation.do" ,method = RequestMethod.POST)
    @ResponseBody
    public Map getInformation(@RequestParam("problem") String problem,
                              @RequestParam("standardAnswer") String standardAnswer,
                              @RequestParam("studentAnswer") String studentAnswer,
                              @RequestParam("standardKeyword") String standardKeyword) {
        System.out.println("problem:" + problem);
        System.out.println("standardAnswer:" + standardAnswer);
        System.out.println("studentAnswer:" + studentAnswer);
        System.out.println("standardKeyword:" + standardKeyword);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> result = problemService.getResult(standardAnswer, studentAnswer, standardKeyword);
        if (!result.isEmpty()) {
            map.put("code", "1");
            map.put("sysScore", String.valueOf(result.get("sysScore")));
            map.put("problemNum", String.valueOf(result.get("problemNum")));
        } else {
            map.put("code", "0");
        }
//        if (problemService.saveProblem(standardAnswer, studentAnswer)) {
//            map.put("code", "1");
//            map.put("score", "100");
//        } else {
//            map.put("code", "0");
//        }
        return map;
    }

    @RequestMapping(value = "/saveInformation.do", method = RequestMethod.POST)
    @ResponseBody
    public Map saveInformation(@RequestParam("problemDesc") String problemDesc,
                               @RequestParam("standardAnswer") String standardAnswer,
                           @RequestParam("studentAnswer") String studentAnswer,
                           @RequestParam("saveScore") String saveScore) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("saveScore:" + saveScore);
        System.out.println("standardAnswer:" + standardAnswer);
        System.out.println("studentAnswer:" + studentAnswer);
        if (!problemService.isSaved(standardAnswer, studentAnswer)) {
            if (problemService.saveProblem(problemDesc, standardAnswer, studentAnswer,
                    Integer.valueOf(saveScore))) {
                map.put("code", "0");
            } else {
                map.put("code", "1");
            }
        } else {
            System.out.println(String.valueOf(problemService.getProblemNumber(AccountServiceImpl.getNowAccount().getUserName())));
            map.put("code", "2");
            map.put("problemNum", String.valueOf(problemService.savedProblemNum(standardAnswer,
                    studentAnswer).get(0)));
        }
        return map;
    }
}
