package notificacion;

public class SMSNotificacion implements Notificacion{
    private String telefono;
    private String mensaje;
    
    public SMSNotificacion(String telefono, String mensaje) {
        this.telefono = telefono;
        this.mensaje = mensaje;
    }
    
    @Override
    public void enviar() {
        System.out.println("Enviando SMS a " + telefono + ": " + mensaje);
    }
}
