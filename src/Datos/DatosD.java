package datos;

import Entidades.Producto;
import java.io.*;
import java.util.*;

public class DatosD {

    private final String archivo = "productos.txt";

    public List<Producto> obtenerTodos() throws IOException {

        List<Producto> lista = new ArrayList<>();

        File file = new File(archivo);

        if(!file.exists()){
            file.createNewFile();
        }

        BufferedReader br = new BufferedReader(new FileReader(file));

        String linea;

        while((linea = br.readLine()) != null){
            lista.add(Producto.fromFileString(linea));
        }

        br.close();

        return lista;
    }

    public void guardarTodos(List<Producto> productos) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter(archivo));

        for(Producto p : productos){
            pw.println(p.toFileString());
        }

        pw.close();
    }

}