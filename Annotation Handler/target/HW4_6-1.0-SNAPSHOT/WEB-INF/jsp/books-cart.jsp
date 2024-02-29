<%-- 
    Document   : books-cart
    Created on : Feb 24, 2024, 2:24:05 PM
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
                <h2>Shop for Books</h2>
                <div class="items-container">
                    <div class='item'>
                        <input type='checkbox' value='White Noise by Don DeLillo [$29.23]' name='selectedItems' /> White Noise by Don
                        DeLillo [$29.23]<br />
                        <input type='checkbox' value='The Line of Beauty by Alan Hollinghurst [$34.12]' name='selectedItems'/> The
                        Line of Beauty by Alan Hollinghurst [$34.12]<br />
                        <input type='checkbox' value='David Copperfield by Charles Dickens [25.98]' name='selectedItems'/> David
                        Copperfield by Charles Dickens [25.98]<br />
                        <input type='checkbox' value='The Art of War by Sun Tzu [$50.13]' name='selectedItems'/> The Art of War by
                        Sun Tzu [$50.13]<br />
                        <input type='checkbox' value='Rich Dad Poor Dad by Robert [$32.63]' name='selectedItems'/> Rich Dad Poor Dad
                        by Robert [$32.63]<br /><br />
                        <input type='hidden' name='category' value='books' />
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

