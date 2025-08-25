package factorypattern.factory;

import factorypattern.resources.PaymentProcessor;
import factorypattern.resources.provider.PaymentProcessorProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class ServiceLoaderFactory {
	private final Map<String, PaymentProcessorProvider> providers;

	public ServiceLoaderFactory() {
		ServiceLoader<PaymentProcessorProvider> loader = ServiceLoader.load(PaymentProcessorProvider.class);

		providers = new HashMap<>();
		for (PaymentProcessorProvider p : loader) {
			providers.put(p.key().toLowerCase(), p);
		}
	}

	public PaymentProcessor create(String key) {
		var p = providers.get(key.toLowerCase());

		if (p == null) {
			throw new IllegalArgumentException("Tipo desconhecido: " + key);
		}

		return p.create();
	}
}
