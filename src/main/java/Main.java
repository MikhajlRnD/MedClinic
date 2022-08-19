import configuration.ConnectionPG;
import model.DoctorCard;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Connection connect = ConnectionPG.connect();
        System.out.println(connect);
        System.out.println(DoctorCard.builder().build());

    }
}
