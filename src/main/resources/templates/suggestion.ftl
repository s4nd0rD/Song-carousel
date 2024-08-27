<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Suggestion Received</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #e6e0f8;
            background-image: url('/music_notes_background.png');
            background-size: cover;
            background-repeat: no-repeat;
        }
        .container {
            background: white;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 90%;
            box-sizing: border-box;
        }
        .message {
            font-size: 1.5rem;
            color: #333;
        }
        .back-button {
            display: inline-block;
            font-size: 1rem;
            color: white;
            background-color: red;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }
        .back-button:hover {
            background-color: darkred;
        }
    </style>
</head>
<body>
<div class="container">
    <#if errorMessage??>
        <p class="message">${errorMessage}</p>
    <#else>
        <p class="message">${message}</p>
    </#if>
    <a href="/" class="back-button">Terug</a>
</div>
</body>
</html>