import java.util.Scanner; // Importação correta da classe Scanner

// Classe principal que usa a Pilha
public class ExemploPilha4 {
    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);
        
        // Solicita ao usuário um número para inserir na pilha
        System.out.println("Entre com um número:");
        int valor = entrada.nextInt();

        // Cria uma nova pilha
        Pilha novaPilha = new Pilha();

        // Empilha os valores na pilha
        novaPilha.push(valor);
        novaPilha.push(70);
        novaPilha.push(88);

        // Desempilha e exibe os elementos
        System.out.println("Item de valor " + novaPilha.pop() + " retirado da pilha");
        System.out.println("Item restante: " + novaPilha.peek());
        System.out.println("Item de valor " + novaPilha.pop() + " retirado da pilha");
        System.out.println("Item restante: " + novaPilha.peek());

        entrada.close(); // Fecha o Scanner para evitar vazamento de recursos
    }
}

// Classe que representa a estrutura de dados Pilha
class Pilha {
    static final int MAX = 10; // Capacidade máxima da pilha
    int top; // Indica o topo da pilha
    int a[] = new int[MAX]; // Array que armazena os elementos da pilha

    // Construtor da pilha
    Pilha() {
        top = -1; // Inicializa a pilha como vazia
    }

    // Método que verifica se a pilha está vazia
    boolean isEmpty() {
        return (top < 0);
    }

    // Método que empilha (adiciona) um elemento no topo da pilha
    boolean push(int x) {
        if (top >= (MAX - 1)) { // Verifica se a pilha está cheia
            System.out.println("Estouro de Pilha!"); // Mensagem de erro
            return false;
        } else {
            a[++top] = x; // Incrementa o topo e adiciona o elemento
            return true;
        }
    }

    // Método que desempilha (remove) e retorna o elemento do topo da pilha
    int pop() {
        if (top < 0) { // Verifica se a pilha está vazia
            System.out.println("Pilha Vazia!"); // Mensagem de erro
            return -1; // Retorna um valor indicativo de erro
        } else {
            return a[top--]; // Retorna o valor do topo e decrementa
        }
    }

    // Método que retorna o elemento do topo da pilha sem removê-lo
    int peek() {
        if (top < 0) { // Verifica se a pilha está vazia
            System.out.println("Pilha Vazia!"); // Mensagem de erro
            return -1; // Retorna um valor indicativo de erro
        } else {
            return a[top]; // Retorna o valor no topo da pilha
        }
    }
}
