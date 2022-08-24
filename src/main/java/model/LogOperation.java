package model;


public enum LogOperation {
    CREATE("Создана новая карточка"),
    UPDATE("Обновлена карточка"),
    DELETE("Удалена карточка");

    private String value;

    LogOperation(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}
