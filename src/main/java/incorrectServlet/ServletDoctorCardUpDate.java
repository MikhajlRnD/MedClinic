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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/updateDoctorCard")

public class ServletDoctorCardUpDate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorCard doctorCard = new DoctorCard();
        DoctorCardService doctorCardService = new DoctorCardServicePostgres();
        LogService log = new Log();
        doctorCard.setId(Long.valueOf(req.getParameter("id")));
        doctorCard.setName(req.getParameter("name"));
        String date = req.getParameter("dateOfBirth");
        doctorCard.setDateOfBirth(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        doctorCard.setSpecialization(req.getParameter("specialization"));
        doctorCard.setWorkExperience(Integer.valueOf(req.getParameter("workExperience")));
        doctorCard.setLastUpdatedDate(LocalDateTime.now());
        doctorCardService.update(doctorCard.getId(), doctorCard);
        log.log(LogOperation.UPDATE, doctorCard);
    }
}
