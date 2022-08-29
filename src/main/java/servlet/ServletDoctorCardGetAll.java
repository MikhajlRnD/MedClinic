package servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import configuration.TableCreate;
import service.DoctorCardService;
import service.DoctorCardServicePostgres;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/card/doctor/getAll")

public class ServletDoctorCardGetAll extends HttpServlet {
    private ObjectMapper objectMapper;
    private DoctorCardService doctorCardService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(objectMapper.writeValueAsString(doctorCardService.getAll()));

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
