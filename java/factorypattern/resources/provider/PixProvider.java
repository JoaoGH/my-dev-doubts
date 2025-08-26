package factorypattern.resources.provider;

import factorypattern.resources.PaymentProcessor;
import factorypattern.resources.Pix;

public class PixProvider implements PaymentProcessorProvider {
	public String key() {
		return "pix";
	}

	public PaymentProcessor create() {
		return new Pix();
	}
}
