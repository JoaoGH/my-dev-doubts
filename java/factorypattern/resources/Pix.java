package factorypattern.resources;

public class Pix implements PaymentProcessor {
    public void process() {
        System.out.println("PIX");
    }
}
