<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <% long acc=(long) request.getAttribute("acc"); String status=(String) request.getAttribute("status"); %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Account Status</title>
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
                    border: rgb(59, 59, 59) solid 4px;
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
                    border: 3px solid  rgb(119, 118, 118);
                }
            </style>
        </head>

        <body>
            <div id="main">
                <div>
                    <h3>Account Number <i>
                            <%= acc %>
                        </i> updated -&gt; Status changed to <%= status %>
                    </h3>
                </div>
                <div>
                    <form action="new">
                        <input type="submit" value="Back" id="button">
                    </form>
                </div>
            </div>
        </body>

        </html>