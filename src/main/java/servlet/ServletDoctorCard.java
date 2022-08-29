package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet("/card/doctor")

public class ServletDoctorCard extends HttpServlet {

    private ObjectMapper objectMapper;
    private DoctorCardService doctorCardService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(objectMapper.writeValueAsString(doctorCardService.getById(UUID.fromString(req.getParameter("id")))));

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
        DoctorCardDTO doctorCardDTO = objectMapper.readValue(req.getReader().lines().
                collect(Collectors.joining()), DoctorCardDTO.class);
        UUID id = UUID.fromString(req.getParameter("id"));
        DoctorCard doctorCard = doctorCardService.getById(id);
        if (doctorCardDTO.getName() != null) {
            doctorCard.setName(doctorCardDTO.getName());
        }
        if (doctorCardDTO.getSpecialization() != null) {
            doctorCard.setSpecialization(doctorCardDTO.getSpecialization());
        }
        if (doctorCardDTO.getWorkExperience() != null) {
            doctorCard.setWorkExperience(doctorCardDTO.getWorkExperience());
        }
        if (doctorCardDTO.getDateOfBirth() != null) {
            doctorCard.setDateOfBirth(LocalDate.parse(doctorCardDTO.getDateOfBirth(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        }
        doctorCardService.update(id, doctorCard);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doctorCardService.delete(UUID.fromString(req.getParameter("id")));

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        TableCreate.createTable();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        doctorCardService = new DoctorCardServicePostgres();
        super.init(config);
    }
}
