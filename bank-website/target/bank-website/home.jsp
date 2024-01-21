<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String message = (String) request.getAttribute("message");
    String name = (String) request.getAttribute("name");
%>

<!DOCTYPE html>
<html>

<head>
    <title>Homepage</title>
    <Style>
        :root {
            --basic: rgb(80, 79, 79);
        }

        * {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        #container {
            box-sizing: border-box;
            height: 100vh;
            width: 100vw;
            background-color: rgb(240, 240, 240);
            border: var(--basic) solid 4px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        #outer-card {
            padding: 0 1vw;
            display: flex;
            align-items: center;
            justify-content: space-between;
            width: 98vw;
            height: 6vh;
            background-color: var(--basic);
        }

        #title {
            color: white;
            font-weight: 600;
            font-size: 25px;
        }

        #links {
            display: flex;
            gap: 5vh;
        }

        #links>a {
            font-size: 18px;
            color: white;
            text-decoration: none;
            padding: 0.5vh 1vh;
        }

        #links>a:hover {
            box-shadow: 0px 0px 0 1px rgb(255, 255, 255);
            border-radius: 10px;
            padding: 0.5vh 1vh;
        }

        #main {
            height: 94vh;
            display: flex;
            align-items: center;
        }

        #content {
            width: 50vw;
            margin-left: 10vw;
        }

        #inner-card {
            z-index: 2;
            height: 79vh;
            width: 30vw;
            background-color: var(--basic);
            border-radius: 18px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #inner-inner-card {
            height: 66vh;
            width: 24vw;
            background-color: var(--basic);
            border-radius: 20px;
            border: 2px solid white;
        }

        #form {
            display: flex;
            flex-direction: column;
            justify-content: center;
            padding: 15px 40px 40px 40px;
            color: white;
        }

        .fg1 {
            font-size: 16px;
            height: 4vh;
            width: 100%;
            border-radius: 8px;
            border: none;
            text-indent: .5vh;
        }

        #button {
            height: 5vh;
            width: 7vw;
            border-radius: 10px;
            font-size: 19px;
            color: var(--basic);
            font-weight: 700;
            border: 2px solid rgb(112, 111, 113);
        }

        .inputForms {
            display: flex;
            flex-direction: row;
            align-items: center;
            margin-top: 5px;
            margin-bottom: 10px;
        }

        #form_ac {
            font-size: 18px;
            font-weight: 600;
            width: 72vh;
            gap: 3vh;
            padding: 1vh 2vh;
            display: flex;
            align-items: center;
            color: white;
            background-color: var(--basic);
            border-radius: 20px;
            margin: 0 0 3vh 5vh;
        }

        #radio {
            font-size: 17px;
            font-weight: 600;
            display: flex;
            align-items: baseline;
            gap: 1vh;
            margin: 0 5vh 5vh 0;
        }

        .newWidth {
            text-indent: 1.5vh;
            width: 30%;
            font-size: 20px;
            border-radius: 20px;
        }
    </Style>
</head>

<body>
    <div id="container">
        <div id="outer-card">
            <div id="title">
                Bank Management
            </div>
            <div id="links" class="mar-right">
                <a href="new">New</a>
                <a class="myLink" href="view">View</a>
                <a class="myLink" href="block">Block</a>
                <a class="myLink" href="unblock">Unblock</a>
                <a class="myLink" href="update">Update</a>
                <a class="myLink" href="delete">Delete</a>
                <a href="viewAll">All Customers</a>
            </div>
            <div id="links">
                <a href="update-profile">
                    <%= name %>
                </a>
                <a href="index.jsp">Logout</a>
            </div>
        </div>
        <div id="main">
            <div id="content">
                <h1 style="margin-bottom: 3vh;">
                    <%= message %><%= name %>!
                </h1>
                <h2 style="margin-bottom: 2vh;">Welcome to <i>Bank Management System</i></h2>
                <h3 style="margin-bottom: 1vh;">Customer Management:</h3>
                <ul style="list-style-type: '&#x2192'; line-height:180%; margin-left: 3vh;">
                    <li>
                        <p style="margin-left: 1vh;"><i>Add </i> new customer.</p>
                    </li>
                    <li>
                        <p style="margin-left: 1vh;"><i>View</i> details of customers. </p>
                    </li>
                    <li>
                        <p style="margin-left: 1vh;"><i>Update </i> name/password.</p>
                    </li>
                    <li>
                        <p style="margin-left: 1vh;"> <i>Block/unblock </i>customer accounts.</p>
                    </li>
                    <li>
                        <p style="margin-left: 1vh;"> <i>Delete </i>customer accounts.</p>
                    </li>
                    <li>
                        <p style="margin-left: 1vh;"> <i>View All </i>customer accounts.</p>
                    </li>
                </ul>
            </div>
            <div id="inner-card">
                <div id="inner-inner-card">
                    <form action="addCus" id="form">
                        <div>
                            <h2 style="text-align: center;margin-bottom: 4vh;">Add New Customer</h2>
                        </div>
                        <h4>Name</h4>
                        <div class="inputForms">
                            <input type="text" name="name" class="fg1" required>
                        </div>
                        <h4>Account Number(12 digits)</h4>
                        <div class="inputForms">
                            <input type="text" pattern="^[0-9]{12,12}$" name="acNum" class="fg1" required>
                        </div>
                        <h4>Pincode</h4>
                        <div class="inputForms">
                            <input type="password" name="pin" class="fg1" required>
                        </div>
                        <h4>Balance</h4>
                        <div class="inputForms">
                            <input type="number" name="balance" class="fg1" value="2000.0" readonly>
                        </div>
                        <h4>Status</h4>
                        <div class="inputForms">
                            <div id="radio">
                                <input type="radio" name="status" value="true" required> Active
                            </div>
                            <div id="radio">
                                <input type="radio" name="status" value="false" required> Block
                            </div>
                        </div>
                        <div>
                            <input type="submit" value="submit" id="button">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var links = document.querySelectorAll('.myLink');
            function handleClick(link) {
                var userInput = prompt("Enter Account Number (12 digits):");
                if (!userInput) {
                    return;
                }
                userInput = userInput.trim();
                if (userInput.length !== 12) {
                    alert("Invalid input. Entered number should be exactly 12 digits.");
                    return;
                }
                window.location.href = link.getAttribute("href") + "?acc=" + userInput;
            }

            links.forEach(function (link) {
                link.addEventListener('click', function (event) {
                    event.preventDefault();
                    handleClick(link);
                });
            });
        });
    </script>
</body>

</html>