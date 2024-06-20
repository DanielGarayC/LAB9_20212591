<%@ page import="org.example.lab9.beans.usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% String currentPage = request.getParameter("currentPage"); %>
<jsp:useBean id="usuarioLogueado" scope="session" type="usuario" class="org.example.lab9.beans.usuario" />

<nav class="navbar navbar-expand-md navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%=request.getContextPath()%>">Lista de Usuarios en el sistema</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link <%=currentPage.equals("Ganancias") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/EmployeeServlet">
                        Employees
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%=currentPage.equals("Combustible") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/JobServlet">
                        Jobs
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%=currentPage.equals("Pais") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/StatServlet">
                        Stats
                    </a>
                </li>
                <li class="nav-item">
                    <% if(usuarioLogueado.getIdUsuario() == 0){ %>
                    <a class="nav-link" style="text-decoration: underline;color: #0d6efd;"
                       href="<%=request.getContextPath()%>/LoginServlet">
                        (Iniciar sesión)
                    </a>
                    <% }else{ %>
                    <a class="nav-link disabled"><%=usuarioLogueado.getNombres() + " " + usuarioLogueado.getApellidos()%></a>
                    <% } %>
                </li>
                <% if(usuarioLogueado.getIdUsuario() != 0){ %>
                <li class="nav-item">
                    <a class="nav-link" style="text-decoration: underline;color: #0d6efd;" href="<%=request.getContextPath()%>/LoginServlet?a=lo">(Cerrar sesión)</a>
                </li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>
