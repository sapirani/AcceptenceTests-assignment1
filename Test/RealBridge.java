import java.util.Date;

public class RealBridge implements IBridge
{
    @Override
    public boolean addUserToSystem(String username, String password, String phone_number, boolean isAdminUser)
    {
        throw new  UnsupportedOperationException();
    }

    @Override
    public boolean addShowWithoutTime(String show_name, String description, String venue, Date date, int ticket_price, Date last_day_to_purchase, String username)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int showFound(String description, Date date, String venue)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean orderChairToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date, int[] chairs_to_order)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean updateDateOfShow(String show_name, Date new_date, String username)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean cancleOrderOfChairsToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeShow(String show_name, Date show_date, String username)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteUserFromSystem(String username, String password)
    {
        throw new UnsupportedOperationException();
    }
}
