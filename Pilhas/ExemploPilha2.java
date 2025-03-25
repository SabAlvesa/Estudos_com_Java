public class ExemploPilha2 {
    // Pilha representada por um array de inteiros com capacidade para 10 elementos
    static int pilha[] = new int[10];
    // Variável que indica a posição do topo da pilha (inicialmente vazia)
    static int pos = 0;

    public static void main(String args[]) {
        System.out.println("\nColoca dados na pilha!");

        // Adicionando elementos à pilha (empilhando)
        push(4);
        System.out.println("\nValor adicionado na pilha: " + 4);
        push(9);
        System.out.println("\nValor adicionado na pilha: " + 9);
        push(3);
        System.out.println("\nValor adicionado na pilha: " + 3);

        // Exibe o tamanho atual da pilha
        System.out.println("\n\nTamanho da pilha: " + size());

        // Removendo elementos da pilha (desempilhando)
        System.out.println("\nPegando dado da pilha: " + pop());
        System.out.println("\nPegando dado da pilha: " + pop());
        System.out.println("\nPegando dado da pilha: " + pop());

        // Exibe o tamanho atual da pilha após as remoções
        System.out.println("\n\nTamanho da pilha: " + size());
    }

    // Método que empilha (adiciona) um novo elemento no topo da pilha
    static void push(int valor) {
        if (pos < pilha.length) { // Verifica se há espaço na pilha
            pilha[pos] = valor;
            pos++; // Atualiza o topo da pilha
        } else {
            System.out.println("Erro: Pilha cheia! Não é possível adicionar " + valor);
        }
    }

    // Método que desempilha (remove) e retorna o elemento do topo da pilha
    static int pop() {
        if (pos > 0) { // Verifica se a pilha não está vazia antes de remover
            return pilha[--pos]; // Decrementa o topo e retorna o valor removido
        } else {
            System.out.println("Erro: Pilha vazia! Não há elementos para remover.");
            return -1; // Retorna um valor indicativo de erro
        }
    }

    // Método que retorna o tamanho da pilha (quantidade de elementos armazenados)
    static int size() {
        return pos; // O topo indica quantos elementos estão na pilha
    }

    // Método que retorna o elemento do topo da pilha sem removê-lo
    static int stacktop() {
        if (pos > 0) { // Verifica se há elementos na pilha antes de acessar
            return pilha[pos - 1]; // Retorna o elemento no topo da pilha
        } else {
            System.out.println("Erro: Pilha vazia! Não há topo para exibir.");
            return -1; // Retorna um valor indicativo de erro
        }
    }
}
