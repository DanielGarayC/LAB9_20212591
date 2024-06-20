package org.example.lab9.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab9.daos.UsuarioDao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
@WebServlet(name = "LoginServlet", value = "/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        RequestDispatcher view;
        UsuarioDao usuarioDao = new UsuarioDao();


        switch (action) {
            case "lista":
                request.setAttribute("listaUsuarios", usuarioDao.listarUsuarios());
                view = request.getRequestDispatcher("vistas/listaUsuarioSistema.jsp");
                view.forward(request, response);
                break;

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


    }
}
