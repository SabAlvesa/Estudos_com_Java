package Filas_Circular;

import java.util.Arrays;

public class FilasCExemplo3 {
    public static void main(String[] args) {
        // Criação de uma fila circular de inteiros com capacidade 8
        CircularQueue<Integer> circularQueue = new CircularQueue<>(8);
        
        // Inserindo elementos na fila
        /*circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);*/

        // Exemplo de outra fila circular de Strings
        CircularQueue<String> stringQueue = new CircularQueue<>(8);
        stringQueue.enqueue("Banana");
        stringQueue.enqueue("Maça");
        stringQueue.enqueue("Pera");
        stringQueue.enqueue("Uva");
        stringQueue.enqueue("Abacaxi");
        stringQueue.enqueue("Melão");
        stringQueue.enqueue("Melancia");
        stringQueue.enqueue("Goiaba");

        // Exibindo a fila circular cheia
        System.out.println("Fila circular cheia: " + stringQueue);

        // Desenfileirando um elemento
        System.out.print("\nDesenfileirando elemento: ");
        System.out.println(stringQueue.dequeue() + " ");
        stringQueue.enqueue("Mexerica");
        System.out.println("\nApós enfileirar o elemento Mexerica\n");

        // Tentativa de enfileirar o valor 23 (sem código, mas pode ser feito)
        // stringQueue.enqueue(23);

        // Exibindo a fila após as operações
        System.out.println("\nApós enfileirar o elemento 23\n");
        System.out.println(stringQueue + "\n");
    }
}

// Definição da classe CircularQueue
class CircularQueue<E> {
    private int currentSize; // Tamanho atual da fila
    private E[] circularQueueElements; // Vetor que contém os elementos da fila
    private int maxSize; // Tamanho máximo da fila
    private int rear; // Índice do último elemento
    private int front; // Índice do primeiro elemento

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        circularQueueElements = (E[]) new Object[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    // Método para enfileirar um item
    public void enqueue(E item) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("A fila está cheia! O elemento não pode ser adicionado!");
        } else {
            rear = (rear + 1) % circularQueueElements.length; // Torna a fila circular
            circularQueueElements[rear] = item;
            currentSize++;
            if (front == -1) {
                front = rear; // Caso a fila estava vazia, define o primeiro elemento
            }
        }
    }

    // Método para desenfileirar um item
    public E dequeue() throws QueueEmptyException {
        E deQueuedElement;
        if (isEmpty()) {
            throw new QueueEmptyException("Fila circular vazia! O Elemento não pode ser removido!");
        } else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = null; // Apaga o elemento removido
            front = (front + 1) % circularQueueElements.length; // Torna a fila circular
            currentSize--;
        }
        return deQueuedElement;
    }

    // Verifica se a fila está cheia
    public boolean isFull() {
        return (currentSize == circularQueueElements.length);
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Sobrescreve o método toString para exibir a fila como string
    @Override
    public String toString() {
        return "CircularQueue [" + Arrays.toString(circularQueueElements) + "]";
    }
}

// Exceção personalizada para fila cheia
class QueueFullException extends RuntimeException {
    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }
}

// Exceção personalizada para fila vazia
class QueueEmptyException extends RuntimeException {
    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}
