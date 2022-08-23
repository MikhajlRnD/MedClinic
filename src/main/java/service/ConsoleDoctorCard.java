package service;

import model.DoctorCard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleDoctorCard implements Console{
    private final String HELLO = "Приветствуем Вас в сервисе базы данных докторов!!!";
    private final String SELECT_ACTION = "Пожалуйста выберите действие:";
    private final String CREATE_QUERY = "Чтобы добавить карточку нового врача введите 1";
    private final  String UPDATE_QUERY = "Чтобы отредактировать существующюю карточку врача введите 2";
    private final String DELETE_QUERY = "Чтобы удалить карточку врача из базы данных введите 3";
    private final  String GET_BY_ID_QUERY = "Чтобы посмотреть карточку существующего врача введите 4";
    private  final  String GET_ALL_QUERY = "Чтобы посмотреть карточки всех врчай введите 5";
    private final String EXIT = "Чтобы выйти из приложения введите 6";
    private  final String ID = "Введите номер карточки доктора";
    private  final String NAME = "Введите ФИО Доктора";
    private  final String DATE_OF_BIRTH = "Введите дату рождения доктора";
    private  final String SPECIALIZATION = "Введите специальность доктора";
    private  final String WORK_EXPERIENCE = "Введите опыт работы доктора";

    @Override
    public void console() {
        Scanner scanner = new Scanner(System.in);
        DoctorCardService doctorCardService = new DoctorCardServicePostgres();

        while (true){

            System.out.println(HELLO + "\n" + SELECT_ACTION + "\n" + CREATE_QUERY + "\n"
                            + UPDATE_QUERY + "\n" + DELETE_QUERY + "\n"
                            + GET_BY_ID_QUERY + "\n" + GET_ALL_QUERY + "\n" + EXIT);

            Integer choice = scanner.nextInt();
            if (choice.intValue() == 1) {
                DoctorCard doctorCard = new DoctorCard();
                System.out.println(ID);
                doctorCard.setId(scanner.nextLong());
                System.out.println(NAME);
                doctorCard.setName(scanner.nextLine());
                System.out.println(DATE_OF_BIRTH);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                doctorCard.setDateOfBirth(LocalDate.parse(scanner.nextLine(), dtf));
                System.out.println(SPECIALIZATION);
                doctorCard.setSpecialization(scanner.nextLine());
                System.out.println(WORK_EXPERIENCE);;
                doctorCard.setWorkExperience(scanner.nextInt());
                doctorCard.setLastUpdatedDate(LocalDateTime.now());





            }
        }

    }
}
