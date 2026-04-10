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
                    null,
                    "SISTEMA INVENTARIO\n" +
                    "1. Registrar Producto\n" +
                    "2. Buscar Producto\n" +
                    "3. Actualizar Cantidad\n" +
                    "4. Eliminar Producto\n" +
                    "5. Salir",
                    "Menú Inventario",
                    JOptionPane.QUESTION_MESSAGE
            );

            switch(opcion){

                case "1":

                    String id = JOptionPane.showInputDialog(null,"ID:");
                    String nombre = JOptionPane.showInputDialog(null,"Nombre:");
                    int cantidad = Integer.parseInt(
                            JOptionPane.showInputDialog(null,"Cantidad:")
                    );
                    double precio = Double.parseDouble(
                            JOptionPane.showInputDialog(null,"Precio:")
                    );

                    Producto p = new Producto(id,nombre,cantidad,precio);

                    try {

                        service.registrarProducto(p);

                        JOptionPane.showMessageDialog(
                                null,
                                "Producto registrado",
                                "Registro exitoso",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                    } catch (ProductoD e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "El producto ya existe",
                                "Producto duplicado",
                                JOptionPane.WARNING_MESSAGE
                        );

                    }

                break;

                case "2":

                    id = JOptionPane.showInputDialog(null,"ID a buscar");

                    Producto encontrado = service.buscarProducto(id);

                    if(encontrado != null){
                        JOptionPane.showMessageDialog(
                                null,
                                "Nombre: "+encontrado.getNombre()+
                                "\nCantidad: "+encontrado.getCantidad()+
                                "\nPrecio: "+encontrado.getPrecio(),
                                "Producto encontrado",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }else{
                        JOptionPane.showMessageDialog(
                                null,
                                "No encontrado",
                                "Búsqueda",
                                JOptionPane.WARNING_MESSAGE
                        );
                    }

                break;

                case "3":

                    id = JOptionPane.showInputDialog(null,"ID producto");
                    int nuevaCantidad = Integer.parseInt(
                            JOptionPane.showInputDialog(null,"Nueva cantidad")
                    );

                    try {

                        service.actualizarCantidad(id,nuevaCantidad);

                        JOptionPane.showMessageDialog(
                                null,
                                "Producto actualizado",
                                "Actualización exitosa",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                    } catch (ProductoNE e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Producto no encontrado",
                                "Error de actualización",
                                JOptionPane.WARNING_MESSAGE
                        );

                    }

                break;

                case "4":

                    id = JOptionPane.showInputDialog(null,"ID a eliminar");

                    try {

                        service.eliminarProducto(id);

                        JOptionPane.showMessageDialog(
                                null,
                                "Producto eliminado",
                                "Eliminación exitosa",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                    } catch (ProductoNE e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Producto no encontrado",
                                "Error de eliminación",
                                JOptionPane.WARNING_MESSAGE
                        );

                    }

                break;

                case "5":

                    JOptionPane.showMessageDialog(
                            null,
                            "Hasta luego, muchas gracias",
                            "Sistema Inventario",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    JOptionPane.showMessageDialog(
                            null,
                            "Saliendo...",
                            "Sistema Inventario",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    System.exit(0);

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Opción inválida",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: debe ingresar un número válido.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ocurrió un error: " + e.getMessage(),
                    "Error del sistema",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
}