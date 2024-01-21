<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit</title>
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
            width: 8vw;
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
                <form action="deposit" id="inner_container">
                    <div>
                        <h2>Amount</h2> <input type="number" name="amount" min="1" placeholder="0">
                    </div>
                    <div>
                        <h2>Pincode</h2> <input type="password" name="pin">
                    </div>
                    <div>
                        <input type="submit" value="Deposit" id="button">
                    </div>
                </form>
            </div>
            <div>
                <form action="cus_login">
                    <input type="submit" value="Back" id="button">
                </form>
            </div>
        </div>
    </div>
</body>

</html>