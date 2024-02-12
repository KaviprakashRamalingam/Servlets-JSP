/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaviprakashramalingam
 */
@WebServlet(name = "quiz", urlPatterns = "/quiz.htm")
public class QuizServlet extends HttpServlet {

    ArrayList<String> answers = new ArrayList<>();

    public QuizServlet() {

    }

    @Override
    public void init() {
        answers.add("b");
        answers.add("a");
        answers.add("b");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handle(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handle(req, resp);
    }

    public void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(60 * 30);

        String ans;
        String qn = req.getParameter("q");
        if (qn == null) {
            qn = "0";
        }

        ans = req.getParameter("ans");
        if (!qn.equals("0")) {
            session.setAttribute(qn, ans);
        }
        Cookie c = new Cookie(qn, ans);         //add cookie before anything is printed
        c.setMaxAge(60 * 60 * 24);              // Cookie duration is 1 day
        resp.addCookie(c);

        out.println("<html>");
        out.println("<body>");

        if (!qn.equals('3')) {
            out.println("<form method='post' action='quiz.htm'>");
        }
//        out.println("<h2>Session ID : " + session.getId() + "</h2>");
//        out.println("<h2>Session Last accesed time : " + session.getLastAccessedTime() + "</h2>");
        if (qn.equals("0")) {
            out.println("<h2>Question 1 : What is 2+2?</h2>");
            out.println("<input type='radio' value='a' name='ans' required/>A.5<br/><br/>");
            out.println("<input type='radio' value='b' name='ans' required/>B.4<br/><br/>");
            out.println("<input type='radio' value='c' name='ans' required/>C.6<br/><br/>");
            out.println("<input type='radio' value='d' name='ans' required/>D.Nan<br/><br/>");
            out.println("<input type='hidden' name='q' value='1' /><br/><br/>");

        } else if (qn.equals("1")) {
//            ans = req.getParameter("ans");
            out.println("<h2>Question 2 : What is Tomcat?</h2>");
            out.println("<input type='radio' value='a' name='ans' required/>A.Container<br/><br/>");
            out.println("<input type='radio' value='b' name='ans' required/>B.Browser<br/><br/>");
            out.println("<input type='radio' value='c' name='ans' required/>C.IDE<br/><br/>");
            out.println("<input type='radio' value='d' name='ans' required/>D.Application<br/><br/>");
            out.println("<input type='hidden' name='q' value='2' required/><br/><br/>");
        } else if (qn.equals("2")) {
//            ans = req.getParameter("ans");
            out.println("<h2>Question 3 : Are sessions transfered from browser to browser?</h2>");
            out.println("<input type='radio' value='a' name='ans' required/>A.Yes<br/><br/>");
            out.println("<input type='radio' value='b' name='ans' required/>B.No<br/><br/>");
            out.println("<input type='radio' value='c' name='ans' required/>C.May be<br/><br/>");
            out.println("<input type='radio' value='d' name='ans' required/>D.Sometimes<br/><br/>");
            out.println("<input type='hidden' name='q' value='3' /><br/><br/>");
        } else if (qn.equals("3")) {
//            List<String> submittedAnswers = new ArrayList<>();
//            Cookie[] cookies = req.getCookies();
            HttpSession ses = req.getSession();
//            for (Cookie ck : cookies) {
//                submittedAnswers.add(ck.getName() + ": " + ck.getValue());
////                out.println("<li>" + ck.getName() + ": " + ck.getValue() + "</li>");
//            }
//            submittedAnswers.add(c.getName() + ": " + c.getValue());
            out.println("<h2>Answers submitted by you are</h2>");
            out.println("<ul>");
//            for (String answer : submittedAnswers) {
//                out.println("<li>" + answer + "</li><br>");
//            }
            if (ses.getAttribute("1").equals(answers.get(0))) {
                out.println("<li style= 'color:green'> Answer 1 : " + ses.getAttribute("1") + "</li>");
            } else {
                out.println("<li style= 'color:red'> Answer 1 : " + ses.getAttribute("1") + "</li>");
            }

            if (ses.getAttribute("2").equals(answers.get(1))) {
                out.println("<li style= 'color:green'> Answer 2 : " + ses.getAttribute("2") + "</li>");
            } else {
                out.println("<li style= 'color:red'> Answer 2 : " + ses.getAttribute("2") + "</li>");
            }

            if (ses.getAttribute("3").equals(answers.get(2))) {
                out.println("<li style= 'color:green'> Answer 3 : " + ses.getAttribute("3") + "</li>");
            } else {
                out.println("<li style= 'color:red'> Answer 3 : " + ses.getAttribute("3") + "</li>");
            }
            out.println("</ul>");

            out.println("<h2>Correct answers are </h2>");
            out.println("<ul>");
            out.println("<li> Answer 1 : " + answers.get(0) + "</li>");
            out.println("<li> Answer 2 : " + answers.get(1) + "</li>");
            out.println("<li> Answer 3 : " + answers.get(2) + "</li>");

            out.println("</ul>");
        }
        if (!qn.equals("3")) {
            out.println("<input type='submit' value='Submit' />");
            out.println("</form>");
        }

        out.println("</body>");
        out.println("</html>");
    }

}
