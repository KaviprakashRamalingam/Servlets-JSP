/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw2_part7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author kaviprakashramalingam
 */
@WebServlet(name = "cart", urlPatterns = {"/shoppingCart.htm", "/viewCart.htm", "/removeItems.htm"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"admin"}))
public class ShoppingCartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!request.isUserInRole("admin")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized access");
            return;
        }
        String servletPath = request.getServletPath();
        if ("/shoppingCart.htm".equals(servletPath)) {
            handleShoppingCart(request, response);
        } else if ("/viewCart.htm".equals(servletPath)) {
            handleViewCart(request, response);
        } else if ("/removeItems.htm".equals(servletPath)) {
            handleRemoveItems(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!request.isUserInRole("admin")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized access");
            return;
        }
        handleShoppingCart(request, response);
    }

    public void handleShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(60 * 30);

//        boolean isExecutive = req.isUserInRole("admin");
        String selectedCategory = req.getParameter("category");
        if (selectedCategory == null) {
            selectedCategory = "0";
        }

        // Retrieve or create cart list in session
        List<String> cartItems = (List<String>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cart", cartItems);
        }

        // Iterate through parameters to retrieve selected items
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("item")) {
                String[] selectedValues = req.getParameterValues(paramName);
                if (selectedValues != null) {
                    // Add each selected item to the cart
                    for (String value : selectedValues) {
                        cartItems.add(value);
                    }
                }
            }
        }
        StringBuilder txt = new StringBuilder();

        txt.append("<html>");
        txt.append("<head>");
        txt.append("<title>Shopping Cart</title>");
        txt.append("<style>");
        txt.append("#left-panel {");
        txt.append("float: left;");
        txt.append("width: 200px;");
        txt.append("padding: 20px;");
        txt.append("}");
        txt.append("#right-panel {");
        txt.append("float: left;");
        txt.append("width: 50%;");
        txt.append("padding: 20px;");
        txt.append("}");
        txt.append("#right-panel-cart {");
        txt.append("float: right;");
        txt.append("width: 90px;");
        txt.append("padding: 20px;");
        txt.append("}");
        txt.append("#left-panel ul {");
        txt.append("list-style-type: none;");
        txt.append("padding: 0;");
        txt.append("}");
        txt.append("#left-panel ul li {");
        txt.append("margin-bottom: 10px;");
        txt.append("padding-top: 10px;");
        txt.append("padding-bottom: 10px;");
        txt.append("}");
        txt.append(".item {");
        txt.append("margin-bottom: 10px;");
        txt.append("}");
        txt.append("#cart {");
        txt.append("float: right;");
        txt.append("margin-top: 20px;");
        txt.append("}");
        txt.append("#items-container input[type='checkbox'] {");
        txt.append("margin-bottom: 20px;");
        txt.append("}");
        txt.append("#remove-cart input[type='checkbox'] {");
        txt.append("margin-bottom: 20px;");
        txt.append("}");
        txt.append("</style>");
        txt.append("</head>");
        txt.append("<body>");
        txt.append("<form method='post' action='shoppingCart.htm'>");
        txt.append("<div id=\"left-panel\">");
        txt.append("<ul>");
//        if (isExecutive) {
        txt.append("<li><a href='shoppingCart.htm?category=books'>Books</a></li><hr>");
        txt.append("<li><a href='shoppingCart.htm?category=music'>Music</a></li><hr>");
        txt.append("<li><a href='shoppingCart.htm?category=computers'>Computers</a></li><hr>");
