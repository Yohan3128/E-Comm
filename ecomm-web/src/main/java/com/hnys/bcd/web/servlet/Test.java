package com.hnys.bcd.web.servlet;

import com.hnys.bcd.user.dto.UserDTO;
import com.hnys.bcd.user.remote.TestRemote;
import com.hnys.bcd.user.remote.UserRemote;
import jakarta.ejb.EJB;
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

@WebServlet(value = "/test" ,loadOnStartup = 1)
public class Test extends HttpServlet {

    @EJB(lookup = "java:global/user-module-1.0/TestSessionBean") //J2EE 5+ //declarative
    private TestRemote testRemote;

    public void init() throws ServletException {
        System.out.println("init method");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("Ecomm web Module Test </br>");

        testRemote.test();


//        try {
//
//            TestRemote tr;
//            InitialContext ic = new InitialContext();  //J2EE 1+ -> programmatic
//            tr = (TestRemote) ic.lookup("java:global/user-module-1.0/TestSessionBean");
//
////            HttpSession session = req.getSession();
////            if (session.getAttribute("testBean") == null) {
////                InitialContext ic = new InitialContext();
////                tr = (TestRemote) ic.lookup("java:global/user-module-1.0/TestSessionBean");
////                session.setAttribute("testBean", tr);
////            }else  {
////                tr = (TestRemote) session.getAttribute("testBean");
////            }
//
//            String test = tr.test();
//            resp.getWriter().write("Result:  " + test);
//
////            tr.remove();
////
////            session.removeAttribute("testBean");
//
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
//        }

    }
}
