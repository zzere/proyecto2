<%-- 
    Document   : frmRobo
    Created on : 1 may. 2023, 21:21:31
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>

<head>
    <title>Registrar ciudad</title>
    <link rel="stylesheet" href="stilo.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="funciones.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace+SC&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>

    <header>
        <h1>Registrar ciudad</h1>
    </header>

    <form action="ControladorRobo" method="get">
        <p>Ciudad/Municipio</p><br>
        <input type="hidden" name="accion" value="agregar">
        <input type="text" name="txtCiudad" placeholder="Ciudad" ><br>
        <input type="text" name="txtBarrio" placeholder="Barrio"> <br>
        <input type="submit" value="Registrar" >
        <input type="button" value="Agregar" id="btnRegistrar" >
    </form>

    <br>
    <div>
        <% 
            String mensaje= request.getParameter("mensaje");
            if(mensaje!= null){
                out.print(mensaje);
            }
        %>
    </div>
    
    <a href="index.html">home</a>

</body>

</html>