//        } else {
//            txt.append("<li>Books</li><hr>");
//            txt.append("<li>Music</li><hr>");
//            txt.append("<li>Computers</li><hr>");
//        }
        txt.append("</ul>");
        txt.append("</div>");
        txt.append("<div id=\"right-panel\">");

        if ((!selectedCategory.equals("books")) && (!selectedCategory.equals("music")) && (!selectedCategory.equals("computers"))) {
            txt.append("<h2>Welcome to Shopping site!</h2>");
            txt.append("<p>Choose from the categories to view the products</p>");
        }
        if (selectedCategory.equals("books")) {
            txt.append("<h2>Shop for Books</h2>");
            txt.append("<div id=\"items-container\">");
            txt.append("<div class='item'>");
            txt.append("<input type='checkbox' value='White Noise by Don DeLillo [$29.23]' name='item' /> White Noise by Don DeLillo [$29.23]<br/>");
            txt.append("<input type='checkbox' value='The Line of Beauty by Alan Hollinghurst [$34.12]' name='item'/> The Line of Beauty by Alan Hollinghurst [$34.12]<br/>");
            txt.append("<input type='checkbox' value='David Copperfield by Charles Dickens [25.98]' name='item'/> David Copperfield by Charles Dickens [25.98]<br/>");
            txt.append("<input type='checkbox' value='The Art of War by Sun Tzu [$50.13]' name='item'/> The Art of War by Sun Tzu [$50.13]<br/>");
            txt.append("<input type='checkbox' value='Rich Dad Poor Dad by Robert [$32.63]' name='item'/> Rich Dad Poor Dad by Robert [$32.63]<br/><br/>");
            txt.append("<input type='hidden' name='category' value='books' />");
            txt.append("</div>");
            txt.append("</div>");
        } else if (selectedCategory.equals("music")) {
            txt.append("<h2>Shop for CDs</h2>");
            txt.append("<div id=\"items-container\">");
            txt.append("<div class='item'>");
            txt.append("<input type='checkbox' value='You Get What You Give [$23.98]' name='item' /> You Get What You Give [$23.98]<br/>");
            txt.append("<input type='checkbox' value='The Rain (Supa Dupa Fly) [$56.12]' name='item' /> The Rain (Supa Dupa Fly) [$56.12]<br/>");
            txt.append("<input type='checkbox' value='Random Rules [$46.25]' name='item' /> Random Rules [$46.25]<br/>");
            txt.append("<input type='checkbox' value='Nightswimming [$32.87]' name='item' /> Nightswimming [$32.87]<br/>");
            txt.append("<input type='checkbox' value='Around the World [$56.23]' name='item' /> Around the World [$56.23]<br/><br/>");
            txt.append("<input type='hidden' name='category' value='music' />");
            txt.append("</div>");
            txt.append("</div>");
        } else if (selectedCategory.equals("computers")) {
            txt.append("<h2>Shop for Computers</h2>");
            txt.append("<div id=\"items-container\">");
            txt.append("<div class='item'>");
            txt.append("<input type='checkbox' value='Apple Macbook with M1 chip [$799]' name='item' /> Apple Macbook with M1 chip [$799]<br/>");
            txt.append("<input type='checkbox' value='Lenovo Legion with 14 inch display [$2703.12]' name='item' /> Lenovo Legion with 14 inch display [$2703.12]<br/>");
            txt.append("<input type='checkbox' value='Dell G13 with AMD Ryzen 5 [$699.99]' name='item' /> Dell G13 with AMD Ryzen 5 [$699.99]<br/>");
            txt.append("<input type='checkbox' value='Alienware m16 [$1349]' name='item' /> Alienware m16 [$1349]<br/>");
            txt.append("<input type='checkbox' value='Macbook Pro Retina with 15.4 [$585.00]' name='item' /> Macbook Pro Retina with 15.4 [$585.00]<br/><br/>");
            txt.append("<input type='hidden' name='category' value='computers' />");
            txt.append("</div>");
            txt.append("</div>");
        }

        if ((!selectedCategory.equals("books")) && (!selectedCategory.equals("music")) && (!selectedCategory.equals("computers"))) {

        } else {
            txt.append("<input type='submit' value='Add to cart' />");
        }
        txt.append("</div>");
        txt.append("<div id=\"right-panel-cart\">");
        txt.append("<a id='view-cart' href='viewCart.htm'>View Cart</a>");
        txt.append("</div>");
        txt.append("</form>");
        txt.append("</body>");
        txt.append("</html>");
        out.println(txt);
        out.flush();
    }

    private void handleViewCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        // Retrieve cart data from session
        List<String> cartItems = (List<String>) session.getAttribute("cart");

        StringBuilder txt = new StringBuilder();
        txt.append("<html>");
        txt.append("<head>");
        txt.append("<title>View Cart</title>");
        txt.append("</head>");
        txt.append("<body>");
        txt.append("<h2>The following items has been added to your shopping cart successfully</h2>");
        txt.append("<form method='get' action='removeItems.htm'>");
        if (cartItems != null && !cartItems.isEmpty()) {
            txt.append("<ul>");
            for (String item : cartItems) {
                txt.append("<li id=\"remove-cart\">");
                txt.append("<input type='checkbox' name='removeItem' value='").append(item).append("' />");
                txt.append(item);
                txt.append("</li>");
            }
            txt.append("</ul>");
            txt.append("<input type='submit' value='Remove Selected Items' />");
        } else {
            txt.append("<p>Cart is empty</p>");
        }
        txt.append("</form>");
        txt.append("<a href='shoppingCart.htm'>[ Back to Shopping ]</a>");
        txt.append("<a href='shoppingCart.htm?category=books'>[ Go to Books Page ]</a>");
        txt.append("<a href='shoppingCart.htm?category=music'>[ Go to Music Page ]</a>");
        txt.append("<a href='shoppingCart.htm?category=computers'>[ Go to Computers Page ]</a>");
        txt.append("</body>");
        txt.append("</html>");
        out.println(txt);
        out.flush();
    }

    private void handleRemoveItems(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        List<String> cartItems = (List<String>) session.getAttribute("cart");

        // Retrieve selected items to remove
        String[] itemsToRemove = req.getParameterValues("removeItem");
        if (itemsToRemove != null) {
            // Remove selected items from the cart
            for (String item : itemsToRemove) {
                cartItems.remove(item);
            }
            // Update session attribute
            session.setAttribute("cart", cartItems);
        }

        // Redirect to view cart page to display updated cart
        resp.sendRedirect("viewCart.htm");
    }
}
