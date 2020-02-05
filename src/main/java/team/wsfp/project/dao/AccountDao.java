package team.wsfp.project.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team.wsfp.project.domain.Account;

import java.util.List;

//通过注解将dao交给IOC
@Repository
public interface AccountDao {

    @Select("select * from account")
    List<Account> findAll();

    @Select("select userid from account where username = #{userName}")
    String findNowUserId(@Param("userName") String userName);

    @Select("select username from account")
    List<String> findAlluserName();

    @Select("select * from account where username = #{userName}")
    Account findAccountByUser(@Param("userName") String userName);

    @Insert("insert into account(userid, username, password) values(#{userId}, #{userName}, #{password})")
    void insertAccount(Account account);
}
