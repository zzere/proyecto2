<%-- 
    Document   : loginAdmin
    Created on : 30 abr. 2023, 16:53:24
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <link rel="stylesheet" href="stiloLogin.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace+SC&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header>
            <h1>
                Iniciar sesion:
            </h1>
        </header>
        <main>
            
            <form action="verificarusuario" method="post">

                <p>Correo:<input type="text" name="txtCorreo" value="andres@hotmail.com"></p>
                <p>Contraseña:<input type="text" name="txtContraseña" value="1233"></p>

                <input type="submit" name="enviar" value="Agregar">
            </form>
        </main>
        <footer>

        </footer>
    </body>
</html>
