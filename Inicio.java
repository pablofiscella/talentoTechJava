package inicio;
import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static int contadorProductos = 0; // Contador para asignar IDs únicos a los artículos
    static Scanner escaner = new Scanner(System.in);

    public static void main(String[] args) {
        int seleccion = -1;
        
        String ingreso;
        do {
            System.out.println("\n====================================");
            System.out.println("          MENÚ DE ARTÍCULOS        ");
            System.out.println("====================================");
            System.out.println(" 1. Crear artículo");
            System.out.println(" 2. Listar artículos");
            System.out.println(" 3. Modificar artículo");
            System.out.println(" 4. Eliminar artículo");
            System.out.println(" 5. Consultar nombre del artículo");
            System.out.println(" 6. Salir");
            System.out.println("====================================");
            System.out.println("Seleccione una opción: ");

            ingreso = escaner.nextLine();
            seleccion = Integer.parseInt(ingreso);
            switch (seleccion) {
                case 1 -> crearProducto();
                case 2 -> listarProductos();
                case 3 -> modificarProductoPorID();
                case 4 -> eliminarProductoPorID();
                case 5 -> devolverProductoPorID();
                default -> System.out.println("\nIntente nuevamente.");
            }
        } while (seleccion != 6);
    }

    public static void crearProducto() {
        Producto producto;
        System.out.print("ID: ");
        int id = escaner.nextInt();
        escaner.nextLine();
        System.out.print("Precio: ");
        double precio = escaner.nextDouble();
        escaner.nextLine();          
        System.out.print("Nombre: ");
        String nombre = escaner.nextLine();            
        producto = new Producto(id, nombre, precio);
        listaProductos.add(producto);
    }

    public static void listarProductos() {
        if (!listaProductos.isEmpty()) {
            for (Producto producto : listaProductos) {
                System.out.println(producto.toString());
             }
         } else {
            System.out.println("\nNo hay Productos en la base");
        }
    }

    public static void modificarProductoPorID() {
        System.out.print("\nIngrese el ID del Producto: ");
        int id = escaner.nextInt();
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                escaner.nextLine();
                System.out.print("\nNombre: ");
                producto.setNombre(escaner.nextLine());
                System.out.print("Precio: ");
                producto.setPrecio(escaner.nextDouble());  
                escaner.nextLine();          
                return;
            }
        }
        System.out.println("\nArtículo no encontrado.");
    }

    public static void eliminarProductoPorID() {
        System.out.print("\nIngrese ID del producto: ");
        int id = escaner.nextInt();
        escaner.nextLine();
        listaProductos.removeIf(producto -> producto.getId() == id);
    }

    public static void devolverProductoPorID() {
        System.out.print("\nIngrese ID del producto: ");
        int id = escaner.nextInt();
        escaner.nextLine();
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                System.out.println("\nSe devolvio nombre del producto: " + producto.getNombre());
                return;
            }
        }
        System.out.println("\nNo existe el producto buscado.");
    }
}