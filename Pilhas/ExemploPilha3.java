public class ExemploPilha3 {
    // Array que representa a pilha
    public Object[] pilha;
    // Índice que controla o topo da pilha
    public int posicaoPilha;

    // Construtor da pilha
    public ExemploPilha3() {
        // Indica que a pilha está vazia (posição -1 significa "sem elementos")
        this.posicaoPilha = -1;
        // Criando uma pilha com capacidade para 10 elementos
        this.pilha = new Object[10];
    }

    // Método principal que executa o programa
    public static void main(String args[]) {
        ExemploPilha3 p = new ExemploPilha3();

        // Empilhando elementos na pilha (inserindo valores no topo)
        p.empilhar("Portuguesa");
        p.empilhar("Frango com catupiry");
        p.empilhar("Calabresa");
        p.empilhar("Quatro queijos");
        p.empilhar(10); // Adicionando um número como exemplo

        // Desempilhando elementos (removendo do topo) até a pilha ficar vazia
        while (!p.pilhaVazia()) {
            System.out.println(p.desempilhar()); // Exibe o elemento removido
        }
    }

    // Método que verifica se a pilha está vazia
    public boolean pilhaVazia() {
        return this.posicaoPilha == -1;
    }

    // Método que retorna o tamanho da pilha (quantidade de elementos armazenados)
    public int tamanho() {
        return this.pilhaVazia() ? 0 : this.posicaoPilha + 1;
    }

    // Método que exibe o último valor armazenado (o topo da pilha), sem remover
    public Object exibeUltimoValor() {
        if (this.pilhaVazia()) {
            return null; // Retorna null caso a pilha esteja vazia
        }
        return this.pilha[this.posicaoPilha]; // Retorna o topo da pilha
    }

    // Método que remove e retorna o último valor inserido (o topo da pilha)
    public Object desempilhar() {
        if (pilhaVazia()) {
            return null; // Retorna null se a pilha estiver vazia
        }
        return this.pilha[this.posicaoPilha--]; // Retorna o topo e decrementa a posição
    }

    // Método que adiciona um novo valor ao topo da pilha
    public void empilhar(Object valor) {
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor; // Incrementa e insere o valor no topo
        } else {
            System.out.println("Pilha cheia! Não é possível empilhar."); // Mensagem de erro caso a pilha esteja cheia
        }
    }
}
