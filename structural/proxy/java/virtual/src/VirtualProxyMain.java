package virtual.src;

public class VirtualProxyMain {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display(); // loaded first time
        System.out.println("---");
        image.display(); // cached, no re-loading
    }
}
