public class FilaExemplo3 {
    public static void main(String[] args) {
        // Criando uma fila com capacidade para 10 elementos
        FilaInteiro fila = new FilaInteiro(10);
        
        // Inserindo elementos na fila e exibindo o estado atual
        fila.enqueue(10);
        fila.ExibirFila();
        
        // Removendo um elemento e exibindo o estado da fila
        fila.dequeue();
        fila.ExibirFila();
        
        // Inserindo novos elementos e exibindo a fila após cada inserção
        fila.enqueue(103);
        fila.ExibirFila();
        
        fila.enqueue(120);
        fila.ExibirFila();
        
        fila.enqueue(150);
        fila.ExibirFila();
        
        // Removendo um elemento (103) e inserindo um novo (110)
        fila.dequeue();
        fila.enqueue(110);
        fila.ExibirFila();
    }
}

// Classe que representa uma fila de números inteiros
class FilaInteiro {
    private int[] vetorEstrutura; // Array que armazena os elementos da fila
    private int quantidade; // Quantidade de elementos na fila
    private int inicio; // Índice do primeiro elemento da fila
    private int fim; // Índice do último elemento da fila

    // Construtor para inicializar a fila com um tamanho definido
    public FilaInteiro(int tamanhoFila) {
        vetorEstrutura = new int[tamanhoFila];
        quantidade = 0;
        inicio = -1;
        fim = -1;
    }

    // Método para inserir um elemento na fila
    public void enqueue(int value) {
        if (isEmpty()) { // Se a fila estiver vazia, inicia os índices
            inicio++;
            fim++;
            vetorEstrutura[inicio] = value;
            quantidade++;
        } else {
            if (!isFull()) { // Se a fila não estiver cheia, adiciona ao final
                fim++;
                vetorEstrutura[fim] = value;
                quantidade++;
            } else {
                System.out.println("Fila Cheia!");
            }
        }
    }

    // Método para remover um elemento da fila
    public int dequeue() {
        int valorRetorno = 0;
        if (isEmpty()) {
            System.out.println("Fila Vazia!");
        } else {
            valorRetorno = vetorEstrutura[inicio]; // Obtém o primeiro elemento
            if (inicio == fim) { // Se há apenas um elemento, reseta os índices
                inicio = -1;
                fim = -1;
                quantidade--;
            } else {
                inicio++;
                Reorganizar(); // Ajusta os índices após a remoção
            }
        }
        return valorRetorno;
    }

    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
        return inicio == -1;
    }

    // Método para verificar se a fila está cheia
    public boolean isFull() {
        return fim == vetorEstrutura.length - 1;
    }

    // Método que retorna o número de elementos na fila
    public int size() {
        return quantidade;
    }

    // Método para reorganizar os elementos após uma remoção
    private void Reorganizar() {
        for (int i = inicio; i <= fim; i++) {
            vetorEstrutura[i - 1] = vetorEstrutura[i];
        }
        inicio--;
        fim--;
    }

    // Método para exibir os elementos da fila
    public void ExibirFila() {
        if (!isEmpty()) {
            for (int i = inicio; i <= fim; i++) {
                System.out.print(vetorEstrutura[i] + " ");
            }
        } else {
            System.out.println("\nFila vazia!");
        }
        System.out.println("");
    }
}
