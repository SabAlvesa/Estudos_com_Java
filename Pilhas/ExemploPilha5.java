// Classe principal que usa a Pilha (filaSimples)
public class ExemploPilha5 {
    public static void main(String[] args) {
        // Array de nomes que serão inseridos na pilha
        
        String[] names = {
            "Mark", "Berg", "John", "Beni", "Jebb", "June",
            "Mary", "Karl", "Fred", "Hall", "Troy", "Joan"
        };

        // Cria uma pilha com capacidade para 10 elementos
        filaSimples stack = new filaSimples(10);
        System.out.println("Pilha de " + stack.getCapacity() + " posições criada: " + stack);
        System.out.println();
        
        // Insere elementos na pilha
        System.out.println("Preenchendo a pilha:");
        for (int i = 0; i < names.length; i++) {
            System.out.print("\tInserindo o nome \"" + names[i] + "\":\t");
            if (stack.push(names[i]) == null) {
                System.out.println("PILHA CHEIA!!! impossível inserir...");
            } else {
                System.out.println(stack + ". " + (stack.getCapacity() - stack.getSize()) + " posições restantes.");
            }
        }

        System.out.println();
        System.out.println("Removendo 5 elementos da pilha:");
        
        // Remove 5 elementos da pilha
        for (int i = 1; i <= 5; i++) {
            System.out.print("\t" + i + "a. remoção: \"" + stack.pop() + "\".");
            System.out.println(" A pilha agora está assim: " + stack);
        }

        System.out.println();
        System.out.println("O atual nome no topo da pilha é \"" + stack.peek() + "\".\n");
        System.out.println(stack);
        System.out.println();

        // Limpa a pilha
        stack.clear();
        System.out.println("Limpando a pilha: " + stack);
        System.out.println();

        // Testa se ainda é possível remover algo da pilha
        System.out.print("Consigo tirar mais algo da pilha? ");
        System.out.println(stack.pop() == null ? "Não consigo..." : "Consigo sim!");
    }
}
class filaSimples {
    private String[] pilha; // Array que armazena os elementos da pilha
    private int topo; // Índice do topo da pilha
    private int capacidade; // Capacidade máxima da pilha

    // Construtor da pilha
    public filaSimples(int capacidade) {
        this.capacidade = capacidade;
        this.pilha = new String[capacidade];
        this.topo = -1; // Pilha inicializada vazia
    }

    // Retorna a capacidade total da pilha
    public int getCapacity() {
        return capacidade;
    }

    // Retorna o tamanho atual da pilha (quantos elementos estão nela)
    public int getSize() {
        return topo + 1;
    }

    // Método para adicionar um elemento na pilha (push)
    public String push(String valor) {
        if (topo >= capacidade - 1) {
            return null; // Pilha cheia, não pode adicionar mais elementos
        }
        pilha[++topo] = valor; // Adiciona o elemento no topo da pilha
        return valor;
    }

    // Método para remover um elemento do topo da pilha (pop)
    public String pop() {
        if (topo < 0) {
            return null; // Pilha vazia, não há nada para remover
        }
        return pilha[topo--]; // Remove e retorna o elemento do topo
    }

    // Método para olhar o topo da pilha sem remover (peek)
    public String peek() {
        if (topo < 0) {
            return null; // Pilha vazia
        }
        return pilha[topo]; // Retorna o elemento no topo sem remover
    }

    // Método para esvaziar a pilha
    public void clear() {
        topo = -1; // Define a pilha como vazia
    }

    // Método para exibir o conteúdo da pilha
    @Override
    public String toString() {
        if (topo < 0) {
            return "[Pilha vazia]";
        }
        String resultado = "[";
        for (int i = 0; i <= topo; i++) {
            resultado += pilha[i];
            if (i < topo) {
                resultado += ", ";
            }
        }
        resultado += "]";
        return resultado;
    }
}

