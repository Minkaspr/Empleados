
package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Empleado;
import util.ConexionBD;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/Empleado"})
public class EmpleadoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String op = request.getParameter("opcion");
        ConexionBD conexion = new ConexionBD();
        
        if (op.equals("listar")) {
            try {
                PreparedStatement ps = conexion.conexionBD()
                        .prepareStatement("SELECT * FROM empleado");
                ResultSet rs = ps.executeQuery();
                
                ArrayList<Empleado> lista = new ArrayList<>();
                while (rs.next()) {                    
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(rs.getString(1));
                    empleado.setNombre(rs.getString(2));
                    empleado.setEdad(rs.getInt(3));
                    empleado.setSexo(rs.getString(4));
                    empleado.setSueldo(rs.getDouble(5));
                    lista.add(empleado);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("empleadoSel.jsp").forward(request, response);
            } catch (Exception e) {
            }
            
        } else if (op.equals("insertar")) {
            
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String sexo = request.getParameter("sexo");
            double sueldo = Double.parseDouble(request.getParameter("sueldo"));
            
            try {
                PreparedStatement ps = conexion.conexionBD()
                        .prepareStatement("INSERT INTO empleado VALUES (?,?,?,?,?)");
                ps.setString(1, codigo);
                ps.setString(2, nombre);
                ps.setInt(3, edad);
                ps.setString(4, sexo);
                ps.setDouble(5, sueldo);
                ps.executeUpdate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (Exception e) {
            }
            
        } else if (op.equals("consultaCod")){
            String cod = request.getParameter("cod");
            
            try {
                PreparedStatement ps = conexion.conexionBD()
                        .prepareStatement("SELECT * FROM empleado WHERE codigo = ? ");
                ps.setString(1, cod);
                ResultSet rs = ps.executeQuery();
                
                ArrayList<Empleado> lista = new ArrayList<>();
                
                while(rs.next()){
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(rs.getString(1));
                    empleado.setNombre(rs.getString(2));
                    empleado.setEdad(rs.getInt(3));
                    empleado.setSexo(rs.getString(4));
                    empleado.setSueldo(rs.getDouble(5));
                    lista.add(empleado);
                }
                request.setAttribute("lista",lista);
                request.getRequestDispatcher("empleadoSel.jsp").forward(request, response);
            } catch (Exception e) {
            }
            
        } else if (op.equals("cboNombres")){
            
            try {
                PreparedStatement ps = conexion.conexionBD()
                        .prepareStatement("SELECT nombre FROM empleado");
                ResultSet rs = ps.executeQuery();
                
                ArrayList<Empleado> lista = new ArrayList<>();
                
                while(rs.next()){
                    Empleado empleado = new Empleado();
                    empleado.setNombre(rs.getString(1));
                    lista.add(empleado);
                }
                request.setAttribute("lista",lista);
                request.getRequestDispatcher("index2.jsp").forward(request, response);
            } catch (Exception e) {
            }
        } else if (op.equals("consultaNom")){
            String nom = request.getParameter("nombre");
            try {
                PreparedStatement ps = conexion.conexionBD()
                        .prepareStatement("SELECT * FROM empleado WHERE nombre = ? ");
                ps.setString(1, nom);
                ResultSet rs = ps.executeQuery();
                
                ArrayList<Empleado> lista = new ArrayList<>();
                
                while(rs.next()){
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(rs.getString(1));
                    empleado.setNombre(rs.getString(2));
                    empleado.setEdad(rs.getInt(3));
                    empleado.setSexo(rs.getString(4));
                    empleado.setSueldo(rs.getDouble(5));
                    lista.add(empleado);
                }
                request.setAttribute("lista",lista);
                request.getRequestDispatcher("empleadoSel.jsp").forward(request, response);
            } catch (Exception e) {
            }
        } else if (op.equals("consultaGen")){
            String radGen = request.getParameter("radGen");
            try {
                PreparedStatement ps = conexion.conexionBD()
                        .prepareStatement("SELECT * FROM empleado WHERE sexo = ? ");
                ps.setString(1, radGen);
                ResultSet rs = ps.executeQuery();
                
                ArrayList<Empleado> lista = new ArrayList<>();
                
                while(rs.next()){
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(rs.getString(1));
                    empleado.setNombre(rs.getString(2));
                    empleado.setEdad(rs.getInt(3));
                    empleado.setSexo(rs.getString(4));
                    empleado.setSueldo(rs.getDouble(5));
                    lista.add(empleado);
                }
                request.setAttribute("lista",lista);
                request.getRequestDispatcher("empleadoSel.jsp").forward(request, response);
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
