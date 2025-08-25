package factorypattern.factory;

import factorypattern.resources.PaymentProcessor;

public class ReflectionFactory {

	private static final String BASE_PACKAGE = "factorypattern.resources";

	public static PaymentProcessor create(String type) {
		try {
			String className = BASE_PACKAGE + "." + capitalize(type);
			Class<?> clazz = Class.forName(className);
			return (PaymentProcessor) clazz.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException("Tipo desconhecido: " + type, e);
		}
	}

	private static String capitalize(String type) {
		return Character.toUpperCase(type.charAt(0)) + type.substring(1).toLowerCase();
	}

}
