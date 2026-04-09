package Presentacion;
import excepciones.ProductoD;
import excepciones.ProductoNE;
import Entidades.Producto;
import Logica.Logica;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {

    Logica service = new Logica();

    while(true){

        try {

            String opcion = JOptionPane.showInputDialog(
                    "SISTEMA INVENTARIO\n" +
                    "1. Registrar Producto\n" +
                    "2. Buscar Producto\n" +
                    "3. Actualizar Cantidad\n" +
                    "4. Eliminar Producto\n" +
                    "5. Salir"
            );

            switch(opcion){

                case "1":

                    String id = JOptionPane.showInputDialog("ID:");
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    int cantidad = Integer.parseInt(
                            JOptionPane.showInputDialog("Cantidad:")
                    );
                    double precio = Double.parseDouble(
                            JOptionPane.showInputDialog("Precio:")
                    );

                    Producto p = new Producto(id,nombre,cantidad,precio);
                    try {

    service.registrarProducto(p);

    JOptionPane.showMessageDialog(null,"Producto registrado");

} catch (ProductoD e) {

    JOptionPane.showMessageDialog(null,"El producto ya existe");

}

                    

                break;

                case "2":

                    id = JOptionPane.showInputDialog("ID a buscar");

                    Producto encontrado = service.buscarProducto(id);

                    if(encontrado != null){
                        JOptionPane.showMessageDialog(null,
                                "Nombre: "+encontrado.getNombre()+
                                "\nCantidad: "+encontrado.getCantidad()+
                                "\nPrecio: "+encontrado.getPrecio());
                    }else{
                        JOptionPane.showMessageDialog(null,"No encontrado");
                    }

                break;

                case "3":

                    id = JOptionPane.showInputDialog("ID producto");
                    int nuevaCantidad = Integer.parseInt(
                            JOptionPane.showInputDialog("Nueva cantidad")
                    );

                               try {

                service.actualizarCantidad(id,nuevaCantidad);
                JOptionPane.showMessageDialog(null,"Producto actualizado");

            } catch (ProductoNE e) {

    JOptionPane.showMessageDialog(null,"Producto no encontrado");

}
                break;

                case "4":

                    id = JOptionPane.showInputDialog("ID a eliminar");

                                    try {

                    service.eliminarProducto(id);
                    JOptionPane.showMessageDialog(null,"Producto eliminado");

                } catch (ProductoNE e) {

                    JOptionPane.showMessageDialog(null,"Producto no encontrado");

                }

                break;

                case "5":
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null,"Opción inválida");
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null,
                    "Error: debe ingresar un número válido.");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Ocurrió un error: " + e.getMessage());
        }
    }
}
}