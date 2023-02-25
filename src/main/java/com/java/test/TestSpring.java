package com.java.test;

import com.java.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountServiceImpl as = (AccountServiceImpl) ac.getBean("accountService");
        as.findAll();
    }
}
