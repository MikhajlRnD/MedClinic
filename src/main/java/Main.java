import configuration.TableCreate;
import service.Console;
import service.ConsoleDoctorCard;

public class Main {
    public static void main(String[] args) {
        TableCreate.createTable();
        Console console = new ConsoleDoctorCard();
        console.console();


    }
}


