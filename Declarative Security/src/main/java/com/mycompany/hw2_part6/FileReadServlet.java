/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw2_part6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author kaviprakashramalingam
 */
@WebServlet(name = "waiver", urlPatterns = "/waiver.htm")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"admin"}))

public class FileReadServlet extends HttpServlet{
 
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handle(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handle(req, resp);
    }

    public void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        StringBuilder txt = new StringBuilder();
        txt.append("<html>");
        txt.append("<h1>Tuition waiver form confirmation</h1>");
        txt.append("<body>");
        txt.append("<h2>Section 1</h2>");
        txt.append("<label>Academic term: </label>").append(req.getParameter("term")).append("<br>");
        txt.append("<label>Academic year: </label>").append(req.getParameter("year")).append("<br>");

//      Get the values of employee ststus
        String[] status = req.getParameterValues("emp_status");
        StringBuilder employeeStatus = new StringBuilder();
        if (status != null) {
            for (int i = 0; i < employeeStatus.length(); i++) {
                employeeStatus.append(status[i]);
                if (i != status.length - 1) {
                    employeeStatus.append(", ");
                }
            }
        }
        txt.append("<label>Employee Status: </label>").append(employeeStatus).append("<br>");
        txt.append("<h2>Section 2</h2>");
        txt.append("<label>Student's Name: </label>").append(req.getParameter("sname")).append("<br>");
        txt.append("<label>Relationship to Employee: </label>").append(req.getParameter("relationship")).append("<br>");
        txt.append("<label>Student's NUID: </label>").append(req.getParameter("snuid")).append("<br>");
        txt.append("<label>Employee's Name: </label>").append(req.getParameter("ename")).append("<br>");
        txt.append("<label>Employee's NUID: </label>").append(req.getParameter("enuid")).append("<br>");
        txt.append("<label>Department: </label>").append(req.getParameter("dept")).append("<br>");
        txt.append("<label>Campus Location: </label>").append(req.getParameter("c_location")).append("<br>");
        txt.append("<label>Phone Number: </label>").append(req.getParameter("num")).append("<br>");
        txt.append("<label>Supervisor's Name: </label>").append(req.getParameter("sup_name")).append("<br>");

        txt.append("<h2>Section 3</h2>");
        String[] programs = req.getParameterValues("course");
        StringBuilder program = new StringBuilder();
        if (programs != null) {
            for (int i = 0; i < programs.length; i++) {
                program.append(programs[i]);
                if (i != programs.length - 1) {
                    program.append(", ");
                }
            }
        }
        txt.append("<label>Applicable Programs: </label>").append(program).append("<br>");
        txt.append("<table style=\"text-align: center;\">");
        txt.append("<tr>");
        txt.append("<th>Course No.</th>");
        txt.append("<th>Course Name</th>");
        txt.append("<th>Supervisor Signature</th>");
        txt.append("<th>Credit Hrs.</th>");
        txt.append("<th>Day(s)</th>");
        txt.append("</tr>");
        String[] courseNos = req.getParameterValues("course_no");
        String[] courseNames = req.getParameterValues("course_name");
        String[] courseSupervisors = req.getParameterValues("sign");
        String[] courseCreditHrs = req.getParameterValues("credit_hrs");
        String[] courseDays = req.getParameterValues("days");
        String[] courseTimes = req.getParameterValues("am_pm");
        if (courseNos != null && courseNames != null && courseSupervisors != null
                && courseCreditHrs != null && courseDays != null && courseTimes != null) {
            for (int i = 0; i < courseNos.length; i++) {
                String courseNo = courseNos[i];
                String courseName = courseNames[i];
                String courseSupervisor = courseSupervisors[i];
                String courseCredHrs = courseCreditHrs[i];
                String courseDay = courseDays[i];
                String courseTime = courseTimes[i];
                txt.append("<tr>");
                txt.append("<td>").append(courseNo == null ? "-" : courseNo).append("</td>");
                txt.append("<td>").append(courseName == null ? "-" : courseName).append("</td>");
                txt.append("<td>").append(courseSupervisor == null ? "-" : courseSupervisor).append("</td>");
                txt.append("<td>").append(courseCredHrs == null ? "-" : courseCredHrs).append("</td>");
                txt.append("<td>").append(courseDay == null ? "-" : courseDay).append("</td>");
                txt.append("<td>").append(courseTime == null ? "-" : courseTime).append("</td>");
                txt.append("</tr>");
            }
        }
        txt.append("</table>");
        txt.append("<h2>Section 4</h2>");
        txt.append("<label>Employee's Signature: </label>").append(req.getParameter("employee_sign")).append("<br>");
        txt.append("<label>Date: </label>").append(req.getParameter("date")).append("<br>");
        txt.append("<h2>Section 5</h2>");
        txt.append("<label>HRM Approval: </label>").append(req.getParameter("HRM")).append("<br>");
        txt.append("<label>Date: </label>").append(req.getParameter("date_1")).append("<br>");
        txt.append("<h2>Thanks for submitting</h2>");
        txt.append("</body>");
        txt.append("</html>");
        out.println(txt);
    }

}
