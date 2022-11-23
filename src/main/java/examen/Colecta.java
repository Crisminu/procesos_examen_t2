package examen;
//Varios hilos (por ejemplo, cinco) realizan una colecta.
// En un tiempo aleatorio entre 10 y 200 ms, consiguen una cantidad de entre 5 y 25.
//La colecta termina cuando se llega a una cantidad total de 2 000.
// (Obtenida sumando las aportaciones de cada hilo).
//
//Utilizar una clase Colecta que almacene y permita consultar la cantidad
// recogida hasta el momento. El hilo principal crea un objeto de tipo Colecta,
// crea los hilos y les pasa este objeto, que es compartido entre todos y, por tanto,
// sus métodos deben protegerse de manera apropiada con métodos synchronized.
//
//El programa mostrará por pantalla las aportaciones sucesivas de cada hilo y el
// total sumado de todos los hilos aceptando nuevas aportaciones mientras el total
// sea inferior a 2000. Una vez se llega a 2000 se para el programa.

public class Colecta {

    private long contadorC = 0;

    private final Object lock = new Object();
    public void incrementar(){
        synchronized (lock){
            //Le asigno un número random entre 5 y 25 que se le añade en cada pasada
            int n = (int) (Math.random()*(25-5+1)+5);
            System.out.println("Manzanas añadidas: " + n);
            contadorC+=n;
        }
    }
    public long getContador(){
        synchronized (lock){
            return contadorC;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Colecta c= new Colecta();
        Hilo [] hilos = new Hilo[5];
        for(int i=0;i<hilos.length;i++) {
            //Creación de hilos
            hilos[i] = new Hilo(c);
            //Iniciando hilos
            hilos[i].start();
        }
        //Le asigno un tiempo alto debido a mi procesador, para que le de tiempo a los demás hilos a terminar antes que el hilo main
        Thread.sleep(8000);
        System.out.println("Colecta total " + c.contadorC);
    }
}
