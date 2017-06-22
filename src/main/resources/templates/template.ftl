<#macro mainLayout title="Welcome">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>KtorApp</title>
    <link rel="stylesheet" type="text/css" href="/styles/style.css">
</head>
<body>
<div class="pure-g">

    <div class="sidebar pure-u-1 pure-u-md-1-4">
        <div class="header" style="margin-top: 10px">
            <div class="pure-img-responsive">
                <img src="/images/logo.png">
            </div>
            <div class="brand-title">KtorApp Navigator</div>
            <nav class="nav">
                <ul class="nav-list">
                    <li class="nav-item"><a class="pure-button" href="/">Home page</a></li>
                    <br/>
                    <li class="nav-item"><a class="pure-button" href="/login">Login page</a></li>
                    <br/>
                    <li class="nav-item"><a class="pure-button" href="/logout">Logout page</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="content pure-u-1 pure-u-md-3-4">
        <h2>Ktor App</h2>
        <#nested />
    </div>
    <div class="footer" style="margin:auto;border-top: 1px solid gray">
        ktor Inc., ${.now?string("yyyy")}
    </div>
</div>
</body>
</html>
</#macro>
