/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.webappupeumvc.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.webappupeumvc.dao.PersonaDAO;
import pe.edu.upeu.webappupeumvc.modelo.Persona;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@WebServlet(name = "PersonaControl", urlPatterns = {"/PersonaControl"})
public class PersonaControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PersonaDAO dao;
        int opt=0;
        try (PrintWriter out = response.getWriter()) {          
        opt=Integer.parseInt(request.getParameter("opt")==null?"0": request.getParameter("opt"));
        switch(opt){
            case 1: 
            dao=new PersonaDAO();
            List<Persona> lista=dao.listarPersona();                
            request.getSession().setAttribute("ListaPersona", lista);
            response.sendRedirect("modulos/persona/mainPersona.jsp");
                break;
            case 2: {
                System.out.println("Holasssssssssss");  
            response.sendRedirect("modulos/persona/mainPersona.jsp");
            } break;
            case 3: {} break;
            case 4: {} break;
            default:break;
        }              
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
