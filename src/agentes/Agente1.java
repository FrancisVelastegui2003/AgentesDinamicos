/**
 * @author Francis Velastegui
 * @date 2024-05-13
 **/
package agentes;

import algoritmoGenetico.Datos;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Agente1 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            Comunicacion.msj(ACLMessage.REQUEST, getAgent(), "Ag2", null,
                    Datos.generarDatos(), "CD-01-02");

            ACLMessage aclmsj = blockingReceive();
            if (aclmsj.getConversationId().equals("CD-02-01")) {
                Comunicacion.msj(ACLMessage.REQUEST, getAgent(), "Ag2", null,
                        Datos.generarDatos(), "CD-01-02");
            }
        }
    }
}
