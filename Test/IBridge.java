import java.util.Date;

public interface IBridge
{
    boolean addUserToSystem(String username, String password, String phone_number, boolean isAdminUser);
    boolean addShowWithoutTime(String show_name, String description, String venue, Date date, int ticket_price, Date last_day_to_purchase, String username);
    int showFound(String description, Date date, String venue);
    boolean orderChairToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date, int[] chairs_to_order);
    boolean updateDateOfShow(String show_name, Date new_date, String username);
    boolean cancleOrderOfChairsToShow(String usernameOfOrder, String phone_number, String show_name, Date show_date);
    boolean removeShow(String show_name, Date show_date, String username);
    boolean deleteUserFromSystem(String username, String password);
}

