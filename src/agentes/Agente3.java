/**
 * @author Francis Velastegui
 * @date 2024-05-13
 **/
package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente3 extends Agent {

    private static final int UMBRAL_APTITUD = 29 ;

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            ACLMessage aclmsj = blockingReceive();
            String datos = aclmsj.getContent();

            if (aclmsj.getConversationId().equals("CD-02-03")) {
                String[] partes = datos.split(";");
                int tamanioPoblacion = Integer.parseInt(partes[0]);
                int evoluciones = Integer.parseInt(partes[1]);
                int iteraciones = Integer.parseInt(partes[2]);
                int x = Integer.parseInt(partes[3]);
                int y = Integer.parseInt(partes[4]);

                if (Math.abs(x) > UMBRAL_APTITUD && Math.abs(y) > UMBRAL_APTITUD) {
                    Comunicacion.msj(ACLMessage.INFORM, getAgent(), "Ag4", datos, null, "CD-03-04");
                } else {
                    Comunicacion.msj(ACLMessage.REQUEST, getAgent(), "Ag2", null, null, "CD-03-02");
                }
            }
        }
    }
}
