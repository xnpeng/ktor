<#import "template.ftl" as layout />

<@layout.mainLayout title="Welcome">
<form class="pure-form-stacked" action="/login" method="post" enctype="application/x-www-form-urlencoded">

    <label for="userId">Login
        <input type="text" name="userId" id="userId" value="">
    </label>


    <label for="password">Password
        <input type="password" name="password" id="password">
    </label>

    <input class="pure-button pure-button-primary" type="submit" value="Login">
</form>
</@layout.mainLayout>