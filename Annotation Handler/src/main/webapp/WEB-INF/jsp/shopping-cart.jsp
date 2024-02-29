<%-- 
    Document   : shopping-cart
    Created on : Feb 24, 2024, 2:04:17 PM
    Author     : kaviprakashramalingam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Shopping Cart</title>
        <style>
            .left-panel {
                float: left;
                width: 200px;
                padding: 20px;
            }

            .right-panel {
                float: left;
                width: 50%;
                padding: 20px;
            }

            .right-panel-cart {
                float: right;
                width: 90px;
                padding: 20px;
            }

            .left-panel ul {
                list-style-type: none;
                padding: 0;
            }

            .left-panel ul li {
                margin-bottom: 10px;
                padding-top: 10px;
                padding-bottom: 10px;
            }

            .item {
                margin-bottom: 10px;
            }

            .cart {
                float: right;
                margin-top: 20px;
            }

            .items-container input[type='checkbox'] {
                margin-bottom: 20px;
            }

            .remove-cart input[type='checkbox'] {
                margin-bottom: 20px;
            }
        </style>
    </head>

    <body>
        <form method='post' action='shoppingCart.htm'>
            <div class="left-panel">
                <ul>
                    <li><a href='books.htm'>Books</a></li>
                    <hr>
                    <li><a href='music.htm'>Music</a></li>
                    <hr>
                    <li><a href='computers.htm'>Computers</a></li>
                    <hr>
                </ul>
            </div>
            <div class='right-panel'>
                <h2>Welcome to Shopping site!</h2>
                <p>Choose from the categories to view the products</p>
            </div>
            <div class='right-panel-cart'>
                <a id='view-cart' href='viewcart.htm'>View Cart</a>
            </div>
        </form>
    </body>

</html>

