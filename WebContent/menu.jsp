<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  margin: 0;
  font-size: 28px;
}



.navbar {
  overflow: hidden;
  background-color: #333;
  position:fixed;
  top:0;
  width:100%;
}

.navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.navbar a:hover {
  background-color: #ddd;
  color: black;
}


.main {
  padding: 16px;
  margin-top: 30px;
  height:1500px; /* Used in this example to enable scrolling */
}
.left{
display: inline-block;
� � width: 50%;
� � float:left;
}
.right{

display: inline-block;
� � width: 50%;
� � float:right;}
.p{
font-size="12px";
}
</style>
</head>

<body>
<div class="navbar">
 	 	
   <a href="home.jsp">Home</a>
   <a href="map">Map</a>
   <a href="hotels.jsp">Hotels</a>
   <a href="to_do.jsp">Things to do</a>
   <a href="food.jsp">Food</a>
   <a href="places.jsp">Places to visit</a>
   <a href="welcome.jsp">Login</a>
  
</div> 


</body>
</html>