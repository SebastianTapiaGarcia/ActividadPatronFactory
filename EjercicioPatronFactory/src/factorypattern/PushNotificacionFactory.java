package factorypattern;

import notificacion.PushNotificacion;
import notificacion.Notificacion;

public class PushNotificacionFactory implements NotificacionFactory{
    @Override
    public Notificacion crearNotificacion(String destinatario, String mensaje){
        return new PushNotificacion(destinatario, mensaje);
    }
}
