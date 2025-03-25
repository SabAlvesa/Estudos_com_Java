/*usando a estrategia de alocação estática: tamanho fixo e pré definido
*/
class PilhaVideo {
    int elementos[];
    int topo;

    public PilhaVideo() {
        elementos = new int[10];
        topo = -1; // posição inválida do vetor
    }

    public void push(int a) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow");
        }
        elementos[++topo] = a; // Incrementa topo antes de armazenar
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Empty");
        }
        return elementos[topo--]; // Retorna e depois decrementa
    }

    public boolean isEmpty() {
        return (topo == -1);
    }

    public boolean isFull() {
        return (topo == elementos.length - 1); // Usa length para ser dinâmico
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty, cannot retrieve top element.");
        }
        return elementos[topo];
    }
}
