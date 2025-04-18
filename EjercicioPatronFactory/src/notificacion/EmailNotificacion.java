package notificacion;

public class EmailNotificacion implements Notificacion{
    private String email;
    private String mensaje;

    public EmailNotificacion(String email, String mensaje) {
        this.email = email;
        this.mensaje = mensaje;
    }
    
    @Override
    public void enviar(){
        System.out.println("Enviando email a "+email+": "+mensaje);
    }
}
