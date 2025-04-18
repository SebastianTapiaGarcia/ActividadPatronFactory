package extend;

import notificacion.Notificacion;

public class WhatsappNotificacion implements Notificacion{
    private String numero;
    private String mensaje;

    public WhatsappNotificacion(String numero, String mensaje) {
        this.numero = numero;
        this.mensaje = mensaje;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando mensaje de WhatsApp a " + numero + ": " + mensaje);
    }
}
