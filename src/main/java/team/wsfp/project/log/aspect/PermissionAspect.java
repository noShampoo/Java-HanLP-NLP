package team.wsfp.project.log.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class PermissionAspect {
	
	@Before("@annotation(team.wsfp.project.log.annotation.AccountAccess)")
	public void paramCheck(JoinPoint joinPoint) throws Exception{
		System.out.println(joinPoint.getArgs().toString());
		/// 这里是在进入controller之前进行的数据验证
	}


}
