Learn kotlin with ktor.

### When set static content folder like:

``` 
static("public"){
    files(".")
}
```

we can put all static files under the public folder, css,js,images.

There is one thing may be issue: when doing this, *location class for get and post cannot be the same.*

For example:

``` 
@location("/login") class Login(val userId:String,val password:String)

fun Route.loginHandler(){
    get<Login>{
        call.respond(FreeMarkerTamplate("login.ftl",mapOf(...),""))
    }

    post<Login>{
        ...
    }
}

```

Then from web browser, request for http://localhost:8081/login returns 
404 error.

While disable the static folder lines, the url is available.

So, if we write different location class, problem solved.

``` 
@location("/login") class Signin
@location("/login") class Login(val userId:String,val password:String)

fun Route.loginHandler(){
    get<Sigin>{
        call.respond(FreeMarkerTamplate("login.ftl",mapOf(...),""))
    }

    post<Login>{
        ...
    }
}

```