/**
 * @author Francis Velastegui
 * @date 2024-05-13
 **/
package agentes;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente4 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour {

        private boolean recibido = false;
        private String mejorPoblacion = "";

        @Override
        public void action() {
            ACLMessage aclmsj = blockingReceive();
            String datos = aclmsj.getContent();

            if (aclmsj.getConversationId().equals("CD-03-04")) {
                recibido = true;
                mejorPoblacion = datos;

                // Separar la información y mostrar en líneas separadas
                String[] partes = mejorPoblacion.split(";");
                if (partes.length >= 5) {
                    System.out.println("********* MEJOR CONFIGURACION *********");
                    System.out.println("Tamaño de la población: " + partes[0]);
                    System.out.println("Iteraciones: " + partes[1]);
                    System.out.println("Evoluciones: " + partes[2]);
                    System.out.println("Mejor cromosoma X, Y: " + partes[3] + ";" + partes[4]);
                    doDelete(); // Termina el agente
                } else {
                    System.out.println("Error: Datos incompletos recibidos del Agente4.");
                }
            }
        }

        @Override
        public boolean done() {
            return true;
        }
    }
}
