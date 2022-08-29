package incorrectServlet;

import model.DoctorCard;
import model.LogOperation;
import service.DoctorCardService;
import service.DoctorCardServicePostgres;
import service.Log;
import service.LogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet("/doctorCard")

public class ServletDoctorCard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorCardService doctorCardService = new DoctorCardServicePostgres();
        resp.setContentType("text/html");
        try (PrintWriter printWriter = resp.getWriter();) {
            printWriter.write(String.valueOf(doctorCardService.getById(Long.valueOf(req.getParameter("id")))));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorCard doctorCard = new DoctorCard();
        DoctorCardService doctorCardService = new DoctorCardServicePostgres();
        LogService<Object> log = new Log();
        doctorCard.setId(Long.valueOf(req.getParameter("id")));
        doctorCard.setName(req.getParameter("name"));
        String date = req.getParameter("dateOfBirth");
        doctorCard.setDateOfBirth(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        doctorCard.setSpecialization(req.getParameter("specialization"));
        doctorCard.setWorkExperience(Integer.valueOf(req.getParameter("workExperience")));
        doctorCard.setLastUpdatedDate(LocalDateTime.now());
        doctorCardService.create(doctorCard);
        log.log(LogOperation.CREATE, doctorCard);
    }
}
