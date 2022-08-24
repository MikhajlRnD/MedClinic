package service;

import model.DoctorCard;
import model.LogOperation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleDoctorCard implements Console {
    private final String HELLO = "������������ ��� � ������� ���� ������ ��������!!!";
    private final String SELECT_ACTION = "���������� �������� ��������:";
    private final String CREATE_QUERY = "����� �������� �������� ������ ����� ������� 1";
    private final String UPDATE_QUERY = "����� ��������������� ������������ �������� ����� ������� 2";
    private final String DELETE_QUERY = "����� ������� �������� ����� �� ���� ������ ������� 3";
    private final String GET_BY_ID_QUERY = "����� ���������� �������� ������������� ����� ������� 4";
    private final String GET_ALL_QUERY = "����� ���������� �������� ���� ����� ������� 5";
    private final String EXIT = "����� ����� �� ���������� ������� 6";
    private final String ID = "������� ����� �������� �������";
    private final String NAME = "������� ��� �������";
    private final String DATE_OF_BIRTH = "������� ���� �������� �������";
    private final String SPECIALIZATION = "������� ������������� �������";
    private final String WORK_EXPERIENCE = "������� ���� ������ �������";

    @Override
    public void console() {
        Scanner scanner = new Scanner(System.in);
        DoctorCardService doctorCardService = new DoctorCardServicePostgres();
        DoctorCard doctorCard = new DoctorCard();
        LogService log = new Log();

        while (true) {

            System.out.println(HELLO + "\n" + SELECT_ACTION + "\n" + CREATE_QUERY + "\n"
                    + UPDATE_QUERY + "\n" + DELETE_QUERY + "\n"
                    + GET_BY_ID_QUERY + "\n" + GET_ALL_QUERY + "\n" + EXIT);

            Integer choice = scanner.nextInt();
            if (choice.intValue() == 1) {
                System.out.println(ID);
                doctorCard.setId(scanner.nextLong());
                System.out.println(NAME);
                doctorCard.setName(scanner.next());
                System.out.println(DATE_OF_BIRTH);
                String date = scanner.next();
                doctorCard.setDateOfBirth(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                System.out.println(SPECIALIZATION);
                doctorCard.setSpecialization(scanner.next());
                System.out.println(WORK_EXPERIENCE);
                doctorCard.setWorkExperience(scanner.nextInt());
                doctorCard.setLastUpdatedDate(LocalDateTime.now());
                doctorCardService.create(doctorCard);
                log.log(LogOperation.CREATE, doctorCard);
            } else if (choice.intValue() == 2) {
                System.out.println(ID + " ������� ������ ��������");
                doctorCard.setId(scanner.nextLong());
                System.out.println(NAME);
                doctorCard.setName(scanner.next());
                System.out.println(DATE_OF_BIRTH);
                String date = scanner.next();
                doctorCard.setDateOfBirth(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                System.out.println(SPECIALIZATION);
                doctorCard.setSpecialization(scanner.next());
                System.out.println(WORK_EXPERIENCE);
                doctorCard.setWorkExperience(scanner.nextInt());
                doctorCard.setLastUpdatedDate(LocalDateTime.now());
                doctorCardService.update(doctorCard.getId(), doctorCard);
                log.log(LogOperation.UPDATE, doctorCard);
            } else if (choice.intValue() == 3) {
                System.out.println(ID + " ������� ������ �������");
                doctorCard.setId(scanner.nextLong());
                doctorCard = (DoctorCard) doctorCardService.getById(doctorCard.getId());
                doctorCardService.delete(doctorCard.getId());
                log.log(LogOperation.DELETE, doctorCard);
            } else if (choice.intValue() == 4) {
                System.out.println(ID + " ������� ������ ����������");
                doctorCard.setId(scanner.nextLong());
                System.out.println(doctorCardService.getById(doctorCard.getId()));
            } else if (choice.intValue() == 5) {
                System.out.println(doctorCardService.getAll());
            } else if (choice.intValue() == 6) {
                break;
            }
        }

    }
}
