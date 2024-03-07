package componentes;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * Clase concreta que implementa a la interface EslabonBase
 * entrega dinero que son multiplos de 100000 y el sobrante lo 
 * transfiere al siguiente cajero en la cadena de responsabilidad
 */
public class Eslabon100000 extends EslabonBase {
    public Eslabon100000() {
        super("Soy el cajero que procesa entregas en múltiplos de $100,000");
    }

    @Override
    public void procesar(int cantidad) {
        int billetes100000 = cantidad / 100000;
        int sobrante = cantidad % 100000;

        if (billetes100000 > 0) {
            mostrarResultado("Entregando " + billetes100000 + " billetes de $100000");
        }

        procesarSolicitud(sobrante);
    }

    private void mostrarResultado(String mensaje) {
        mostrarVentanaModal(mensaje);
    }

    private void mostrarVentanaModal(String mensaje) {
        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String fechaHora = formatoFechaHora.format(new Date());

        JOptionPane.showMessageDialog(null, "Banco para Todos\nFecha y Hora: " + fechaHora + "\n" +
                obtenerDescripcion() + "\n" + mensaje);
    }
}
