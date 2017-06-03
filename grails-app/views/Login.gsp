<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  
  <a href="https://accounts.google.com/o/oauth2/auth?
scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile&
state=%2Fprofile&
redirect_uri=http://localhost:8080/OauthProject/oauthGoogle/googleredirect&
response_type=code&
client_id=1036578206093.apps.googleusercontent.com&
approval_prompt=force">Login with google</a>

<br>
<a href="https://accounts.google.com/o/oauth2/token?
code=4/Th5i9EpksrPgdTtOkseWcboREIbJ.8rJPjKR4crMUgrKXntQAax0sPNxSeQI&
client_id=1036578206093.apps.googleusercontent.com&
client_secret=qqhlp-9Dc9wwVKDiS4-2Pn8g&
redirect_uri=http://localhost:8080/OauthProject/oauthGoogle/index&
grant_type=authorization_code">get the token</a>

<br>

<a href="https://accounts.google.com/o/oauth2/auth?
scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile&
state=%2Fprofile&
redirect_uri=http://localhost:8080/OauthProject/oauthGoogle/googleredirect&
response_type=token&
client_id=1036578206093.apps.googleusercontent.com"> to get the token id using cient login </a>


<br>
<a href="https://www.googleapis.com/oauth2/v1/userinfo?access_token=ya29.AHES6ZRdyyn9274SAXCVNmkxP3wtBXW8m4WEIaZal3CBbsnRKnyyDng">get the user info</a>
<br>

<a href="http://localhost:8080/OauthProject/oauthGoogle/xyz">To get the json</a>






<br><br><br><br>

<a href ="https://www.facebook.com/dialog/oauth?client_id=541669239191656
&redirect_uri=http://localhost:8080/OauthProject/oauthGoogle/facebookRedirect
&state=upsdps&scope=user_birthday,read_stream" >Login with facebook</a>
  </div>
</body>
</html>