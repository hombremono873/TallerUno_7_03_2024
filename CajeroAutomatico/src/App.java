import javax.swing.JOptionPane;

import componentes.CajeroEslabon;
import componentes.Eslabon10000;
import componentes.Eslabon100000;
import componentes.Eslabon20000;
import componentes.Eslabon5000;
import componentes.Eslabon50000;
import componentes.EslabonBase;

/**
 * La clase maestra
 * En la aplicacion de Intancian Objetos EslabonBase a traves de los
 * constructores de las clases concretas hecho que es posible dado
 * Que las clase concretas heredan a EslabonBase
 */
public class App {
    private CajeroEslabon eslabonInicial;

    public App() {
        // Instancias
        EslabonBase eslabon100000 = new Eslabon100000();
        EslabonBase eslabon50000 = new Eslabon50000();
        EslabonBase eslabon20000 = new Eslabon20000();
        EslabonBase eslabon10000 = new Eslabon10000();
        EslabonBase eslabon5000 = new Eslabon5000();
        // Transferencias en la operación
        eslabon100000.establecerSiguienteEslabon(eslabon50000);
        eslabon50000.establecerSiguienteEslabon(eslabon20000);
        eslabon20000.establecerSiguienteEslabon(eslabon10000);
        eslabon10000.establecerSiguienteEslabon(eslabon5000);

        eslabonInicial = eslabon100000;
    }

    public void procesarTransaccion(int cantidad) {
        eslabonInicial.procesar(cantidad);
    }

    public static void main(String[] args) {
        App cajero = new App();

        // Solicitar la cantidad al usuario
        String input = JOptionPane.showInputDialog("Ingrese la cantidad de dinero  a retirar: $");
        int cantidad = Integer.parseInt(input);

        // Procesar la transacción
        cajero.procesarTransaccion(cantidad);
    }
}

