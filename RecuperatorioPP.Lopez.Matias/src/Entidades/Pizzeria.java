package Entidades;

import java.util.ArrayList;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto>{
    private String nombre;
    private int capacidad;
    
    private ArrayList<Producto> productos;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }
    
    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }
    
    private boolean sonIguales(Producto p) {
        for (Producto producto : this.productos) {
            if (Producto.sonIguales(producto, p)) {
                return true;
            }
        }
        return false;
    }
    
    public void agregar(Producto p) {
        if (this.productos.size() >= this.capacidad) {
            System.out.println("No hay capacidad para agregar mas productos");
            return;
        }
        
        if (this.sonIguales(p)) {
            System.out.println("El producto ya se encuentra en la pizzeria");
            return;
        }
        
        this.productos.add(p);
        System.out.println("Producto agregado exitosamente");
    }
    
    private double getPrecioProductos(TipoProducto tipo) {
        double total = 0.0;
        
        switch (tipo) {
            case PIZZAS:
                total = this.getPrecioDePizzas();
                break;
            case POSTRES:
                total = this.getPrecioDePostres();
                break;
            case TODOS:
                total = this.getPrecioTotal();
                break;
        }
        
        return total;
    }
    
    private double getPrecioDePizzas() {
        double total = 0.0;
        
        for (Producto producto : this.productos) {
            if (producto instanceof Pizza) {
                Pizza helado = (Pizza) producto;
                total += helado.getPrecioTotal();
            }
        }
        
        return total;
    }
    
    private double getPrecioDePostres() {
        double total = 0.0;
        
        for (Producto producto : this.productos) {
            if (producto instanceof Postre) {
                Postre postre = (Postre) producto;
                total += postre.getPrecioTotal();
            }
        }
        
        return total;
    }
    
    private double getPrecioTotal() {
        return this.getPrecioDePizzas() + this.getPrecioDePostres();
    }
    
    @Override
    public Iterator<Producto> iterator() {
        return productos.iterator();
    }
    
    @Override
    public String toString() {
        this.iterator();
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== PIZZERIA ===\n");
        sb.append("Cantidad de productos: ").append(this.productos.size()).append("\n\n");
        sb.append("PRODUCTOS:\n");
        sb.append("--------------------\n");
        
        for (Producto producto : this.productos) {
            sb.append(producto.toString()).append("\n");
            sb.append("--------------------\n");
        }
        
        sb.append("\nPRECIOS TOTALES:\n");
        sb.append("Pizzas: $").append(this.getPrecioDePizzas()).append("\n");
        sb.append("Postres: $").append(this.getPrecioDePostres()).append("\n");
        sb.append("TOTAL: $").append(this.getPrecioTotal());
        
        return sb.toString();
    }
}
