package incorrectServlet;

import configuration.TableCreate;
import view.EEOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")

public class ServletMed extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(EEOperation.CREATE.getValue());
        resp.getWriter().write(EEOperation.UPDATE.getValue());
        resp.getWriter().write(EEOperation.DELETE.getValue());
        resp.getWriter().write(EEOperation.GET_BY_ID.getValue());
        resp.getWriter().write(EEOperation.LINK_GET_ALL.getValue());
    }

    @Override
    public void init() throws ServletException {
        TableCreate.createTable();
        super.init();
    }
}
