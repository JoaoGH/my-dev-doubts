package factorypattern.factory;

import factorypattern.resources.Boleto;
import factorypattern.resources.Cartao;
import factorypattern.resources.PaymentProcessor;
import factorypattern.resources.Pix;

import java.util.Map;
import java.util.function.Supplier;

public class MapSupplier {
    private static final Map<String, Supplier<PaymentProcessor>> REGISTRY = Map.of(
        "pix", Pix::new,
        "boleto", Boleto::new,
        "cartao", Cartao::new
    );
    
    public static PaymentProcessor create(String key) {
        Supplier<PaymentProcessor> sup = REGISTRY.get(key.toLowerCase());
        
        if (sup == null) {
            throw new IllegalArgumentException("Tipo desconhecido: " + key);
        }
        
        return sup.get();
    }

}
