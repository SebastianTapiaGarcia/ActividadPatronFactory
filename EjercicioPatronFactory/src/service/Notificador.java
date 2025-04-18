package service;
import factorypattern.EmailNotificacionFactory;
import factorypattern.NotificacionFactory;
import factorypattern.PushNotificacionFactory;
import factorypattern.SMSNotificacionFactory;
import factorypattern.VozNotificacionFactory;
import notificacion.Notificacion;
import java.util.HashMap;
import java.util.Map;

public class Notificador {
    private Map<String, NotificacionFactory> factories = new HashMap<>();

    public Notificador() {
        factories.put("EMAIL", new EmailNotificacionFactory());
        factories.put("SMS", new SMSNotificacionFactory());
        factories.put("PUSH", new PushNotificacionFactory());
        factories.put("VOZ", new VozNotificacionFactory());
    }

    public void registrarCanal(String tipo, NotificacionFactory factory) {
        factories.put(tipo.toUpperCase(), factory);
    }

    public void enviarNotificacion(String tipo, String destinatario, String mensaje) {
        NotificacionFactory factory = factories.get(tipo.toUpperCase());
        if (factory == null) {
            throw new IllegalArgumentException("Tipo de notificacion desconocido: " + tipo);
        }
        Notificacion notificacion = factory.crearNotificacion(destinatario, mensaje);
        notificacion.enviar();
    }
}
