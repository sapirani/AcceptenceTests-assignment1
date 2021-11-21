import java.util.Date;

public class ProxyBridge implements IBridge
{
    public IBridge bridge;

    public ProxyBridge(IBridge bridge)
    {
        this.bridge = bridge;
    }

    @Override
    public boolean addUserToSystem(String username, String password, String phone_number, boolean isAdminUser)
    {
        if (bridge == null)
            return false;
        return bridge.addUserToSystem(username, password, phone_number, isAdminUser);
    }

    @Override
    public boolean addShowWithoutTime(String show_name, String description, String venue, Date date, float ticket_price, Date last_day_to_purchase, String username)
    {
        if(bridge == null)
            return false;
        return bridge.addShowWithoutTime(show_name, description, venue, date, ticket_price, last_day_to_purchase, username);
    }

    @Override
    public int getShowIndex(String description, Date date, String venue)
    {
        if(bridge == null)
            return -1;
        return bridge.getShowIndex(description, date, venue);
    }

    @Override
    public boolean orderChairToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date, int[] chairs_to_order)
    {
        if(bridge == null)
            return false;
        return bridge.orderChairToShow(usernameOfOrder, phone_number, show_name, show_date, chairs_to_order);
    }

    @Override
    public boolean updateDateOfShow(String show_name, String venue, Date new_date, String username)
    {
        if(bridge == null)
            return false;
        return bridge.updateDateOfShow(show_name, venue, new_date, username);
    }

    @Override
    public boolean cancelOrderOfChairsToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date)
    {
        if(bridge == null)
            return false;
        return bridge.cancelOrderOfChairsToShow(usernameOfOrder, phone_number, show_name, show_date);
    }

    @Override
    public boolean removeShow(String show_name, Date show_date, String username)
    {
        if(bridge == null)
            return false;
        return bridge.removeShow(show_name, show_date, username);
    }

    @Override
    public boolean deleteUserFromSystem(String username, String password)
    {
        if(bridge == null)
            return false;
        return bridge.deleteUserFromSystem(username, password);
    }
}
