<%@ page import="jakarta.ejb.EJB" %>
<%@ page import="com.hnys.bcd.user.remote.TestRemote" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %><%--
  Created by IntelliJ IDEA.
  User: Yohan Silva
  Date: 18/06/2026
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%!--%>
<%--    @EJB--%>
<%--    private TestRemote testRemote;--%>
<%--%>--%>
<%--<%--%>
<%--testRemote.test();--%>
<%--%>--%>
<h1>Index Page</h1>

    <%
        try {

            InitialContext ic = new InitialContext();  //J2EE 1+ -> programmatic
            TestRemote tr = (TestRemote) ic.lookup("java:global/user-module-1.0/TestSessionBean");
            tr.test();


        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    %>
</body>
</html>
