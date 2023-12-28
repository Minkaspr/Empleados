
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!<!--  -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Empleado</title>
    </head>
    <body>
        <form action="Empleado">
            <label>
                Ingrese Codigo:
                <input type="text" name="codigo"/>
            </label>
            </br>
            <label>
                Ingrese Nombre:
                <input type="text" name="nombre"/>
            </label>
            </br>
            <label>
                Ingrese Edad:
                <input type="number" name="edad"/>
            </label>
            </br>
            <label>
                Ingrese Sexo:
                <input type="text" name="sexo"/>
            </label>
            </br>
            <label>
                Ingrese Sueldo:
                <input type="number" name="sueldo"/>
            </label>
            </br>
            <input type="hidden" name="opcion" value="insertar"/>
            <input type="submit" value="Registrar Empleado"/>
        </form>
    </body>
</html>
