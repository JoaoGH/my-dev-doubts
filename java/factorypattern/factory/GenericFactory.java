package factorypattern.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class GenericFactory {
    private final Map<Class<?>, Supplier<?>> registry = new ConcurrentHashMap<>();

    public <T> void register(Class<T> type, Supplier<? extends T> supplier) {
        registry.put(type, supplier);
    }

    public <T> T create(Class<T> type) {
        Supplier<?> s = registry.get(type);
        
        if (s == null) {
            throw new IllegalArgumentException("Não registrado: " + type);
        }
        
        return type.cast(s.get());
    }
}
