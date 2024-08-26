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
            margin: 0;
            background-color: #d8b4dd; /* Pastel purple background */
            background-image: url('/backgrounds/music_notes_background.jpg');
            background-size: cover;
            background-repeat: no-repeat;
        }
        .song-details {
            max-width: 90%; /* Adjust max-width to fit smaller screens */
            margin: 0 auto;
            padding: 15px;
            box-sizing: border-box;
            background: white; /* Add white background to song details for better contrast */
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Optional: add a subtle shadow */
            display: flex;
            flex-direction: column; /* Ensure items stack vertically */
            align-items: center;
        }
        .song-title {
            font-size: 2rem; /* Adjust font size for responsiveness */
            color: #333;
            margin-bottom: 15px;
            text-align: center;
        }
        .song-lyrics {
            font-size: 1rem; /* Adjust font size for better readability on mobile */
            color: #666;
            margin-top: 10px;
            overflow-y: auto;
            max-height: 60vh; /* Make sure lyrics container does not overflow the screen */
            padding: 10px;
            box-sizing: border-box;
        }
        .song-image {
            max-width: 100%;
            max-height: 400px;
            height: auto;
            display: block;
            margin: 20px auto;
        }
        .youtube-player {
            width: 100%;
            max-width: 560px;
            height: 315px;
            margin: 20px 0;
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
            margin-top: 20px; /* Ensure some space above the button */
            transition: background-color 0.3s ease;
        }
        .back-button:hover {
            background-color: darkred;
        }
        /* Add media query for smaller screens */
        @media (max-width: 600px) {
            .song-title {
                font-size: 1.5rem;
            }
            .song-lyrics {
                font-size: 0.9rem;
                max-height: 50vh;
            }
            .song-image {
                max-height: 300px;
            }
            .youtube-player {
                height: 200px; /* Adjust height for smaller screens */
            }
        }
    </style>
</head>
<body>
<div class="song-details">
    <h1 class="song-title">${song.title}</h1>
    <img src="/image/${song.id}" alt="${song.title}" class="song-image"/>
    <div class="song-lyrics">
        <p>${song.lyrics?replace('\n', '<br/>')}</p>
    </div>
    <!-- YouTube embedded player -->
    <iframe class="youtube-player" src="https://www.youtube.com/embed/${song.youTube}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    <a href="/" class="back-button">Terug</a>
</div>
</body>
</html>
