package view;

public enum EEOperation {
    CREATE("<html>" +
            "<head>" +
            "<meta charset='utf-8'>" +
            "<title>Тег FORM</title>" +
            "</head>" +
            "<body>" +
            "<form action = 'doctorCard' method='post'>" +
            "<fieldset>" +
            "<legend>Create a new doctor card</legend>" +
            "<p>" +
            "<label for='size_1'>Card number: </label>" +
            "<input type='text' name='id' id='size_1'/>" +
            "</p>" +
            "<p>" +
            "<label for='size_2'>Full name of the doctor: </label>" +
            "<input type='text' name='name' id='size_2'/>" +
            "</p>" +
            "<p>" +
            "<label for='size_3'>Date of birth of the doctor: </label>" +
            "<input type='text' name='dateOfBirth' id='size_3'/>" +
            "</p>" +
            "<p>" +
            "<label for='size_4'>Doctor's specialty: </label>" +
            "<input type='text' name='specialization' id='size_4'/>" +
            "</p>" +
            "<p>" +
            "<label for='size_5'>Work experience: </label>" +
            "<input type='text' name='workExperience' id='size_5'/>" +
            "</p>" +
            "<p>" +
            "<input type='submit'/>" +
            "</p>" +
            "</fieldset>" +
            "</form>" +
            "</body>" +
            "</html>"),
    UPDATE("<html>" +
            "<head>" +
            "<meta charset='utf-8'>" +
            "<title>Тег FORM</title>" +
            "</head>" +
            "<body>" +
            "<form action = 'doctorCard' method='put'>" +
            "<fieldset>" +
            "<legend>Update doctor card</legend>" +
            "<p>" +
            "<label for='size_1'>Card number: </label>" +
            "<input type='text' name='id' id='size_1'/>" +
            "</p>" +
            "<p>" +
            "<label for='size_2'>Full name of the doctor: </label>" +
            "<input type='text' name='name' id='size_2'/>" +
            "</p>" +
            "<p>" +
            "<label for='size_3'>Date of birth of the doctor: </label>" +
            "<input type='text' name='dateOfBirth' id='size_3'/>" +
            "</p>" +
            "<p>" +
            "<label for='size_4'>Doctor's specialty: </label>" +
            "<input type='text' name='specialization' id='size_4'/>" +
            "</p>" +
            "<p>" +
            "<label for='size_5'>Work experience: </label>" +
            "<input type='text' name='workExperience' id='size_5'/>" +
            "</p>" +
            "<p>" +
            "<input type='submit'/>" +
            "</p>" +
            "</fieldset>" +
            "</form>" +
            "</body>" +
            "</html>"),
    DELETE("<html>" +
            "<head>" +
            "<meta charset='utf-8'>" +
            "<title>Тег FORM</title>" +
            "</head>" +
            "<body>" +
            "<form action = 'doctorCard' method='delete'>" +
            "<fieldset>" +
            "<legend>Delete doctor card</legend>" +
            "<p>" +
            "<label for='size_1'>Card number: </label>" +
            "<input type='text' name='id' id='size_1'/>" +
            "</p>" +
            "<p>" +
            "<input type='submit'/>" +
            "</p>" +
            "</fieldset>" +
            "</form>" +
            "</body>" +
            "</html>"),

    GET_BY_ID("<html>" +
            "<head>" +
            "<meta charset='utf-8'>" +
            "<title>Тег FORM</title>" +
            "</head>" +
            "<body>" +
            "<form action = 'doctorCard' method='get'>" +
            "<fieldset>" +
            "<legend>Find the doctor's card by number: </legend>" +
            "<p>" +
            "<label for='size_1'>Card number</label>" +
            "<input type='text' name='id' id='size_1'/>" +
            "</p>" +
            "<p>" +
            "<input type='submit'/>" +
            "</p>" +
            "</fieldset>" +
            "</form>" +
            "</body>" +
            "</html>"),

    GET_ALL("<html>" +
            "<head>" +
            "<meta charset='utf-8'>" +
            "<title>Тег FORM</title>" +
            "</head>" +
            "<body>" +
            "<form action = 'allDoctorCard' method='get'>" +
            "<fieldset>" +
            "<legend>View all the doctor's cards</legend>" +
            "<p>" +
            "<input type='submit'/>" +
            "</p>" +
            "</fieldset>" +
            "</form>" +
            "</body>" +
            "</html>"),


    LINK_GET_ALL("<html>" +
            "<head>" +
            "<meta charset='utf-8'>" +
            "<title>Тег FORM</title>" +
            "</head>" +
            "<body>" +
            "<fieldset>" +
            "<legend>Get all the doctors' cards</legend>" +
            "<p>" +
            "<a href = allDoctorCard>Get all the doctors' cards</a>" +
            "</p>" +
            "</fieldset>" +
            "</form>" +
            "</body>" +
            "</html>");


    private String value;

    EEOperation(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}
