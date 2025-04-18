package factorypattern;

import notificacion.VozNotificacion;
import notificacion.Notificacion;

public class VozNotificacionFactory implements NotificacionFactory{
    @Override
    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new VozNotificacion(destinatario, mensaje);
    }
}
