package examen;

public class Hilo extends Thread{
    private Colecta colecta;

    public Hilo(Colecta colecta){
        this.colecta = colecta;
    }

    @Override
    public void run() {

        System.out.println(this.getName() + " Inicio");
        int n = (int) (Math.random()*(25-5+1)+5);
        //bucle para establecer el máximo de 2000
        while(colecta.getContador()<=2000){
                colecta.incrementar();
                System.out.println("Recuento continuo " + colecta.getContador());
                int ms = (int) (Math.random()*(200-10+1)+10);
                try {
                    Thread.sleep(ms);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println(this.getName() + "Fin del trabajo");
    }
}
