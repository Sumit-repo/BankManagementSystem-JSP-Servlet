<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <% 
    long acc=(long) request.getAttribute("acc");
    String name=(String) request.getAttribute("name");
    String pincode=(String) request.getAttribute("pincode");
     %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Update</title>
            <style>
                * {
                    margin: 0;
                    padding: 0;
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                }

                #main {
                    box-sizing: border-box;
                    height: 100vh;
                    width: 100vw;
                    background-color: rgb(240, 240, 240);
                    border: rgb(80, 79, 79) solid 4px;
                    display: flex;
                    flex-direction: column;
                    gap: 5vh;
                    align-items: center;
                    justify-content: center;
                }

                #button {
                    height: 5vh;
                    width: 7vw;
                    border-radius: 10px;
                    font-size: 19px;
                    color: rgb(80, 79, 79);
                    font-weight: 700;
                    border: 3px solid rgb(117, 117, 117);
                }

                #inner_container {
                    color: white;
                    background-color: rgb(80, 79, 79);
                    padding: 5vh;
                    display: flex;
                    justify-content: flex-start;
                    flex-direction: column;
                    gap: 2vh;
                    border-radius: 15px;
                    text-shadow: 1px 1px 2px black;
                }

                input {
                    margin-top: 1vh;
                    font-size: 16px;
                    width: 20vw;
                    font-weight: 600;
                    text-indent: 1vh;
                    height: 4vh;
                    border-radius: 15px;
                    border: none;
                }
            </style>
        </head>

        <body>
            <div id="container">
                <div id="main">
                    <div>
                        <form action="doUpdate_cus" id="inner_container">
                            <div>
                                <h2>Account Number</h2> <input type="text" name="acc" value="<%= acc %>" readonly>
                            </div>
                            <div>
                                <h2>Customer Name</h2> <input type="text" value="<%= name %>" name="name">
                            </div>
                            <div>
                                <h2>Pincode</h2> <input type="text" value="<%= pincode %>" name="password">
                            </div>
                            <div>
                                <input type="submit" value="Update" id="button">
                            </div>
                        </form>
                    </div>
                    <div>
                        <form action="new">
                            <input type="submit" value="Back" id="button">
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>