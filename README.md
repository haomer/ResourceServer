# ResourceServer
This is the OAuth2 ResourceServer Demo that the Spring boot project launch.
getToken:curl -vv  -i -X POST "http://localhost:8083/oauth/token" -H "Accept: application/json" -u "client:secret" -d "grant_type=client_credentials" -d "scope=read"
getResource:curl -i -H "Authorization: Bearer afe67209-01c8-4645-a1bf-8531d4aa1968" http://localhost:8084/hello
