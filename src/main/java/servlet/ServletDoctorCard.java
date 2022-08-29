package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.TableCreate;
import model.DoctorCard;
import service.DoctorCardService;
import service.DoctorCardServicePostgres;
import servlet.dto.DoctorCardDTO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@WebServlet("/doctorCard")

public class ServletDoctorCard extends HttpServlet {

    private ObjectMapper objectMapper;
    private DoctorCardService doctorCardService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorCardDTO doctorCardDTO = objectMapper.readValue(req.getReader().lines()
                .collect(Collectors.joining()), DoctorCardDTO.class);
        DoctorCard doctorCard = new DoctorCard();
        doctorCard.setName(doctorCardDTO.getName());
        doctorCard.setDateOfBirth(LocalDate.parse(doctorCardDTO.getDateOfBirth(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        doctorCard.setSpecialization(doctorCardDTO.getSpecialization());
        doctorCard.setWorkExperience(doctorCardDTO.getWorkExperience());
        doctorCardService.create(doctorCard);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        TableCreate.createTable();
        objectMapper = new ObjectMapper();
        doctorCardService = new DoctorCardServicePostgres();
        super.init(config);
    }
}
