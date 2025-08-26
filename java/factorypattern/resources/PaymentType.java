package factorypattern.resources;

import java.util.function.Supplier;

public enum PaymentType {
	PIX(Pix::new),
	BOLETO(Boleto::new),
	CARTAO(Cartao::new);

	private final Supplier<PaymentProcessor> supplier;

	PaymentType(Supplier<PaymentProcessor> supplier) {
		this.supplier = supplier;
	}

	public PaymentProcessor create() {
		return supplier.get();
	}
}
