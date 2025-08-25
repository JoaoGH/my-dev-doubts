package factorypattern;


import factorypattern.factory.MapSupplier;
import factorypattern.resources.PaymentProcessor;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Factories");

		System.out.println("- Map Supplier");
		demoMapSupplier();
	}

	private static void demoMapSupplier() {
		PaymentProcessor p1 = MapSupplier.create("pix");
		PaymentProcessor p2 = MapSupplier.create("boleto");
		PaymentProcessor p3 = MapSupplier.create("cartao");

		p1.process();
		p2.process();
		p3.process();
	}

}