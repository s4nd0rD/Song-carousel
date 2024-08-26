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
            background-color: #e6e0f8;
            background-image: url('/music_notes_background.png');
            background-size: cover;
            background-repeat: no-repeat;
        }
        .container {
            position: absolute;
            top: 25%;
            left: 50%;
            transform: translateX(-50%);
            text-align: center;
            width: 70%;
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
            width: 90%;
        }
        .button:hover {
            background-color: darkred;
        }
        @media (max-width: 600px) {
            .container {
                width: 90%; /* Adjust container width for smaller screens if needed */
                top: 30%; /* Adjust top positioning for better appearance on small screens */
            }
            .button {
                font-size: 20px; /* Adjust font size if needed */
                padding: 15px; /* Adjust padding if needed */
            }
        }
    </style>
</head>
<body>
<div class="container">
    <a href="/song" class="button">Tik hier voor een kinderliedje!</a>
</div>
</body>
</html>
