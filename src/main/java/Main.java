import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        PhoneDAO phoneDAO = new PhoneDAOImpl();

        //UPDATE()
        Phone phone4 = phoneDAO.update(new Phone(4,4,"0000000000"));
        System.out.println("id - "+phone4.getId()+" user_id - "+phone4.getUserId()+" phone_number - "+phone4.getPhoneNumber());
        System.out.println();

        //DELETE()
        if( phoneDAO.delete(new Phone(7,4,"555555"))==true)
        {
            System.out.println("Запись успешно удалена");
        }
        else
        {
            System.out.println("Ошибка удаления записи");
        }

        //DELETE()
        phoneDAO.delete(1);
        if(phoneDAO.delete(1)==true)
        {
            System.out.println("Запись успешно удалена");
        }
        else
        {
            System.out.println("Ошибка удаления записи");
        }

        //CREATE()
        Phone phone1 = new Phone(12,4,"555555");
        phoneDAO.create(phone1);

        //FINDALL()
        List<Phone> phones = new ArrayList<>();
        phones.addAll(phoneDAO.findAll());
        for (Phone i: phones)
        {
            System.out.print("id - "+i.getId()+" ");
            System.out.print("user_id - "+i.getUserId()+" ");
            System.out.print("phone_number - "+i.getPhoneNumber()+" ");
            System.out.println();
        }

        //FINDIDENTITYID()
        Phone phone = phoneDAO.findEntityId(4);
        System.out.println("id - "+ phone.getId()+" user_id - "+ phone.getUserId()+" phone_number - "+phone.getPhoneNumber());
    }
}
