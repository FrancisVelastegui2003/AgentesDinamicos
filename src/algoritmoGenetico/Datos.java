/**
 * @author Francis Velastegui
 * @date 2024-05-13
 **/
package algoritmoGenetico;

import jade.util.leap.Serializable;
import java.util.Random;

public class Datos implements Serializable {
    private static Random rand = new Random();

    public static int[] generarDatos(){
        int tamanioPoblacion = rand.nextInt(5) + 1;  // Genera un número aleatorio entre 1 y 5
        int evoluciones = rand.nextInt(8) + 1;  // Genera un número aleatorio entre 1 y 8
        int iteracciones = rand.nextInt(5) + 1;  // Genera un número aleatorio entre 1 y 5
        int longCromosoma = 12;

        return new int[]{tamanioPoblacion, evoluciones, iteracciones, longCromosoma};
    }
}
