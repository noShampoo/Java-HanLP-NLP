package team.wsfp.project.domain;

import java.io.Serializable;

public class Problem implements Serializable {
    private Integer problemNum;
    private String problemDesc;
    private String standardAnswer;
    private String studentAnswer;
    private Integer sysScore;
    private String userId;

    public Integer getProblemNum() {
        return problemNum;
    }

    public void setProblemNum(Integer problemNum) {
        this.problemNum = problemNum;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getStandardAnswer() {
        return standardAnswer;
    }

    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public Integer getSysScore() {
        return sysScore;
    }

    public void setSysScore(Integer sysScore) {
        this.sysScore = sysScore;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Problem(Integer problemNum, String problemDesc,
                   String standardAnswer, String studentAnswer,
                   Integer sysScore, String userId) {
        this.problemNum = problemNum;
        this.problemDesc = problemDesc;
        this.standardAnswer = standardAnswer;
        this.studentAnswer = studentAnswer;
        this.sysScore = sysScore;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemNum=" + problemNum +
                ", problemDesc='" + problemDesc + '\'' +
                ", standardAnswer='" + standardAnswer + '\'' +
                ", studentAnswer='" + studentAnswer + '\'' +
                ", sysScore=" + sysScore +
                ", userId='" + userId + '\'' +
                '}';
    }
}
