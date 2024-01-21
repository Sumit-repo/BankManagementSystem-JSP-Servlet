<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<% 
    ArrayList<Object[]> peopleList = (ArrayList) request.getAttribute("data");

    String s= "";
    for (Object[] person : peopleList) {
    s += "<tr><td>"+person[0]+"</td><td>"+person[1]+"</td><td>"+person[2]+"</td><td>"+person[3]+"</td><td>"+person[4]+"</td></tr>";
}
%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Account Statement</title>
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
                border: 3px solid rgb(113, 112, 112);
            }


            #table-container {
                max-width: 100%;
                margin: 2vh;
                margin-top: 0;
                overflow-x: auto;
                border-radius: 10px;
                border: 1px solid rgb(80, 79, 79);
                background-color: rgba(80, 79, 79, 0.563);
            }

            table {
                border-collapse: collapse;
                max-width: 100%;
                border: 1px solid #ddd;
                table-layout: fixed;
            }

            th,
            td {
                width: 13vh;
                border: 1px solid #ddd;
                padding: 9px;
                text-align: left;
                line-height: 1.2;
                max-height: 2.4em;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
            }

            th {
                text-align: center;
                color: white;
                background-color: rgb(80, 79, 79);
                border: 2px solid rgb(143, 142, 142);
            }

            #first {
                border-radius: 10px 0 0 0;
            }

            #last {
                border-radius: 0 10px 0 0;
            }
        </style>
    </head>

    <body>
        <div id="main">
            <div id="table-container">
                <table id="dataTable">
                    <thead>
                        <tr>
                            <th id="first">Date-Time</th>
                            <th>Summary</th>
                            <th>Debit</th>
                            <th>Credit</th>
                            <th id="last">Balance</th>
                        </tr>
                        <%= s %>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div>
                <form action="cus_login">
                    <input type="submit" name="" id="button" value="Back">
                </form>
            </div>
        </div>
    </body>

</html>