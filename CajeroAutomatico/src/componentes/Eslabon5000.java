package componentes;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
/**
 * Clase concreta , implementa a la interface EslabonBase
 * Contiene la logica para entregar dinero en billetes de 5000
 * Este cajero no entrega cantidades menores a 5000 pesos y la retiene
 * Es el ultimo eslabon de la cadena de responsabilidad
 */
public class Eslabon5000 extends EslabonBase {
    public Eslabon5000() {
        super("Soy el cajero que procesa entregas en múltiplos de $5,000");
    }

    @Override
    public void procesar(int cantidad) {
        int billetes5000 = cantidad / 5000;
        int sobrante = cantidad % 5000;

        if (billetes5000 > 0) {
            if (sobrante > 0) {
                mostrarResultado("Se retiene cantidad menor de [$5000] " + " Se retiene $" + sobrante);
            } else
                mostrarResultado("Entregando " + billetes5000 + " billetes de $5000");
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

