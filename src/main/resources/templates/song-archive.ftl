<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Song Archive</title>
    <link rel="stylesheet" type="text/css" href="/static/css/song-archive.css">
</head>
<body>
<div class="container">
    <h1>Liedjes Archief</h1>
    <ul>
        <#list songOverview?sort_by("title") as song>
            <li>
                <a href="/song/${song.id}?origin=song-archive">${song.title}</a>
            </li>
        </#list>
    </ul>
    <div class="suggestion-box">
        <form action="/suggestion" method="post">
            <textarea name="suggestion" rows="4" placeholder="Welk kinderliedje mis je nog?"></textarea>
            <button type="submit" class="submit-button">Verstuur</button>
        </form>
    </div>
    <a href="/" class="back-button">Terug</a>
</div>
</body>
</html>