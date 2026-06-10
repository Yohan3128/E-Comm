package com.hnys.bcd.web.servlet;

import com.hnys.bcd.user.dto.UserDTO;
import com.hnys.bcd.user.remote.TestRemote;
import com.hnys.bcd.user.remote.UserRemote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Ecomm web Module Test");

        try {
            InitialContext ic = new InitialContext();
            TestRemote userRemote = (TestRemote) ic.lookup("java:global/user-module-1.0/TestSessionBean");

            String test = userRemote.test();
            resp.getWriter().write("Result "+test);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }
}
