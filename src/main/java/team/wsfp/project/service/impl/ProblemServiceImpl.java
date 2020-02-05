package team.wsfp.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.wsfp.project.dao.AccountDao;
import team.wsfp.project.dao.ProblemDao;
import team.wsfp.project.domain.Problem;
import team.wsfp.project.service.ProblemService;
import team.wsfp.project.utils.textSimilarity.TextSimilarity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    ProblemDao problemDao;
    @Autowired
    AccountDao accountDao;

    @Override
    public Boolean saveProblem(String problemDesc, String standardAnswer, String studentAnswer,
                               Integer score) {
        String nowUserId = accountDao.findNowUserId(AccountServiceImpl.getNowAccount().getUserName());
        int problemNum = getProblemNumber(nowUserId) + 1;
        Problem problem = new Problem(problemNum, problemDesc, standardAnswer, studentAnswer, score,
                nowUserId);
        System.out.println(problem.toString());
        try {
            problemDao.insertProblem(problem);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Map<String, Object> getResult(String standardAnswer, String studentAnswer, String standardKeyWord) {
        Map<String, Object> map = new HashMap<>();
        int sysScore;
        String nowUserId = accountDao.findNowUserId(AccountServiceImpl.getNowAccount().getUserName());
        int problemNum = getProblemNumber(nowUserId) + 1;
        TextSimilarity textSimilarity = new TextSimilarity(standardAnswer, studentAnswer);
        double similarity = textSimilarity.compute();
        sysScore = (int)(similarity * 100);
        map.put("sysScore", sysScore);
        map.put("problemNum", problemNum);
        return map;
    }

    @Override
    public Integer getProblemNumber(String nowUserId) {
        return (problemDao.getProblemNumber(nowUserId) == null) ? 0 : problemDao.getProblemNumber(nowUserId);
    }

    @Override
    public Boolean isSaved(String standardAnswer, String studentAnswer) {
        return !(problemDao.savedProblem(standardAnswer, studentAnswer).isEmpty());
    }

    @Override
    public List<Integer> savedProblemNum(String standardAnswer, String studentAnswer) {
        return problemDao.savedProblem(standardAnswer, studentAnswer);
    }
}
