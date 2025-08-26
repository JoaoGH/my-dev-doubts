package factorypattern;


import factorypattern.factory.*;
import factorypattern.resources.*;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Factories");

		System.out.println("\n- Map Supplier");
		demoMapSupplier();

		System.out.println("\n- Generic");
		demoGenericFactory();

		System.out.println("\n- ServiceLoader Factory");
		demoServiceLoaderFactory();

		System.out.println("\n- ReflectionFactory");
		demoReflectionFactory();

		System.out.println("\n- EnumFactory");
		demoEnumFactory();
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

	private static void demoServiceLoaderFactory() {
		ServiceLoaderFactory slf = new ServiceLoaderFactory();
		PaymentProcessor p1 = slf.create("pix");
		PaymentProcessor p2 = slf.create("boleto");
		PaymentProcessor p3 = slf.create("cartao");

		p1.process();
		p2.process();
		p3.process();
	}

	private static void demoReflectionFactory() {
		PaymentProcessor paymentProcessor1 = ReflectionFactory.create("pix");
		PaymentProcessor paymentProcessor2 = ReflectionFactory.create("boleto");
		PaymentProcessor paymentProcessor3 = ReflectionFactory.create("cartao");

		paymentProcessor1.process();
		paymentProcessor2.process();
		paymentProcessor3.process();
	}

	private static void demoEnumFactory() {
		PaymentProcessor p1 = EnumFactory.create(PaymentType.PIX);
		PaymentProcessor p2 = EnumFactory.create(PaymentType.BOLETO);
		PaymentProcessor p3 = EnumFactory.create(PaymentType.CARTAO);

		p1.process();
		p2.process();
		p3.process();
	}

}