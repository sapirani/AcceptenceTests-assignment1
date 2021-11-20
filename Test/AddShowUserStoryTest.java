import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AddShowUserStoryTest extends ShowsSystemTest
{
    @Override
    @Before
    public void setUp() throws Exception
    {
        super.setUp();
    }

    @Test
    public void addShowWithoutTimeHappy()
    {
        /** Happy case **/
        try
        {
            String show_name = "First show";
            String description = "Love story";
            String venue = "#1";
            Date date = new Date(2022,12,10);
            float ticket_price = 20;
            Date last_day_to_purchase = new Date(2022,12,1);
            String admin_username = "Sagi Brudni";
            boolean success = bridge.addShowWithoutTime(show_name,
                    description, venue, date, ticket_price, last_day_to_purchase, admin_username);
            Assert.assertTrue(success);
            bridge.removeShow(show_name, date, admin_username); // cancel changes
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void addShowWithoutTimeSad()
    {
        /** Sad case **/
        try
        {
            String show_name = "Second show";
            String description = "Comedy";
            String venue = "#1";
            Date sad_date = new Date(1022,12,10);
            float ticket_price = 30;
            Date last_day_to_purchase = new Date(2022,12,1);
            String admin_username = "Sagi Brudni";
            boolean success = bridge.addShowWithoutTime(show_name,
                    description, venue, sad_date, ticket_price, last_day_to_purchase, admin_username);
            Assert.assertFalse(success); // Illegal date of show - should not add new show to the system
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void addShowWithoutTimeBad()
    {
        /** Bad case **/
        try
        {
            String show_name = "Third show";
            String description = "Musical show";
            String venue = "#2";
            Date date = new Date(2022,11,18);
            float bad_ticket_price = -200; // TODO: change to special characters
            Date last_day_to_purchase = new Date(2022,11,10);
            String admin_username = "Sagi Brudni";
            boolean success = bridge.addShowWithoutTime(show_name,
                    description, venue, date, bad_ticket_price, last_day_to_purchase, admin_username);
            Assert.assertFalse(success); // Illegal price for ticket show - should not add new show to the system
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void updateShowDateHappy()
    {
        /** Happy case **/
        try
        {
            String show_name = "Star show";
            Date new_date = new Date(2022,12,20);
            String admin_username = "Sagi Brudni";
            boolean success = bridge.updateDateOfShow(show_name, new_date, admin_username);
            Assert.assertTrue(success);
            Date old_date = new Date(2021,12,1);
            bridge.updateDateOfShow(show_name, old_date, admin_username); // cancel changes
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void updateShowDateSad()
    {
        /** Sad case **/
        try
        {
            String sad_show_name = "Start show";
            Date new_date = new Date(2022,12,20);
            String admin_username = "Sagi Brudni";
            boolean success = bridge.updateDateOfShow(sad_show_name, new_date, admin_username);
            Assert.assertFalse(success); // The show name and date doesn't match one of the shows in the system
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void updateShowDateBad()
    {
        /** Bad case **/
        try
        {
            String bad_show_name = "$%^Star @#show*&";
            Date bad_new_date = new Date(1022,12,20);
            String admin_username = "Sagi Brudni";
            boolean success = bridge.updateDateOfShow(bad_show_name, bad_new_date, admin_username);
            Assert.assertFalse(success); // The show name doesn't match one of the shows in the system
                                        // and the new date already past.
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }
}