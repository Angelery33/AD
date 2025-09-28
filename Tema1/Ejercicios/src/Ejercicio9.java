import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio9 {

    public boolean compararArchivos(String archivo1, String archivo2) {
        File f1 = new File(archivo1);
        File f2 = new File(archivo2);

        if (!f1.exists() || !f2.exists()) {
            System.out.println("Uno o ambos archivos no existen.");
            return false;
        }

        // Primero comparamos tamaños, si son distintos, no hace falta leerlos
        if (f1.length() != f2.length()) {
            System.out.println("Los archivos tienen distinto tamaño, por lo tanto son diferentes.");
            return false;
        }

        try (FileInputStream fis1 = new FileInputStream(f1);
             FileInputStream fis2 = new FileInputStream(f2)) {

            int byte1, byte2;
            while ((byte1 = fis1.read()) != -1) {
                byte2 = fis2.read();
                if (byte1 != byte2) {
                    System.out.println("Los archivos son diferentes.");
                    return false;
                }
            }

            System.out.println("Los archivos son iguales.");
            return true;

        } catch (IOException e) {
            System.out.println("Error al comparar archivos: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String archivo1 = "C:\\Users\\angel\\OneDrive\\Desktop\\Clase\\AccesoDatos\\Tema1\\Ejercicios\\src\\prueba1.txt";
        String archivo2 = "C:\\Users\\angel\\OneDrive\\Desktop\\Clase\\AccesoDatos\\Tema1\\Ejercicios\\src\\prueba.txt";

        // Verificamos si los archivos existen
        System.out.println("Archivo 1 existe: " + new File(archivo1).exists());
        System.out.println("Archivo 2 existe: " + new File(archivo2).exists());
        Ejercicio9 x = new Ejercicio9();
        x.compararArchivos("C:\\Users\\angel\\OneDrive\\Desktop\\Clase\\AccesoDatos\\Tema1\\Ejercicios" +
                "\\src\\prueba.txt", "C:\\Users\\angel\\OneDrive\\Desktop\\Clase\\AccesoDatos\\Tema1\\Ejercicios" +
                "\\src\\prueba.txt");

    }
}

