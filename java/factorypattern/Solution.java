package factorypattern;


import factorypattern.factory.GenericFactory;
import factorypattern.factory.MapSupplier;
import factorypattern.resources.Boleto;
import factorypattern.resources.Cartao;
import factorypattern.resources.PaymentProcessor;
import factorypattern.resources.Pix;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Factories");

		System.out.println("\n- Map Supplier");
		demoMapSupplier();

		System.out.println("\n- Generic");
		demoGenericFactory();
	}

	private static void demoMapSupplier() {
		PaymentProcessor p1 = MapSupplier.create("pix");
		PaymentProcessor p2 = MapSupplier.create("boleto");
		PaymentProcessor p3 = MapSupplier.create("cartao");

		p1.process();
		p2.process();
		p3.process();
	}

	private static void demoGenericFactory() {
		GenericFactory factory = new GenericFactory();

		factory.register(Pix.class, Pix::new);
		factory.register(Boleto.class, Boleto::new);
		factory.register(Cartao.class, Cartao::new);

		PaymentProcessor g1 = factory.create(Pix.class);
		PaymentProcessor g2 = factory.create(Boleto.class);
		PaymentProcessor g3 = factory.create(Cartao.class);

		g1.process();
		g2.process();
		g3.process();
	}

}