package factorypattern;

import service.Notificador;

public class FactoryPattern {

    public static void main(String[] args) {
        Notificador notificador = new Notificador();

        // Se puede registrar nuevos tipos sin tocar el núcleo
        notificador.registrarCanal("WHATSAPP", new WhatsappNotificacionFactory());
        notificador.registrarCanal("SIRENA", new SirenaNotificacionFactory());
        notificador.enviarNotificacion("EMAIL", "correo@dominio.com", "Hola por email!");
        notificador.enviarNotificacion("WHATSAPP", "+51987654321", "Mensaje via WhatsApp");
        notificador.enviarNotificacion("SIRENA", "Zona A", "Alerta critica!");
        notificador.enviarNotificacion("VOZ", "+51987654321" ,"");
    }
    
}
