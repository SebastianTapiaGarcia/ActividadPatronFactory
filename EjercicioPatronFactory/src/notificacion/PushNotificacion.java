package notificacion;

public class PushNotificacion implements Notificacion{
    private String dispositivoId;
    private String mensaje;
    
    public PushNotificacion(String dispositivoId, String mensaje) {
        this.dispositivoId = dispositivoId;
        this.mensaje = mensaje;
    }
    
    @Override
    public void enviar() {
        System.out.println("Enviando notificación push a " + dispositivoId + ": " + mensaje);
    } 
}
