<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }
        .container {
            text-align: center;
        }
        .button {
            font-size: 24px;
            color: white;
            background-color: red;
            border: none;
            padding: 20px 40px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .button:hover {
            background-color: darkred;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- Update the href to navigate to /song -->
    <a href="/song" class="button">Druk hier voor een kinderliedje!</a>
</div>
</body>
</html>
