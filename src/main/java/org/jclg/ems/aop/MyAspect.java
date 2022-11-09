package org.jclg.ems.aop;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.jclg.ems.Ret.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class  MyAspect{
    @Pointcut("execution(public * org.jclg.ems.controller..*.*(..))")
    public void aspect(){}
//    final String execution="execution(public * org.jclg.ems.controller.*.controller..*(..))";
//    @Before("aspect()")
//    public void before() {
//        System.out.println("---纯注解方式实现前置增强-------");
//    }

//    @After("aspect()")
//    public void after() {
//        System.out.println("---纯注解方式实现后置增强-------");
//    }
    @Around("aspect()")
    public R around(ProceedingJoinPoint p) {
        R r=new R();
        System.out.println("环绕前");
        try {
//            p.proceed();
            Object[] args = p.getArgs();
            //用改变后的参数执行目标方法
                r.setCode(200);
                r.setMessage("服务器处理成功");
                r.setData(p.proceed(args));
            if(r.getData().toString().substring(0,1).equals("R")){
                r=(R)r.getData();
                r.setCode(200);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            r.setMessage("服务器处理失败");
            r.setCode(404);
            r.setData(null);
        }finally {

            System.out.println("环绕后");
            System.out.println(r.toString());
            return r;

        }
    }
}
