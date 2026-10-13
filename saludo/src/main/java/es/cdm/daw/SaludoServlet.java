package es.cdm.daw;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SaludoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        if (nombre == null || nombre.isBlank()) {
            nombre = "desconocido";
        }
        String saludo = getInitParameter("saludo");
        String centro = getServletContext().getInitParameter("centro");

        resp.setContentType("text/html;charset=UTF-8");

        req.setAttribute("saludo", saludo);
        req.setAttribute("nombre", escapar(nombre));
        req.setAttribute("centro", centro);
        req.getRequestDispatcher("/WEB-INF/vistas/saludo.jsp").forward(req, resp);


    }

    private String escapar(String texto) {
        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}