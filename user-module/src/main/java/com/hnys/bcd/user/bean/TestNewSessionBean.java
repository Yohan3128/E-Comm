package com.hnys.bcd.user.bean;

import com.hnys.bcd.user.remote.TestRemote;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;

@Stateful(mappedName = "TestNewSessionBean")
//@Startup
public class TestNewSessionBean implements TestRemote {
    int i;

    @PostConstruct
    public void init() {
        System.out.println("TestSessionBean: init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("TestSessionBean: destroy");
    }

    @PostActivate
    public void postActivate() {
        System.out.println("TestSessionBean: postActivate");
    }

    @PrePassivate
    public void prePassivate(){
        System.out.println("TestSessionBean: prePassivate");
    }

    public TestNewSessionBean() {
        System.out.println("TestSessionBean created" + this);
    }

    @Remove
    @Override
    public void remove() {
        System.out.println("TestSessionBean: removed...");
    }

    @Override
    @Lock(LockType.READ)
    public String test() {

        i++;

        System.out.println("TestSessionBean: test...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "TestSessionBean: test" + i;
    }
}
