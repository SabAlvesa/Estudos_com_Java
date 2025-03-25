/* Em Java, cada classe pública (public class) deve estar em um arquivo separado com o mesmo nome da classe.*/
public class PilhaVideoMain {
        public static void main(String[] args) {
            PilhaVideo p = new PilhaVideo();
            p.push(5);
            p.push(4);
            p.push(3);
            p.push(2);
            p.push(1);
    
            while (!p.isEmpty()) {
                int elementos = p.pop();
                System.out.println("Desempilhei " + elementos);
            }
        }
    
    
}
