package componentes;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
/**
 * Clase concreta que implementa la interface EslabonBase
 * Entrega dinero que es multiplos de 50000 y el sobrante lo transfiere
 * a el siguiente cajero en la cadena de responsabilidad
 */
public class Eslabon50000 extends EslabonBase {
    public Eslabon50000() {
        super("Soy el cajero que procesa entregas en múltiplos de $50,000");
    }

    @Override
    public void procesar(int cantidad) {
        int billetes50000 = cantidad / 50000;
        int sobrante = cantidad % 50000;

        if (billetes50000 > 0) {
            mostrarResultado("Entregando " + billetes50000 + " billetes de $50,000");
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
