// a impletação das pilhas em forma de lista é mais fácil pois não tem um tamanho fixo
// os dados devem ser empilhados em alguma extremidade e desempilhados a partir dessa mesma extremidade
//ponteiros não possui a informação mas sim onde está a informação
import java.util.Stack;

public class ExemploPilhas{
    public static void main(String[]args){
        Stack<String>pilha = new Stack<>();

        pilha.push ("Prato 1");
        pilha.push("Prato 2");
        pilha.push("Prato 3");

        System.out.println("Topo da pilha:" + pilha.peek());
        //peek serve para olhar o elemento do topo da pilha sem remove-lo

        System.out.println("Removendo:" + pilha.pop());

        System.out.println("nova pilha" + pilha);
    }
}