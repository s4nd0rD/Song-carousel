<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Suggestion Received</title>
    <link rel="stylesheet" type="text/css" href="/static/css/suggestion.css">
    <link rel="stylesheet" type="text/css" href="/static/css/home.css">
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