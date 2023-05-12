<%-- 
    Document   : loginUsuario
    Created on : 11/05/2023, 12:51:10 p. m.
    Author     : juan
--%>
<%@page import="controlador.*" %>
<%@page import="modelo.*" %>
<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesion</title>
    </head>
    <body>
        
        <form action="ControladorInformante" method="get">
            <input type="hidden" name="accion" value="verificar">
            Correo: <input type="text" name="txtCorreo"><br>
            Contraseña: <input type="text" name="txtContraseña"><br>
            <input type="submit" value="Registrar" >
        </form>
        
    </body>
</html>
