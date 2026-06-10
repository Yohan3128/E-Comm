package com.hnys.bcd.user.bean;

import com.hnys.bcd.user.remote.TestRemote;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;

@Stateless
public class TestSessionBean implements TestRemote {
    int i;

    @PostConstruct
    public void init() {
        System.out.println("TestSessionBean: init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("TestSessionBean: destroy");
    }


    public TestSessionBean() {
        System.out.println("TestSessionBean created" + this);
    }

    @Override
    public String test() {

        i++;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "TestSessionBean: test" + i;
    }
}
