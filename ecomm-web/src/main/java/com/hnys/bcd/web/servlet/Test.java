package com.hnys.bcd.web.servlet;

import com.hnys.bcd.user.dto.UserDTO;
import com.hnys.bcd.user.remote.TestRemote;
import com.hnys.bcd.user.remote.UserRemote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

            TestRemote tr;
            InitialContext ic = new InitialContext();
            tr = (TestRemote) ic.lookup("java:global/user-module-1.0/TestSessionBean");

//            HttpSession session = req.getSession();
//            if (session.getAttribute("testBean") == null) {
//                InitialContext ic = new InitialContext();
//                tr = (TestRemote) ic.lookup("java:global/user-module-1.0/TestSessionBean");
//                session.setAttribute("testBean", tr);
//            }else  {
//                tr = (TestRemote) session.getAttribute("testBean");
//            }

            String test = tr.test();
            resp.getWriter().write("Result:  " + test);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }
}
