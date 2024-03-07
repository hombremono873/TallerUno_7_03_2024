package componentes;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * La clase concreta implementa a la interface EslabonBase
 * Entrega cantidades de dinero que son multiplos de 10000 pesos y si hay un
 * sobrante
 * Transfiere la responsabilidad al siguiente en la cadena de responsabilidad
 */
public class Eslabon10000 extends EslabonBase {
    public Eslabon10000() {
        super("Soy el cajero que procesa entregas en múltiplos de $10,000");
    }

    @Override
    public void procesar(int cantidad) {
        int billetes10000 = cantidad / 10000;
        int sobrante = cantidad % 10000;

        if (billetes10000 > 0) {
            mostrarResultado("Entregando " + billetes10000 + " billetes de $10000");
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
