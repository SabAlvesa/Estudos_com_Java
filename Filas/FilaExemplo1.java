import java.util.Scanner;

public class FilaExemplo1 {
    static Scanner in = new Scanner(System.in);
    static int tam_max = 10;  // Tamanho máximo da fila
    static int tam = 0;       // Tamanho atual da fila

    public static void main(String[] args) {
        int vet[] = new int[tam_max]; // Declaração do vetor da fila
        int op, elem; // Variáveis auxiliares para opção do usuário e elemento a inserir/remover

        do {
            // Exibe o menu de opções
            System.out.println("\n1 - Inserir elemento na fila");
            System.out.println("2 - Remover elemento da fila");
            System.out.println("3 - Exibir fila");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            op = in.nextInt(); // Lê a opção do usuário

            switch (op) {
                case 1: // Inserir elemento na fila
                    System.out.print("\nDigite o elemento a ser inserido: ");
                    elem = in.nextInt();
                    enfileirar(vet, elem);
                    break;

                case 2: // Remover elemento da fila
                    elem = desenfileirar(vet);
                    if (elem != -1) {
                        System.out.println("\nElemento removido da fila: " + elem);
                    }
                    break;

                case 3: // Exibir fila
                    exibe(vet);
                    break;

                case 0: // Sair do programa
                    System.out.println("\nSaindo do programa...");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (op != 0); // Continua o loop enquanto o usuário não escolher sair
    }

    // Função para exibir os elementos da fila
    static void exibe(int vet[]) {
        if (tam >= 1) {
            System.out.println("\nElementos da fila:");
            for (int i = 0; i < tam; i++) {
                System.out.println("vet[" + i + "] = " + vet[i]);
            }
        } else {
            System.out.println("\nFila vazia!");
        }
    }

    // Função para adicionar elementos na fila
    static void enfileirar(int vet[], int elem) {
        if (tam == tam_max) { // Verifica se a fila está cheia
            System.out.println("\nFila cheia! Não é possível adicionar mais elementos.");
        } else {
            vet[tam] = elem; // Adiciona o elemento no final da fila
            tam++; // Atualiza o tamanho da fila
        }
    }

    // Função para remover elementos da fila
    static int desenfileirar(int vet[]) {
        if (tam == 0) { // Verifica se a fila está vazia antes de remover
            System.out.println("\nFila vazia! Não há elementos para remover.");
            return -1; // Retorna -1 para indicar erro
        }

        int elem = vet[0]; // Pega o primeiro elemento da fila
        tam--; // Reduz o tamanho da fila

        // Desloca todos os elementos uma posição para frente
        for (int i = 0; i < tam; i++) {
            vet[i] = vet[i + 1];
        }

        return elem; // Retorna o elemento removido
    }
}

