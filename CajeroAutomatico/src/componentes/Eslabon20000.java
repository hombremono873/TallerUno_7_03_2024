package componentes;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
/**
 * Clase concreta que implementa la interface EslabonBase
 * Entrega dinero que son multiplos de 20000 pesos  el sobrante lo transfiere al siguiente
 * Eslabon en la cadena de respnsabilidad
 */
public class Eslabon20000 extends EslabonBase {
    public Eslabon20000() {
        super("Soy el cajero que procesa entregas en múltiplos de $20,000");
    }

    @Override
    public void procesar(int cantidad) {
        int billetes20000 = cantidad / 20000;
        int sobrante = cantidad % 20000;

        if (billetes20000 > 0) {
            mostrarResultado("Entregando " + billetes20000 + " billetes de $20000");
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
