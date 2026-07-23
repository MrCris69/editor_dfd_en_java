package core.controlador;

import core.modelo.BloqueBase;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modulos.datos.TraductorDatos;
import modulos.control.TraductorControl;
import modulos.ciclos.TraductorCiclos;

public class GestorFicheros {

    public static void guardar(File archivo, List<BloqueBase> bloques) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (BloqueBase b : bloques) {
                bw.write(b.guardarDatosFichero());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static List<BloqueBase> cargar(File archivo) {
        List<BloqueBase> recuperados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                BloqueBase b = TraductorDatos.reconstruirDesdeFichero(linea);
                if (b == null) b = TraductorControl.reconstruirDesdeFichero(linea);
                if (b == null) b = TraductorCiclos.reconstruirDesdeFichero(linea);
                
                if (b != null) recuperados.add(b);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
        return recuperados;
    }
}