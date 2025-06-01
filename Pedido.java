package inicio;
import java.util.ArrayList;

public class Pedido {
    private int id;                       
    private ArrayList<Producto> listaProductos  = new ArrayList<>();

    public Pedido(int id) {
        this.id = id;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : listaProductos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void mostrarPedido() {
        System.out.println("Pedido ID: " + id);
        System.out.println("Artículos:");
        for (Producto producto: listaProductos) {
            System.out.println(producto.getNombre() + " ($" + producto.getPrecio() + ")");
        }
        System.out.println("Total: $" + calcularTotal());
    }

    public int getId() {
        return id;
    }

    // Getter para la lista de artículos
    public ArrayList<Producto> getProductos() {
        return listaProductos;
    }    
}
