package demo6;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 切面类
 */
@Aspect
public class MyAspectAnno {

    @Before(value = "execution(* demo6.ProductDao.save(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知========================"+ joinPoint);
    }

    @AfterReturning(value = "execution(* demo6.ProductDao.delete(..))", returning = "result")
    public void afterrun(Object result){
        System.out.println("后置=================="+result);
    }

    @Around(value = "execution(* demo6.ProductDao.update(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("前置通知========================");
        Object obj = proceedingJoinPoint.proceed();//执行目标方法
        System.out.println("后置==================");

        return obj;
    }


}
