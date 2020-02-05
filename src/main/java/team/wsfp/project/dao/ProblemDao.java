package team.wsfp.project.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team.wsfp.project.domain.Problem;

import java.util.List;

//通过注解将dao交给IOC
@Repository
public interface ProblemDao {

    @Insert("insert into problem(problemNum, problemDesc, standarAnswer, studentAnswer, sysScore, userid)" +
            " values(#{problemNum}, #{problemDesc}, #{standardAnswer}, #{studentAnswer}, #{sysScore}, #{userId})")
    void insertProblem(Problem problem);

    @Select("select max(problemNum) from problem where userid = #{nowUserId}")
    Integer getProblemNumber(@Param("nowUserId") String nowUserId);

    @Select("select problemNum from problem where standarAnswer = #{standardAnswer} and studentAnswer = " +
            "#{studentAnswer}")
    List<Integer> savedProblem(@Param("standardAnswer") String standardAnswer,
                               @Param("studentAnswer") String studentAnswer);
}
