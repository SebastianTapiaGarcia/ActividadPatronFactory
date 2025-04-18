package notificacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VozNotificacion implements Notificacion{
    private String telefono;
    private String mensaje;
    private static final int MAX_LEN = 500;
    private Scanner scanner = new Scanner(System.in);

    public VozNotificacion(String telefono, String mensaje) {
        this.telefono = telefono;
        this.mensaje = mensaje;
    }
    
    private void convertirTextoAVoz(){
        System.out.print("Escribe tu mensaje: ");
        mensaje = scanner.nextLine();

        String[] partesMensaje = dividirMensaje(mensaje);

        System.out.println("\nMensaje procesado:");
        for (String parte : partesMensaje) {
            System.out.println("- " + parte);
        }
    }
        
    @Override
    public void enviar() {
        System.out.println("Preparando llamada de voz a " + telefono);

        // Convertir el texto a voz
        convertirTextoAVoz();

        hacerLlamada(); // Intentar la llamada con reintentos
        
        interactuarConConsola();
    }
    
    private void registrarDuracionLlamada() {
        int duracion = (int) (Math.random() * 10 + 1); // Duración aleatoria
        System.out.println("Llamada duro " + duracion + " segundos.");
    }

    private static String[] dividirMensaje(String mensaje) {
        if (mensaje.length() <= MAX_LEN) {
            return new String[]{mensaje}; // Si el mensaje es corto, devolverlo sin dividir
        }

        List<String> partes = new ArrayList<>();
        int inicio = 0;

        while (inicio < mensaje.length()) {
            int fin = Math.min(inicio + MAX_LEN, mensaje.length());

            // Evitar cortes abruptos en palabras
            if (fin < mensaje.length() && mensaje.charAt(fin) != ' ') {
                int posibleFin = mensaje.lastIndexOf(" ", fin);
                if (posibleFin > inicio) {
                    fin = posibleFin; // Ajustar límite a la última palabra
                } else {
                    fin = Math.min(inicio + MAX_LEN, mensaje.length()); // Si no hay espacios, cortar normal
                }
            }

            partes.add(mensaje.substring(inicio, fin).trim()); // Recortar espacios innecesarios
            inicio = fin + 1;
        }

        return partes.toArray(new String[0]); // Convertir lista a arreglo
    }

    
    private void hacerLlamada() {
        int intentos = 0;
        boolean llamadaExitosa = false;

        while (intentos < 2 && !llamadaExitosa) {
            System.out.println("Intentando llamada a " + telefono + " (Intento " + (intentos + 1) + ")...");
        
            // Simulación de éxito de la llamada (50% de probabilidad)
            llamadaExitosa = Math.random() > 0.5;

            if (llamadaExitosa) {
                System.out.println("Llamada exitosa.");
                registrarDuracionLlamada();
            } else {
                System.out.println("No hubo respuesta.");
                intentos++;
            }
        }

        if (!llamadaExitosa) {
            System.out.println("La llamada a " + telefono + " fallo despues de 3 intentos.");
        }
    }
    
    public void interactuarConConsola() {
        System.out.println(" Envia un mensaje (o 'salir' para terminar):");
        mensaje = scanner.nextLine();

        while (!mensaje.equalsIgnoreCase("salir")) { // Permitir múltiples interaciones
            String[] partesMensaje = dividirMensaje(mensaje);

            System.out.println("\n Mensaje procesado:");
            for (String parte : partesMensaje) {
                System.out.println("- " + parte);
            }
           
            hacerLlamada();
   
            System.out.println("\n Escribe otro mensaje (o 'salir' para finalizar):");
            mensaje = scanner.nextLine();
        }

        scanner.close();
    }
}
