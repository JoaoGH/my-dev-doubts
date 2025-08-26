package factorypattern.resources.provider;

import factorypattern.resources.Boleto;
import factorypattern.resources.PaymentProcessor;

public class BoletoProvider implements PaymentProcessorProvider {
	public String key() {
		return "boleto";
	}

	public PaymentProcessor create() {
		return new Boleto();
	}
}
