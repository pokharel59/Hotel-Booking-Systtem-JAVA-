package CustomerGUI;

public class UserInput {
    private static  String email;
    private static  String customerEmail;
    private static String selectedRoomType;

    public static void setEmail(String email){
        UserInput.email = email;
    }
    public static String getEmail(){
        return email;
    }
    public static void setRoomType(String selectedRoomType){
        UserInput.selectedRoomType = selectedRoomType;
    }
    public static String getRoomType(){
        return selectedRoomType;
    }

}
