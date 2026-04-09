package datos;

import Entidades.Producto;
import java.io.*;
import java.util.*;

public class DatosD {

    private final String archivo = "productos.txt";

    public List<Producto> obtenerTodos() {

        List<Producto> lista = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){

            String linea;

            while((linea = br.readLine()) != null){
                lista.add(Producto.fromFileString(linea));
            }

        }catch(Exception e){}

        return lista;
    }

    public void guardarTodos(List<Producto> productos){

        try(PrintWriter pw = new PrintWriter(new FileWriter(archivo))){

            for(Producto p : productos){
                pw.println(p.toFileString());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}