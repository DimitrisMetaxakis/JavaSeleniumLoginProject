package common.enums;

public enum MessageTexts {
    Already_LoggedIn_Message("You are already logged in. View your profile."),
    Invalid_Login_Message("Invalid username or password!"),
    Message_To_Log_In("Login in Book Store");

    private final String myOption;

    MessageTexts(String option) { myOption = option;}


    public String getMessageText() {
        return myOption;
    }


}
