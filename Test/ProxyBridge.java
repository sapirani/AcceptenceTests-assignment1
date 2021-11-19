import java.util.Date;

public class ProxyBridge implements IBridge
{
    public IBridge bridge;

    public ProxyBridge(IBridge bridge)
    {
        this.bridge = bridge; // just for now
    }

    @Override
    public boolean addUserToSystem(String username, String password, String phone_number, boolean isAdminUser)
    {
        if (bridge != null)
            bridge.addUserToSystem(username, password, phone_number, isAdminUser);
        return false;
    }

    @Override
    public boolean addShowWithoutTime(String show_name, String description, String venue, Date date, int ticket_price, Date last_day_to_purchase, String username)
    {
        if(bridge != null)
            bridge.addShowWithoutTime(show_name, description, venue, date, ticket_price, last_day_to_purchase, username);
        return true;
    }

    @Override
    public int showFound(String description, Date date, String venue)
    {
        if(bridge != null)
            bridge.showFound(description, date, venue);
        return 0;
    }

    @Override
    public boolean orderChairToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date, int[] chairs_to_order)
    {
        if(bridge != null)
            bridge.orderChairToShow(usernameOfOrder, phone_number, show_name, show_date, chairs_to_order);
        return false;
    }

    @Override
    public boolean updateDateOfShow(String show_name, Date new_date, String username)
    {
        if(bridge != null)
            bridge.updateDateOfShow(show_name, new_date, username);
        return false;
    }

    @Override
    public boolean cancleOrderOfChairsToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date)
    {
        if(bridge != null)
            bridge.cancleOrderOfChairsToShow(usernameOfOrder, phone_number, show_name, show_date);
        return false;
    }

    @Override
    public boolean removeShow(String show_name, Date show_date, String username)
    {
        if(bridge != null)
            bridge.removeShow(show_name, show_date, username);
        return false;
    }

    @Override
    public boolean deleteUserFromSystem(String username, String password) {
        if(bridge != null)
            bridge.deleteUserFromSystem(username, password);
        return false;
    }
}
