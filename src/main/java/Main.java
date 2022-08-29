import configuration.TableCreate;
import lombok.SneakyThrows;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        //TableCreate.createTable();
        /*Console console = new ConsoleDoctorCard();
        console.console();*/

        InitialContext cxt = new InitialContext();
        if (cxt == null) {
            throw new Exception("Uh oh -- no context!");
        }

        DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/postgres");

        if (ds == null) {
            throw new Exception("Data source not found!");
        }
    }
}


