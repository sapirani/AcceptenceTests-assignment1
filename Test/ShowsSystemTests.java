import java.util.Date;

public class ShowsSystemTests {
    protected IBridge bridge;

    @org.junit.Before
    public void setUp() throws Exception
    {
        // Add users
        bridge.addUserToSystem("Sagi Brudni", "1234", "0546783125", true);
        bridge.addUserToSystem("Sapir", "abc1", "0547863125", false);
        bridge.addUserToSystem("Yossi", "yos", "0527863125", false);

        // Add show
        bridge.addShowWithoutTime("Star show", "show with a lot of superstars",
                "#5", new Date(2021, 12, 1), 10,
                new Date(2021, 11, 10), "Sagi Brudni");

        // Order sits
        int[] sits = {5, 6, 7};
        bridge.orderChairToShow("Sapir", "0547863125",
                "Star show", new Date(2021, 12, 1), sits);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        bridge.cancleOrderOfChairsToShow("Yossi", "0547863125", "First show", new Date(2022, 12, 20));
        bridge.cancleOrderOfChairsToShow("Sapir", "0547863125", "Star show", new Date(2021, 12, 1));

        bridge.removeShow("Star show", new Date(2021, 12, 1), "Sagi Brudni");
        bridge.removeShow("First show", new Date(2022, 12, 20), "Sagi Brudni");

        bridge.deleteUserFromSystem("Yossi", "yos");
        bridge.deleteUserFromSystem("Sapir", "abc1");
        bridge.deleteUserFromSystem("Sagi Brudni", "1234");
    }

    public void setBridge(IBridge bridge)
    {
        this.bridge = bridge;
    }
}
