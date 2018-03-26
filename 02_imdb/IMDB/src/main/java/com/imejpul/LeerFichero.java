package com.imejpul;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerFichero {

    public LeerFichero(String[][] matrizCampos) {
        extraerLineas();
        this.matrizCampos = matrizCampos;
    }

    private String[][] matrizCampos = new String[1000][5];

    public void extraerLineas() {

        try {

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream("IMDB/src/main/resources/IMDB-Movie-Data.csv"), "UTF-8")
            );

            // Leer línea a línea
            String linea;
            int i = 0;

            while ((linea = br.readLine()) != null) {

                String[] campos = linea.split(",");

                matrizCampos[i][0] = i + campos[0];

                matrizCampos[i][1] = i + campos[1];

                matrizCampos[i][2] = campos[6];

                matrizCampos[i][3] = campos[7];

                matrizCampos[i][4] = campos[8];

                i++;

            }

        } catch (IOException e) {
            System.err.println("ERROR: Error de E/S");
            System.err.println(e.getMessage());
        }
    }

    public String[][] getMatrizCampos() {
        return matrizCampos;
    }
}
