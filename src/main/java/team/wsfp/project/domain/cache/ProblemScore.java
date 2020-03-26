package team.wsfp.project.domain.cache;

public class ProblemScore {
    private int problemNum;
    private int problemScore;

    public ProblemScore(int problemNum, int problemScore) {
        this.problemNum = problemNum;
        this.problemScore = problemScore;
    }

    public int getProblemNum() {
        return problemNum;
    }

    public void setProblemNum(int problemNum) {
        this.problemNum = problemNum;
    }

    public int getProblemScore() {
        return problemScore;
    }

    public void setProblemScore(int problemScore) {
        this.problemScore = problemScore;
    }
}
