package componentes;

public abstract class EslabonBase implements CajeroEslabon {
    private CajeroEslabon siguienteEslabon;   //Hacia el siguiente eslabon
    private String descripcion;

    public EslabonBase(String descripcion) {
        this.descripcion = descripcion;
    }

    public void establecerSiguienteEslabon(CajeroEslabon siguienteEslabon) {
        this.siguienteEslabon = siguienteEslabon;
    }
     //El metodo llama  al metodo procesar() de una eslabon quien a su ves lo
     //Implemento de Cajero Eslabon
    public void procesarSolicitud(int cantidad) {
        if (siguienteEslabon != null) {
            siguienteEslabon.procesar(cantidad);
        }
    }

    protected String obtenerDescripcion() {
        return descripcion;
    }
}
