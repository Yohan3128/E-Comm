package com.hnys.bcd;

import com.hnys.bcd.user.remote.TestRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Client Application Starting...");

        try {

            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty(Context.PROVIDER_URL, "iiop://localhost:3700");

            InitialContext ic = new InitialContext(props);

//            TestRemote testRemote =  (TestRemote) ic.lookup("java:global/user-module-1.0/TestSessionBean");
//            testRemote.test();

            String name = ic.lookup("name").toString();
            System.out.println("Name: " + name);


        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}