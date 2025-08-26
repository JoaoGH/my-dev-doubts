package factorypattern.resources;

public class Boleto implements PaymentProcessor {
    public void process() {
        System.out.println("BOLETO");
    }
}
