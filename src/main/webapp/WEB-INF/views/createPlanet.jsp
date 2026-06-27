<!DOCTYPE html>
<html>
<head>
    <title>Create Planet - HeartVerse</title>

    <style>
        body{
            font-family: Arial, sans-serif;
            background:#FFEAF4;
            margin:0;
            padding:0;
        }

        .container{
            width:450px;
            margin:50px auto;
            background:white;
            padding:30px;
            border-radius:12px;
            box-shadow:0px 0px 15px rgba(0,0,0,0.15);
        }

        h1{
            text-align:center;
            color:#E91E63;
        }

        label{
            font-weight:bold;
        }

        input, textarea, select{
            width:100%;
            padding:10px;
            margin-top:5px;
            margin-bottom:18px;
            border-radius:6px;
            border:1px solid #ccc;
        }

        button{
            width:100%;
            padding:12px;
            background:#E91E63;
            color:white;
            border:none;
            border-radius:6px;
            font-size:16px;
            cursor:pointer;
        }

        button:hover{
            background:#C2185B;
        }
    </style>

</head>

<body>

<div class="container">

    <h1>Create Planet</h1>

    <form action="/createPlanet" method="post">

        <label>Planet ID</label>
        <input type="number" name="planetId" required>

        <label>Planet Name</label>
        <input type="text" name="planetName" required>

        <label>Description</label>
        <textarea name="description"></textarea>

        <label>Theme</label>

        <select name="theme">
            <option>Pink</option>
            <option>Purple</option>
            <option>Blue</option>
            <option>Green</option>
            <option>Orange</option>
        </select>

        <button type="submit">
            Create Planet
        </button>

    </form>

</div>

</body>
</html>