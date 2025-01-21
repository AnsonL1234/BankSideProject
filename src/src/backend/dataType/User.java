package src.backend.dataType;
import java.util.Random;

public class User {

    private String userIDGenerator() {
        String ID_Letter = "SKD";
        int ID_Number = 100000;
        ID_Number =+ 1;
        String userID = ID_Letter + String.valueOf(ID_Number);

        return userID;
    }
}
