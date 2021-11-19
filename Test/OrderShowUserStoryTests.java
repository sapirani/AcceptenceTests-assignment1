import org.junit.Assert;

import java.util.Date;

public class OrderShowUserStoryTests extends ShowsSystemTests
{
    // ** Search show ** //

    public void searchShowHappy()
    {
        /** Happy case **/
        try
        {
            String description = "Love story";
            String venue = "#1";
            Date date = new Date(2022,12,20);
            int foundShow = bridge.showFound(description, date, venue);
            Assert.assertTrue(foundShow > 0);
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    public void searchShowSad()
    {
        /** Sad case **/
        try
        {
            String description = "Love story";
            String venue = "#1";
            Date sad_date = new Date(1022, 12, 10);
            int foundShow = bridge.showFound(description, sad_date, venue);
            Assert.assertTrue(foundShow <= 0); // The date of the show doesnt match the existing show
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    public void searchShowBad()
    {
        /** Bad case **/
        try
        {
            String bad_description = "@#***";
            String bad_venue = "-*-*-++&&";
            Date date = new Date(2022,12,20);
            int foundShow = bridge.showFound(bad_description, date, bad_venue);
            Assert.assertTrue(foundShow <= 0); // Illegal description and venue,
            // None of the shows in the system match those details.
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    // ** Ordar chairs to the show ** //

    public void orderChairsToShowHappy()
    {
        try
        {
            String usernameOfOrder = "Sapir";
            String phone_number = "0547863125";
            String show_name = "First show";
            Date show_date = new Date(2022,12,20);
            int[] chairs_to_order = {1,2,3};

            boolean success = bridge.orderChairToShow(usernameOfOrder, phone_number,show_name, show_date, chairs_to_order);
            Assert.assertTrue(success);
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    public void orderChairsToShowSad()
    {
        try
        {
            String usernameOfOrder = "Yossi";
            String sad_phone_number = "0547863125";
            String show_name = "First show";
            Date show_date = new Date(2022,12,20);
            int[] chairs_to_order = {4,5,6};

            boolean success = bridge.orderChairToShow(usernameOfOrder, sad_phone_number, show_name, show_date, chairs_to_order);
            Assert.assertTrue(success); // The order succeded but yossi entered wrong phone number,
            // so he would'nt receive the success message and to pay on his tickets.
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    public void orderChairsToShowBad()
    {
        try
        {
            String usernameOfOrder = "Sagi Brudni";
            String bad_phone_number = "$#%&&@$$";
            String show_name = "Second show";
            Date show_date = new Date(2021,12,10);
            int[] bad_chairs_to_order = {1,2,3};

            boolean success = bridge.orderChairToShow(usernameOfOrder, bad_phone_number, show_name, show_date, bad_chairs_to_order);
            Assert.assertFalse(success); // The phone number is illegal, and the sits are alredy taken.
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    // ** Cancel order of chairs to the show ** //

    public void cancleOrderOfChairsToShowHappy()
    {
        /** Happy case **/
        try
        {
            String usernameOfOrder = "Sapir";
            String phone_number = "0547863125";
            String show_name = "First show";
            Date show_date = new Date(2022,12,20);

            boolean success = bridge.cancleOrderOfChairsToShow(usernameOfOrder, phone_number, show_name, show_date);
            Assert.assertTrue(success);
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    public void cancleOrderOfChairsToShowSad()
    {
        /** Sad case **/
        try
        {
            String usernameOfOrder = "Sapir";
            String phone_number = "0547863125";
            String show_name = "Star show";
            Date sad_show_date = new Date(2021,1,12);

            boolean success = bridge.cancleOrderOfChairsToShow(usernameOfOrder, phone_number, show_name, sad_show_date);
            Assert.assertFalse(success); // The order of chairs was to a show in other date
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

    public void cancleOrderOfChairsToShowBad()
    {
        /** Bad case **/
        try
        {
            String usernameOfOrder = "Sapir";
            String phone_number = "0547863125";
            String bad_show_name = "Second show";
            Date bad_show_date = new Date(2022,12,10);

            boolean success = bridge.cancleOrderOfChairsToShow(usernameOfOrder, phone_number, bad_show_name, bad_show_date);
            Assert.assertFalse(success); // The order of chairs was to a different show in other date
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }
}
