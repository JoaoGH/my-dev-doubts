# Pergunta / Question
Como criar um Factory em Java sem usar `if/else` ou `switch`?

---

# Solução / Solution
Tem vários caminhos possiveis para essa solução que estão listados nesse diretório.

- MapSupplier

---

# Explicação / Explanation

### MapSupplier
**Ideia:**  
Usar um `Map<String, Supplier<T>>` como registry, onde a chave representa o tipo solicitado e o `Supplier` sabe 
instanciar a implementação correta.
Isso elimina a necessidade de `if/else` ou `switch-case`.

**Vantagens**
- Simples e direto, sem dependências externas.
- Elimina estruturas condicionais longas.
- Fácil de estender adicionando novas entradas ao mapa.

**Desvantagens**
- O registry precisa ser mantido manualmente.
- Uso de `String` como chave pode gerar erros de digitação.
- Cria novas instâncias a cada chamada, a menos que o `Supplier` seja configurado como singleton.

**Cenário indicado**
- Projetos pequenos ou médios em que o conjunto de implementações é conhecido.
- Quando se deseja baixo acoplamento e clareza no código.

---

# Referências / References
- [Refactoring Guru - Factory Method](https://refactoring.guru/design-patterns/factory-method)  
- [Supplier Interface - Java Docs](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)  


