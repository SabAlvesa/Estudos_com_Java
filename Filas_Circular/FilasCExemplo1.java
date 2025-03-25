package Filas_Circular;

public class FilasCExemplo1 {
    static final int MAX = 4; // Número máximo de elementos na fila
    static int comeco = 0; // Indica o início da fila
    static int tamanho = 0; // Tamanho atual da fila (quantos elementos estão na fila)
    static int queue[] = new int[MAX]; // Vetor para armazenar os elementos da fila

    public static void main(String[] args) {
        int i; // Variável para contagem (no loop que exibe a fila)
        
        // Inserindo elementos na fila
        inserir(1);    // Insere o elemento 1 na fila
        inserir(10);   // Insere o elemento 10 na fila
        inserir(100);  // Insere o elemento 100 na fila
        inserir(1000); // Insere o elemento 1000 na fila
        
        System.out.println("");  // Adiciona uma linha em branco para organização

        // Remover um elemento da fila
        remover();  // Remove o primeiro elemento da fila

        // Inserindo mais elementos após a remoção
        inserir(6);   // Insere o elemento 6 na fila
        inserir(60);  // Insere o elemento 60 na fila
        
        // Removendo um elemento após inserções
        remover();    // Remove o primeiro elemento da fila

        // Inserindo mais um elemento
        inserir(80);  // Insere o elemento 80 na fila

        System.out.println("");  // Adiciona uma linha em branco para organização

        // Mostra os elementos da fila após as operações
        for (i = 0; i < MAX; i++) {
            System.out.println("fila[" + i + "] = " + queue[i]);
        }
    }

    // Função para inserir um elemento na fila
    static void inserir(int elemento) {
        // Checa se a fila está cheia
        if (tamanho == MAX) {
            System.out.println("\nfila cheia\n");
        } else {
            // Para tornar a fila circular, calcula o índice usando o módulo
            queue[((comeco + tamanho) % MAX)] = elemento;
            System.out.println("Valor " + elemento + " inserido no índice " 
                               + ((comeco + tamanho) % MAX) + " da fila");
            // Incrementa o tamanho da fila
            tamanho++;
        }
    }

    // Função para remover o primeiro elemento da fila
    static void remover() {
        // Checa se a fila está vazia
        if (tamanho == 0) {
            System.out.println("\nfila vazia\n");
        } else {
            // Desloca o ponteiro "comeco" para o próximo elemento
            comeco++;
            // Decrementa o tamanho da fila, pois um elemento foi removido
            tamanho--;
        }
    }
}
