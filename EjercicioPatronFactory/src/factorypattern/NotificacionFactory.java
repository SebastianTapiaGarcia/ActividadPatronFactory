package factorypattern;

import notificacion.Notificacion;

public interface NotificacionFactory {
    Notificacion crearNotificacion(String destinatario, String mensaje);
}
