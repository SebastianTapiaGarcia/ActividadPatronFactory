package factorypattern;

import extend.SirenaNotificacion;
import notificacion.Notificacion;

public class SirenaNotificacionFactory implements NotificacionFactory {
    @Override
    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new SirenaNotificacion(destinatario, mensaje);
    }
}
