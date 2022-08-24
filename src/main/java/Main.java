import configuration.TableCreate;
import service.Console;
import service.ConsoleDoctorCard;
import service.Log;
import service.LogService;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        TableCreate.createTable();
        Console console = new ConsoleDoctorCard();
        console.console();



    }
}


