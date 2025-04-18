package factorypattern;

import notificacion.SMSNotificacion;
import notificacion.Notificacion;

public class SMSNotificacionFactory implements NotificacionFactory{
    @Override
    public Notificacion crearNotificacion(String destinatario, String mensaje){
        return new SMSNotificacion(destinatario, mensaje);
    }
}
