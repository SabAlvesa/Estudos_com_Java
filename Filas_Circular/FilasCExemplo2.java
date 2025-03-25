package Filas_Circular;

public class FilasCExemplo2 {
    static final int TAMANHO = 5; // Definindo o tamanho máximo da fila (5 elementos)

    public static void main(String[] args) {
        Fila minhaFila = new Fila(TAMANHO); // Criando uma instância da fila com o tamanho correto
        criaFila(minhaFila); // Inicializando a fila
        enQueue(minhaFila, 1); // Inserindo o valor 1 na fila
        System.out.println("Valor 1 adicionado a fila!\n");
        enQueue(minhaFila, 2); // Inserindo o valor 2 na fila
        System.out.println("Valor 2 adicionado a fila!\n");
        enQueue(minhaFila, 3); // Inserindo o valor 3 na fila
        System.out.println("Valor 3 adicionado a fila!\n");
        enQueue(minhaFila, 4); // Inserindo o valor 4 na fila
        System.out.println("Valor 4 adicionado a fila!\n");
        enQueue(minhaFila, 5); // Inserindo o valor 5 na fila
        System.out.println("Valor 5 adicionado a fila!\n\n");

        System.out.println("Tentativa de adicionar o valor 6 à fila!\n");
        enQueue(minhaFila, 6); // Tentando adicionar o valor 6, mas a fila está cheia

        System.out.println("Valor " + deQueue(minhaFila) + " removido da fila!\n"); // Removendo o primeiro valor da fila
        System.out.println("Valor " + deQueue(minhaFila) + " removido da fila!\n\n");

        enQueue(minhaFila, 7); // Inserindo o valor 7 na fila
        System.out.println("Valor 7 adicionado a fila!\n");
        enQueue(minhaFila, 8); // Inserindo o valor 8 na fila
        System.out.println("Valor 8 adicionado a fila!\n\n");

        // Removendo os valores da fila
        System.out.println("Valor " + deQueue(minhaFila) + " removido da fila!\n");
        System.out.println("Valor " + deQueue(minhaFila) + " removido da fila!\n");
        System.out.println("Valor " + deQueue(minhaFila) + " removido da fila!\n");
        System.out.println("Valor " + deQueue(minhaFila) + " removido da fila!\n");
        System.out.println("Valor " + deQueue(minhaFila) + " removido da fila!\n\n");

        // Tentativa de remover de uma fila vazia
        System.out.println("Tentativa de remover valor da fila!");
        System.out.println(deQueue(minhaFila)); // Erro: fila vazia
    }

    // Função para adicionar um elemento à fila (enfileirar)
    static void enQueue(Fila f, int dado) {
        // Verificando se a fila está cheia
        if ((f.inicio == f.fim + 1) || (f.inicio == 0 && f.fim == f.dados.length - 1)) {
            System.out.println("\nErro: fila cheia\n\n\n");
        } else {
            // Se a fila estava vazia, ajusta o início
            if (f.inicio == -1) {
                f.inicio = 0;
            }
            // Aumenta o índice de 'fim' e insere o dado na posição
            f.fim = (f.fim + 1) % f.dados.length;
            f.dados[f.fim] = dado;
        }
    }

    // Função para inicializar a fila (definir início e fim)
    static void criaFila(Fila f) {
        f.inicio = -1; // A fila está vazia, portanto início = -1
        f.fim = -1; // A fila está vazia, portanto fim = -1
    }

    // Função para remover um elemento da fila (desenfileirar)
    static int deQueue(Fila f) {
        int dado;
        // Verificando se a fila está vazia
        if (f.inicio == -1) {
            System.out.println("\nErro: fila vazia\n\n");
            return 0; // Retorna 0 indicando erro
        } else {
            // Obtendo o valor do primeiro elemento
            dado = f.dados[f.inicio];
            // Verificando se há apenas um item na fila
            if (f.inicio == f.fim) {
                f.inicio = f.fim = -1; // Se a fila ficar vazia, reseta os índices
            } else {
                // Avançando o índice de início da fila
                f.inicio = (f.inicio + 1) % f.dados.length;
            }
        }
        return dado; // Retorna o valor removido
    }

    // Função para exibir os dados da fila
    static void imprimeDados(Fila f) {
        System.out.println("\n[");
        // Loop para imprimir os elementos da fila
        for (int cont = 0; cont < f.dados.length; cont++) {
            System.out.println(f.dados[cont]);
        }
        System.out.println("]");
    }
}

// Classe que representa a estrutura de dados da fila
class Fila {
    int[] dados; // Vetor que armazena os elementos da fila
    int inicio; // Índice de onde o próximo elemento será removido
    int fim; // Índice onde o próximo elemento será inserido

    // Construtor para inicializar o tamanho do vetor 'dados'
    public Fila(int tamanho) {
        dados = new int[tamanho];
        inicio = -1;
        fim = -1;
    }
}

