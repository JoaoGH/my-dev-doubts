package factorypattern.factory;

import factorypattern.resources.PaymentProcessor;
import factorypattern.resources.PaymentType;

public class EnumFactory {
	private EnumFactory() {
	}

	public static PaymentProcessor create(PaymentType type) {
		return type.create();
	}
}
