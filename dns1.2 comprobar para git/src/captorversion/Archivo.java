/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captorversion;
import java.io.File;
import java.io.FileInputStream;
/**
 *
 * @author oswal
 */
public class Archivo {
    public byte[] leer(String direccion, int maximo) {
        FileInputStream fis = null;
        File file = new File(direccion);
        byte[] archivo = new byte[(int) file.length()];
        if (maximo == 0) {
            maximo = (int) file.length();
        }

        try {
            fis = new FileInputStream(file);
            fis.read(archivo, 0, maximo);
            fis.close();

        } catch (Exception e) {

        }

        return archivo;
    }
    
}
