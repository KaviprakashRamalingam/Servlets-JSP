<%-- 
    Document   : computers-cart
    Created on : Feb 24, 2024, 2:24:20 PM
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
        <form method='post' action='addCartItem.htm'>
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
                <h2>Shop for Computers</h2>
                <div class = 'items-container'>
                    <div class='item'>
                        <input type='checkbox' value='Apple Macbook with M1 chip [$799]' name='selectedItems' /> Apple Macbook with
                        M1 chip [$799]<br />
                        <input type='checkbox' value='Lenovo Legion with 14 inch display [$2703.12]' name='selectedItems' /> Lenovo
                        Legion with 14 inch display [$2703.12]<br />
                        <input type='checkbox' value='Dell G13 with AMD Ryzen 5 [$699.99]' name='selectedItems' /> Dell G13 with AMD
                        Ryzen 5 [$699.99]<br />
                        <input type='checkbox' value='Alienware m16 [$1349]' name='selectedItems' /> Alienware m16 [$1349]<br />
                        <input type='checkbox' value='Macbook Pro Retina with 15.4 [$585.00]' name='selectedItems' /> Macbook Pro
                        Retina with 15.4 [$585.00]<br /><br />
                        <input type='hidden' name='category' value='computers' />
                    </div>
                </div>
                <input type='submit' value='Add to cart' onclick='showConfirmation()'/>
            </div>
            <div class='right-panel-cart'>
                <a id='view-cart' href='viewcart.htm'>View Cart</a>
            </div>
        </form>
        <script src="${pageContext.request.contextPath}/resources/js/Confirmation.js"></script>
    </body>

</html>