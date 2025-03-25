//Para implementar uma pilha em java possui alguns métodos:
//isEmpty - verifica se a pilha está vazia ou não
//Size - tamanho da pilha
//pop - desempilhar
//push(valor) empilhar
//top() visualizar o ultimo item empilhado
 
//*ultilza um vetor e uma variável inteira ponteiro(determina quantos itens foram empilhados)

public class Pilha {
    
    public Object[] vetor;
    public int ponteiro;

    public Pilha() {
        this.ponteiro = -1; // Pilha vazia na posição -1
        this.vetor = new Object[10000000]; // 10 milhões de posições
    }

    public boolean isEmpty() {
        return this.ponteiro == -1;
    }

    public int size() {
        return this.isEmpty() ? 0 : this.ponteiro + 1;
    }

    public Object top() {
        if (isEmpty()) {
            return null;
        }
        return this.vetor[this.ponteiro];
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return this.vetor[this.ponteiro--];
    }

    public void push(Object valor) {
        if (this.ponteiro < this.vetor.length - 1) {
            this.vetor[++ponteiro] = valor;
        }
    }

    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.push("A");
        p.push(4);
        p.push(7);
        p.push(8);
        p.push(90);
        p.push("a");
        p.push("t");

        while (!p.isEmpty()) {
            System.out.println(p.pop());
        }
    }
}
