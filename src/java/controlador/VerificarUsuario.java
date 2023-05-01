/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;
import modelo.Informante;

@WebServlet(name = "verificarusuario", urlPatterns = {"/verificarusuario"})
public class VerificarUsuario extends HttpServlet {

    Conexion instancia = Conexion.getInstance();
    Informante informante = new Informante();
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String correo = request.getParameter("txtCorreo");
            String contraseña = request.getParameter("txtContraseña");
            
            boolean usuarioExistente = false;
            Connection conexion = instancia.conectar();
            //se busca en la bd la fila que cumpla con esos 2 valores para verificar si existe
            
            PreparedStatement stmt = conexion.prepareStatement("select * from tablaInformante where correo='" + correo + "' and contraseña='" + contraseña + "'");

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuarioExistente = true;

                if (usuarioExistente == true) {
                    request.getRequestDispatcher("homeForm.html").forward(request, response);
                }
            } else {
                //mensaje no es correcto usuario o contraseña
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
