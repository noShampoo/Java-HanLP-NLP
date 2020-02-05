package team.wsfp.project.service;

import java.util.List;
import java.util.Map;

public interface ProblemService {
    Boolean saveProblem(String problemDesc, String standardAnswer, String studentAnswer, Integer score);

    Map<String, Object> getResult(String standardAnswer, String studentAnswer, String standardKeyWord);

    Integer getProblemNumber(String nowUserId);

    Boolean isSaved(String standardAnswer, String studentAnswer);

    List<Integer> savedProblemNum(String standardAnswer, String studentAnswer);
}
