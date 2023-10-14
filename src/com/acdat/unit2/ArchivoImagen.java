package com.acdat.unit2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArchivoImagen {
    private String imageFileName;

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public ArchivoImagen(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public ArchivoImagen () {
        this.imageFileName = "";
    }

    public String getFormato () throws IOException {
        String strFormato = "";
        byte[] header = new byte[6];

        try {
            FileInputStream myFile = new FileInputStream(this.imageFileName);
            myFile.read(header);
            if (header[0] == (byte) 0x42 &&
                    header[1] == (byte) 0x4D
            ) {
                strFormato = "Formato detectado: BMP.";
            } else if (header[0] == (byte) 0x47 &&
                    header[1] == (byte) 0x49 &&
                    header[2] == (byte) 0x46 &&
                    header[3] == (byte) 0x38 &&
                    header[5] == (byte) 0x61 &&
                    (header[4] == (byte) 0x39 || header[4] == (byte) 0x37)
            ) {
                strFormato = "Formato detectado: GIF.";
            } else if (header[0] == (byte) 0xFF &&
                    header[1] == (byte) 0xD8 &&
                    header[2] == (byte) 0xFF
            ) {
                strFormato = "Formato detectado: JPG.";
            } else if (header[0] == (byte) 0x89 &&
                    header[1] == (byte) 0x50 &&
                    header[2] == (byte) 0x4E &&
                    header[3] == (byte) 0x47
            ) {
                strFormato = "Formato detectado: PNG.";
            } else {
                strFormato = "Formato no detectado.";
            }
        } catch ( IOException e) {
            strFormato = "No se pudo abrir " + imageFileName + ": " + e.getMessage();
    }
        return strFormato;
    }
}
