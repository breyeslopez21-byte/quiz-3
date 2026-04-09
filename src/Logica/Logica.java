package Logica;

import datos.DatosD;
import Entidades.Producto;
import excepciones.ProductoD;
import excepciones.ProductoNE;
import java.io.IOException;
import java.util.*;

public class Logica {

    private DatosD dao = new DatosD();

    public void registrarProducto(Producto nuevo)
            throws IOException, ProductoD{

        List<Producto> productos = dao.obtenerTodos();

        for(Producto p : productos){
            if(p.getId().equals(nuevo.getId())){
                throw new ProductoD("El producto ya existe");
            }
        }

        productos.add(nuevo);
        dao.guardarTodos(productos);
    }

    public Producto buscarProducto(String id)
            throws IOException, ProductoNE {

        List<Producto> productos = dao.obtenerTodos();

        for(Producto p : productos){
            if(p.getId().equals(id)){
                return p;
            }
        }

        throw new ProductoNE("Producto no encontrado");
    }

    public void eliminarProducto(String id)
            throws IOException, ProductoNE {

        List<Producto> productos = dao.obtenerTodos();

        boolean eliminado = productos.removeIf(p -> p.getId().equals(id));

        if(!eliminado){
            throw new ProductoNE("Producto no encontrado");
        }

        dao.guardarTodos(productos);
    }

    public void actualizarCantidad(String id, int cantidad)
            throws IOException, ProductoNE {

        List<Producto> productos = dao.obtenerTodos();

        boolean encontrado = false;

        for(Producto p : productos){
            if(p.getId().equals(id)){
                p.setCantidad(cantidad);
                encontrado = true;
            }
        }

        if(!encontrado){
            throw new ProductoNE("Producto no encontrado");
        }

        dao.guardarTodos(productos);
    }

}