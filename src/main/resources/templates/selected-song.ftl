<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Selected Song</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }
        .song-details {
            text-align: center;
        }
        .song-title {
            font-size: 36px;
            color: #333;
        }
        .song-lyrics {
            font-size: 18px;
            color: #666;
            margin-top: 20px;
        }
        .song-image {
            max-width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<div class="song-details">
    <h1 class="song-title">${song.title}</h1>
    <img src="/image/${song.id}" alt="${song.title}" class="song-image"/>
    <div class="song-lyrics">
        <p>${song.lyrics}</p>
    </div>
</div>
</body>
</html>
