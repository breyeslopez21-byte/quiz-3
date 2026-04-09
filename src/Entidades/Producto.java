package Entidades;

public class Producto {

    private String id;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String toFileString(){
        return id + "," + nombre + "," + cantidad + "," + precio;
    }

    public static Producto fromFileString(String linea){
        String[] datos = linea.split(",");
        return new Producto(
                datos[0],
                datos[1],
                Integer.parseInt(datos[2]),
                Double.parseDouble(datos[3])
        );
    }
}
