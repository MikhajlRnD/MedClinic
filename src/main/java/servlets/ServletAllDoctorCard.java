package servlets;
import model.DoctorCard;
import service.DoctorCardService;
import service.DoctorCardServicePostgres;
import view.EEOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/allDoctorCard")

public class ServletAllDoctorCard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(EEOperation.GET_ALL.getValue());
        DoctorCardService doctorCardService = new DoctorCardServicePostgres();
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(String.valueOf(doctorCardService.getAll()));
        printWriter.close();
    }

}
