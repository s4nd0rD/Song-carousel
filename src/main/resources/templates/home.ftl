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
        .suggestion-box {
            margin-top: 20px;
            width: 100%;
            max-width: 600px;
            margin-left: auto;
            margin-right: auto;
        }
        .suggestion-box textarea {
            width: 100%;
            padding: 15px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ccc;
            resize: none;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
        .suggestion-box textarea::placeholder {
            color: rgba(0, 0, 0, 0.5); /* Transparent placeholder */
            font-style: italic; /* Cursive style */
        }
        .submit-button {
            margin-top: 10px;
            font-size: 18px;
            color: white;
            background-color: green;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .submit-button:hover {
            background-color: darkgreen;
        }
        @media (max-width: 600px) {
            .container {
                width: 90%;
                top: 20%;
            }
            .button {
                font-size: 20px;
                padding: 15px;
            }
            .submit-button {
                width: 90%;
                font-size: 16px;
                padding: 10px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <a href="/song" class="button">Tik hier voor een kinderliedje!</a>
    <div class="suggestion-box">
        <form action="/suggestion" method="post">
            <textarea name="suggestion" rows="4" placeholder="Welk kinderliedje mis je nog?"></textarea>
            <button type="submit" class="submit-button">Verstuur</button>
        </form>
    </div>
</div>
</body>
</html>
