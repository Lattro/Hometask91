import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl implements PhoneDAO
{
    @Override
    public Phone findEntityId(int id)
    {
        Phone phone = null;
        String sqlString = "select * from phones where id ="+id;
        try
        {
            var db = Connect.getConnection();
            Statement statement = db.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString);
            while(resultSet.next()) {
                phone = new Phone(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("phone_number"));
            }
            db.close();
            return phone;
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Phone> findAll()
    {
        String sqlString="select * from phones";
        Connection db = null;
        List<Phone> phones = new ArrayList<>();
        try
        {
            db = Connect.getConnection();
            Statement statement = db.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next())
            {
                phones.add(new Phone(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("phone_number")));
            }
            db.close();
            return phones;
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id)
    {
        boolean check= false;
        try
        {
            String sqlQuery = "delete from phones where id = "+id;
            var db = Connect.getConnection();
            Statement statement = db.createStatement();
            statement.executeUpdate(sqlQuery);
            check = true;
            db.close();

        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return check;
    }

    @Override
    public boolean delete(Phone phone)
    {
        boolean check = false;
        try
        {
            String sqlString ="delete from phones where id="+phone.getId();
            var db = Connect.getConnection();
            Statement statement = db.createStatement();
            statement.executeUpdate(sqlString);
            check = true;
            db.close();

        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return  check;
    }

    @Override
    public boolean create(Phone phone)
    {
        try
        {
            String sqlQuery = "insert into phones(user_id,phone_number) values " +
                    "("+phone.getUserId()+","+phone.getPhoneNumber()+")";
            var db = Connect.getConnection();
            Statement statement = db.createStatement();
            statement.executeUpdate(sqlQuery);
            db.close();
            return true;
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Phone update(Phone phone)
    {
        try
        {
            String sqlString ="update phones set phone_number='"+phone.getPhoneNumber()+"' where id ="+phone.getId();
            var db = Connect.getConnection();
            Statement statement = db.createStatement();
            db.close();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return phone;
    }
}
