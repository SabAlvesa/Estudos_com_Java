// Classe que define uma fila simples
//EXEMPLO DE FILA ESTÁTICA
class Queue {
    int itens[];  // Vetor para armazenar os itens da fila
    int front, rear; // Índices do início e fim da fila

    // Construtor para inicializar a fila
    public Queue() {
        itens = new int[100]; // Define a capacidade máxima
        front = 0;  // Índice do primeiro elemento
        rear = 0;   // Índice do próximo espaço livre
    }
}

// Classe principal que manipula a fila
public class FilaExemplo2 {
    static final int TAMANHO_MAXIMO = 100; // Tamanho máximo da fila

    public static void main(String[] args) {
        Queue q = new Queue(); // Criando uma nova fila

        // Inserindo elementos na fila
        System.out.println("Valor " + enqueue(q, 1) + " inserido na fila");
        System.out.println("Valor " + enqueue(q, 2) + " inserido na fila");
        System.out.println("Valor " + enqueue(q, 3) + " inserido na fila");
        System.out.println("Valor " + enqueue(q, 4) + " inserido na fila\n");

        // Exibindo o tamanho da fila
        System.out.println("Fila com " + size(q) + " itens\n");

        // Exibindo o primeiro elemento da fila
        System.out.println("Próximo valor da fila: " + front(q));

        // Removendo elementos da fila
        while (!empty(q)) {
            System.out.println("Tirando o valor " + dequeue(q) + " da fila ...");
            if (!empty(q)) {
                System.out.println("Próximo valor da fila: " + front(q));
            }
        }

        // Exibindo a fila vazia
        System.out.println("\nFila vazia, fila com " + size(q) + " itens\n");
    }

    // Função para verificar se a fila está vazia
    static boolean empty(Queue pq) {
        return pq.front == pq.rear;
    }

    // Função para inserir um elemento na fila
    static int enqueue(Queue pq, int x) {
        if (pq.rear >= TAMANHO_MAXIMO) { // Verifica se a fila está cheia
            System.out.println("\nEstouro da capacidade da fila");
            return -1; // Retorna um valor inválido
        }
        pq.itens[pq.rear++] = x; // Insere o elemento no final da fila
        return x; // Retorna o valor inserido
    }

    // Função para retornar o tamanho da fila
    static int size(Queue pq) {
        return pq.rear - pq.front; // Calcula o número de elementos na fila
    }

    // Função para obter o primeiro elemento da fila
    static int front(Queue pq) {
        if (empty(pq)) {
            System.out.println("\nFila vazia");
            return -1; // Retorna um valor inválido
        }
        return pq.itens[pq.front]; // Retorna o primeiro elemento
    }

    // Função para remover um elemento da fila
    static int dequeue(Queue pq) {
        if (empty(pq)) { // Verifica se a fila está vazia antes de remover
            System.out.println("\nFila vazia");
            return -1;
        }

        int x = pq.itens[pq.front]; // Salva o primeiro elemento

        // Desloca os elementos para manter a ordem da fila
        for (int i = pq.front; i < pq.rear - 1; i++) {
            pq.itens[i] = pq.itens[i + 1];
        }

        pq.rear--; // Atualiza o índice do final da fila
        return x; // Retorna o elemento removido
    }
}
