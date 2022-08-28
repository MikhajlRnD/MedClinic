package servlets;
import configuration.TableCreate;
import model.DoctorCard;
import model.LogOperation;
import service.DoctorCardService;
import service.DoctorCardServicePostgres;
import service.Log;
import service.LogService;
import view.EEOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/")

public class ServletMed extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TableCreate.createTable();
        resp.getWriter().write(EEOperation.CREATE.getValue());
        resp.getWriter().write(EEOperation.UPDATE.getValue());
        resp.getWriter().write(EEOperation.DELETE.getValue());
        resp.getWriter().write(EEOperation.GET_BY_ID.getValue());
        resp.getWriter().write(EEOperation.LINK_GET_ALL.getValue());
    }


}
