import com.acdat.unit2.MiBMP;

public class Main {
    public static void main(String[] args) {

        MiBMP miBMP = new MiBMP("Splash.bmp");

        if (miBMP.abrirArchivo()) {
            miBMP.informacion();
            System.out.println("Alto: " + miBMP.getAlto());
            System.out.println("Ancho: " + miBMP.getAncho());
            System.out.println("Tamaño: " + miBMP.getTamanyo());
            System.out.println("Compresión: " + miBMP.getCompresion());
            miBMP.cerrarArchivo();
        } else {
            System.out.println("Error al abrir el archivo");
        }


    }
}