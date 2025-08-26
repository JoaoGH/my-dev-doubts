package factorypattern.resources.provider;

import factorypattern.resources.PaymentProcessor;

public interface PaymentProcessorProvider {
	String key();
	PaymentProcessor create();
}
