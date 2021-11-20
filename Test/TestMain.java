public class TestMain
{
    public static void main(String[] args)
    {
        IBridge real_bridge = new RealBridge();
        IBridge proxy_bridge = new ProxyBridge(real_bridge);
        //ShowsSystemTest tests = new ShowsSystemTest(proxy_bridge);
        //tests.setBridge(proxy_bridge);
    }
}
