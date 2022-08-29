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

@WebServlet("/deleteDoctorCard")

public class ServletDoctorCardDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorCard doctorCard = new DoctorCard();
        DoctorCardService doctorCardService = new DoctorCardServicePostgres();
        LogService<Object> log = new Log();
        doctorCard.setId(Long.valueOf(req.getParameter("id")));
        doctorCard = (DoctorCard) doctorCardService.getById(doctorCard.getId());
        doctorCardService.delete(doctorCard.getId());
        log.log(LogOperation.DELETE, doctorCard);
    }
}

