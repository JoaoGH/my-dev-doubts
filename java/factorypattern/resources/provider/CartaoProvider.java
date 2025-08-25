package factorypattern.resources.provider;

import factorypattern.resources.Cartao;
import factorypattern.resources.PaymentProcessor;

public class CartaoProvider implements PaymentProcessorProvider {
	public String key() {
		return "cartao";
	}

	public PaymentProcessor create() {
		return new Cartao();
	}
}
