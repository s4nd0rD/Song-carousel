<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Selected Song</title>
    <link rel="stylesheet" type="text/css" href="/static/css/selected-song.css">
</head>
<body>
<div class="song-details">
    <h1 class="song-title">${song.title}</h1>
    <img src="/image/${song.id}" alt="${song.title}" class="song-image"/>
    <div class="song-lyrics">
        <p>${song.lyrics?replace('\n', '<br/>')}</p>
    </div>
    <iframe class="youtube-player" src="https://www.youtube.com/embed/${song.youTube}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    <#if origin??>
        <div class="back-button">
            <a href="/${origin}">Terug</a>
        </div>
    <#else>
        <div class="back-button">
            <a href="/">Terug</a>
        </div>
    </#if>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var referrer = document.referrer;
        var backLink = document.getElementById('back-link');
        if (referrer.includes('/song-archive')) {
            backLink.href = '/song-archive.html';
        } else {
            backLink.href = '/';
        }
    });
</script>
</body>
</html>
