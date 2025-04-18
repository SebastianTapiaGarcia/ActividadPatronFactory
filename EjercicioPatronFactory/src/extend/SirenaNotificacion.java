package extend;

import notificacion.Notificacion;

public class SirenaNotificacion implements Notificacion {
    private String ubicacion;
    private String mensaje;

    public SirenaNotificacion(String ubicacion, String mensaje) {
        this.ubicacion = ubicacion;
        this.mensaje = mensaje;
    }

    @Override
    public void enviar() {
        System.out.println("Activando sirena en " + ubicacion + " con mensaje: " + mensaje);
    }
}
