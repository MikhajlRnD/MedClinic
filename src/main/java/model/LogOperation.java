package model;


public enum LogOperation {
    CREATE("������� ����� ��������"),
    UPDATE("��������� ��������"),
    DELETE("������� ��������");

    private String value;

    LogOperation(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}
