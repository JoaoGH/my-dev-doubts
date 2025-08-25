package factorypattern.resources;

public class Cartao implements PaymentProcessor {
	public void process() {
		System.out.println("CARTAO");
	}
}
