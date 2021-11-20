import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

public class RealBridge implements IBridge
{
    @Override
    public boolean addUserToSystem(String username, String password, String phone_number, boolean isAdminUser)
    {
        throw new NotImplementedException();
    }

    @Override
    public boolean addShowWithoutTime(String show_name, String description, String venue, Date date, float ticket_price, Date last_day_to_purchase, String username)
    {
        throw new NotImplementedException();
    }

    @Override
    public int getShowIndex(String description, Date date, String venue)
    {
        throw new NotImplementedException();
    }

    @Override
    public boolean orderChairToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date, int[] chairs_to_order)
    {
        throw new NotImplementedException();
    }

    @Override
    public boolean updateDateOfShow(String show_name, Date new_date, String username)
    {
        throw new NotImplementedException();
    }

    @Override
    public boolean cancelOrderOfChairsToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date)
    {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeShow(String show_name, Date show_date, String username)
    {
        throw new NotImplementedException();
    }

    @Override
    public boolean deleteUserFromSystem(String username, String password)
    {
        throw new NotImplementedException();
    }
}
