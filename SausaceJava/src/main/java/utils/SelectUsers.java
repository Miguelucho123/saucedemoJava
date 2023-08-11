package utils;

public class SelectUsers {

    public static final String PASSWORD = "secret_sauce";

    public static String returnCorrectUserName(String user){
        if(user.equals("standard user")){
            return "standard_user";
        }
        return "locked_out_user";
    }
}
