package factorypattern;

import extend.WhatsappNotificacion;
import notificacion.Notificacion;

public class WhatsappNotificacionFactory implements NotificacionFactory{
     @Override
    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new WhatsappNotificacion(destinatario, mensaje);
    }
}
