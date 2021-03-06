<#import "template.ftl" as layout />

<@layout.mainLayout title="Welcome">

<div class="posts">
    <h3 class="content-subhead">Top Posts</a></h3>
    <ul>
        <li>kotlin</li>
        <li>ktor</li>
        <li>swift</li>
    </ul>
</div>

<div class="alert">
    <#if error??>
        <p class="error">
        <h1>${error}</h1>
        </p>
        <a href="/login">Retry</a> with "username" and "password".
    </#if>

    <#if user??>
        <p class="error">
        <h2>Welcome,you are in.</h2>
        </p>
    </#if>

    <#if logout??>
        <p class="error">
        <h2>You are logout, bye!</h2>
        </p>
    </#if>

</div>
</@layout.mainLayout>
