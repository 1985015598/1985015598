package org.jclg.ems.sessionlistener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private static int count = 0;

    @Override

    public void sessionCreated(HttpSessionEvent se) {

//        System.out.println("创建session"+se.getSession().getId());
//
//        if(se.getSession().getAttribute("yonghu")==null) {
//        }
//
//        count ++;

    }

    @Override

    public void sessionDestroyed(HttpSessionEvent se) {

//        System.out.println("销毁session"+se.getSession().getId());
//
//        count --;

    }
}