
/* inserir - retirar - isEmpty(está vazia) - isFull (está cheia) */
 // Declara o pacote onde a classe está localizada

public class FilaVideo {
    private int[] valores; // Array que armazena os elementos da fila
    private int primeiro; // Índice do primeiro elemento da fila
    private int ultimo; // Índice do próximo espaço livre na fila
    private int total; // Contador do número total de elementos na fila

    // Construtor da classe
    public FilaVideo() {
        valores = new int[10]; // Inicializa o array com tamanho fixo de 10 posições
        primeiro = 0; // O primeiro elemento começa na posição 0
        ultimo = 0; // O último elemento começa na posição 0
        total = 0; // Inicialmente, a fila está vazia
    }
    
    // Método para inserir um elemento na fila
    public void inserir(int elemento) {
        if (isFull()) { // Verifica se a fila está cheia
            throw new RuntimeException("Fila cheia! Não é possível inserir mais elementos.");
        }
        valores[ultimo] = elemento; // Adiciona o elemento na posição disponível
        ultimo = (ultimo + 1) % valores.length; // Atualiza o índice do último elemento (considerando fila circular)
        total++; // Incrementa o contador de elementos na fila
    }

    // Método para remover um elemento da fila
    public int retirar() {
        if (isEmpty()) { // Verifica se a fila está vazia antes de remover
            throw new RuntimeException("Fila vazia! Não há elementos para remover.");
        }
        int elemento = valores[primeiro]; // Armazena o primeiro elemento para retorno
        primeiro = (primeiro + 1) % valores.length; // Move o índice do primeiro elemento para a próxima posição
        total--; // Decrementa o contador de elementos na fila
        return elemento; // Retorna o elemento removido
    }

    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
        return total == 0; // Retorna true se não houver elementos na fila
    }

    // Método para verificar se a fila está cheia
    public boolean isFull() {
        return total == valores.length; // Retorna true se a fila estiver com a capacidade máxima
    }
    
    // Método para visualizar o primeiro elemento da fila sem removê-lo
    public int peek() {
        if (isEmpty()) { // Verifica se a fila está vazia
            throw new RuntimeException("Fila vazia! Não há elementos para visualizar.");
        }
        return valores[primeiro]; // Retorna o primeiro elemento da fila
    }
}