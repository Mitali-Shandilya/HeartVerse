<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

    <title>HeartVerse Dashboard</title>

    <style>

        body{
            margin:0;
            font-family:Arial;
            background:#FFEAF4;
        }

        .container{
            width:80%;
            margin:auto;
            margin-top:40px;
        }

        h1{
            color:#E91E63;
            text-align:center;
        }

        .top{
            text-align:right;
            margin-bottom:20px;
        }

        .btn{
            text-decoration:none;
            background:#E91E63;
            color:white;
            padding:10px 18px;
            border-radius:6px;
            margin-left:10px;
        }

        .planet{
            background:white;
            padding:20px;
            margin-top:15px;
            border-radius:10px;
            box-shadow:0 0 8px lightgray;
        }

        h2{
            color:#7B1FA2;
        }

    </style>

</head>

<body>

<div class="container">

    <h1>HeartVerse</h1>

    <div class="top">

        <a href="/createPlanet" class="btn">
            +Create Planet
        </a>

        <a href="/logout" class="btn">
            Logout
        </a>

    </div>

    <c:forEach var="planet" items="${planets}">

        <div class="planet">

            <h2>${planet.planetName}</h2>

            <p>
                <b>Description:</b>
                ${planet.description}
            </p>

            <p>
                <b>Theme:</b>
                ${planet.theme}
            </p>

            <p>
                <b>Created:</b>
                ${planet.createdDate}
            </p>

        </div>

    </c:forEach>

</div>

</body>
</html>