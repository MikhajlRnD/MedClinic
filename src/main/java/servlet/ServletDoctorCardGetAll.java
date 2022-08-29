package servlet;


import service.DoctorCardService;
import service.DoctorCardServicePostgres;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/card/doctor/getAll")

public class ServletDoctorCardGetAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorCardService doctorCardService = new DoctorCardServicePostgres();
        resp.setContentType("text/html");

        try (
                PrintWriter printWriter = resp.getWriter();){
            printWriter.write(String.valueOf(doctorCardService.getAll()));
        }
    }
}
