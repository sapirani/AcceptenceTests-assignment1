import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class OrderShowUserStoryTest extends ShowsSystemTest
{
    @Test
    public void searchShowHappy()
    {
        /** Happy case **/
        try
        {
            String description = "show with a lot of superstars";
            String venue = "#5";
            Date date = new Date(2021,12,1);
            int showIndex = bridge.getShowIndex(description, date, venue);
            Assert.assertTrue(showIndex >= 0);
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void searchShowSad()
    {
        /** Sad case **/
        try
        {
            String description = "show with a lot of superstars";
            String venue = "#5";
            Date sad_date = new Date(1022, 12, 10);
            int showIndex = bridge.getShowIndex(description, sad_date, venue);
            Assert.assertTrue(showIndex < 0); // The date of the show doesnt match the existing show
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void searchShowBad()
    {
        /** Bad case **/
        try
        {
            String bad_description = "@#***";
            String bad_venue = "-*-*-++&&";
            Date date = new Date(1000,12,20);
            int showIndex = bridge.getShowIndex(bad_description, date, bad_venue);
            Assert.assertTrue(showIndex < 0); // Illegal description, venue and date,
                                                        // None of the shows in the system match those details.
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void orderChairsToShowHappy()
    {
        /** Happy case **/

        try
        {
            String usernameOfOrder = "Yossi";
            String phone_number = "0527863125";
            String show_name = "Star show";
            Date show_date = new Date(2021,12,1);
            int[] chairs_to_order = {1,2,3};

            boolean success = bridge.orderChairToShow(usernameOfOrder, phone_number,show_name, show_date, chairs_to_order);
            Assert.assertTrue(success);
            bridge.cancelOrderOfChairsToShow(usernameOfOrder, phone_number,show_name,show_date); // cancel changes
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void orderChairsToShowSad()
    {
        /** Sad case **/

        try
        {
            String usernameOfOrder = "Yossi";
            String sad_phone_number = "0547863125";
            String show_name = "Star show";
            Date show_date = new Date(2021,12,1);
            int[] chairs_to_order = {9,10};

            boolean success = bridge.orderChairToShow(usernameOfOrder, sad_phone_number, show_name, show_date, chairs_to_order);
            Assert.assertTrue(success); // The order succeded but yossi entered wrong phone number,
                                        // so he would'nt receive the success message and to pay on his tickets.
            bridge.cancelOrderOfChairsToShow(usernameOfOrder, sad_phone_number, show_name, show_date); // cancel changes
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void orderChairsToShowBad()
    {
        /** Bad case **/

        try
        {
            String usernameOfOrder = "Sagi Brudni";
            String bad_phone_number = "$#%&&@$$";
            String show_name = "Star show";
            Date show_date = new Date(2021,12,1);
            int[] bad_chairs_to_order = {5,6};

            boolean success = bridge.orderChairToShow(usernameOfOrder, bad_phone_number, show_name, show_date, bad_chairs_to_order);
            Assert.assertFalse(success); // The phone number is illegal, and the sits are alredy taken.
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void cancelOrderOfChairsToShowHappy()
    {
        /** Happy case **/
        try
        {
            String usernameOfOrder = "Sapir";
            String phone_number = "0547863125";
            String show_name = "Star show";
            Date show_date = new Date(2021,12,1);

            boolean success = bridge.cancelOrderOfChairsToShow(usernameOfOrder, phone_number, show_name, show_date);
            Assert.assertTrue(success);
            int[] chairs_to_order = {5,6,7}; // cancel changes
            bridge.orderChairToShow(usernameOfOrder,phone_number,show_name,show_date, chairs_to_order);
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void cancelOrderOfChairsToShowSad()
    {
        /** Sad case **/
        try
        {
            String usernameOfOrder = "Sapir";
            String phone_number = "0547863125";
            String show_name = "Star show";
            Date sad_show_date = new Date(2021,1,12);

            boolean success = bridge.cancelOrderOfChairsToShow(usernameOfOrder, phone_number, show_name, sad_show_date);
            Assert.assertFalse(success); // The order of chairs was to a show in other date
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void cancelOrderOfChairsToShowBad()
    {
        /** Bad case **/
        try
        {
            String usernameOfOrder = "Sapir";
            String phone_number = "#$#%^%$#&";
            String bad_show_name = "Second show";
            Date bad_show_date = new Date(2022,12,10);

            boolean success = bridge.cancelOrderOfChairsToShow(usernameOfOrder, phone_number, bad_show_name, bad_show_date);
            Assert.assertFalse(success); // The order of chairs was to a different show in other date,
                                        // phone number is illigal
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }
}