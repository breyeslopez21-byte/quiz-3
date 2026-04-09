package Logica;

import datos.DatosD;
import Entidades.Producto;
import java.util.*;

public class Logica {

    private DatosD dao = new DatosD();

    public boolean registrarProducto(Producto nuevo){

        List<Producto> productos = dao.obtenerTodos();

        for(Producto p : productos){
            if(p.getId().equals(nuevo.getId())){
                return false;
            }
        }

        productos.add(nuevo);
        dao.guardarTodos(productos);
        return true;
    }

    public Producto buscarProducto(String id){

        List<Producto> productos = dao.obtenerTodos();

        for(Producto p : productos){
            if(p.getId().equals(id)){
                return p;
            }
        }

        return null;
    }

    public boolean eliminarProducto(String id){

        List<Producto> productos = dao.obtenerTodos();

        boolean eliminado = productos.removeIf(p -> p.getId().equals(id));

        if(eliminado){
            dao.guardarTodos(productos);
        }

        return eliminado;
    }

    public boolean actualizarCantidad(String id, int nuevaCantidad){

        List<Producto> productos = dao.obtenerTodos();

        for(Producto p : productos){
            if(p.getId().equals(id)){
                p.setCantidad(nuevaCantidad);
                dao.guardarTodos(productos);
                return true;
            }
        }

        return false;
    }

    public boolean actualizarPrecio(String id, double precio){

        List<Producto> productos = dao.obtenerTodos();

        for(Producto p : productos){
            if(p.getId().equals(id)){
                p.setPrecio(precio);
                dao.guardarTodos(productos);
                return true;
            }
        }

        return false;
    }
}
