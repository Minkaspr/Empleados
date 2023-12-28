
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Empleado"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cbo Empleado</title>
        <link rel="icon" href="assets/Clase.png">
    </head>
    <body>
        <h2>Consulta por nombre</h2>
        <form action="Empleado" method="get">
            <label>
                Seleccione Empleado:
                <select name="nombre">
                    <option>- Seleccione -</option>
                    <% 
                    ArrayList<Empleado> lista = (ArrayList<Empleado>)request.getAttribute("lista");
                    for(int i = 0; i < lista.size(); i++){
                        Empleado empleado = lista.get(i);
                    
                    %>
                    <option value="<%= empleado.getNombre() %>"><%= empleado.getNombre() %></option>
                    <%  
                        }
                    %>
                </select>
            </label>
            <input type="hidden" name="opcion" value="consultaNom"/>
            <input type="submit" value="Consultar Empleado"/>
        </form>

    </body>
</html>
