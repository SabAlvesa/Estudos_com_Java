public class FilaVideoMain {
    public static void main(String[]args){
        FilaVideo fila = new FilaVideo();
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        fila.inserir(4);

        while(! fila.isEmpty() ){
            int x = fila.retirar();
            System.out.println("Retire o elemento" + x);

        }
    }
}
