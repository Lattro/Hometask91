import java.util.List;

public interface PhoneDAO
{
    Phone findEntityId(int id);
    List<Phone> findAll();
    boolean delete(int id);
    boolean delete(Phone phone);
    boolean create (Phone phone);
    Phone update(Phone phone);
}
