public class BridgeProvider
{
    public static IBridge getBridge()
    {
        IBridge real_bridge = null;
        IBridge proxy_bridge = new ProxyBridge(real_bridge);
        return proxy_bridge;
    }
}
