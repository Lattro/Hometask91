import java.util.List;

public class Phone
{
    private int id;
    private int userId;
    private String phoneNumber;
    public Phone(int id, int userId, String phoneNumber) {
        this.id = id;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
    }
    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
