package Entidades;

public class Pizza extends Producto implements IVendible{
    private TipoPizza sabor;
    private TamanoPizza tamano;

    public Pizza(String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamanoPizza tamaño) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamano = tamaño;
    }

    @Override
    public double getPrecioTotal() {
        double precioTotal = this.precio;
        
        switch (this.tamano) {
            case CHICA:
                precioTotal = this.precio * 1.05;
                break;
            case MEDIANA:
                precioTotal = this.precio * 1.10;
                break;
            case GRANDE:
                precioTotal = this.precio * 1.20;
                break;
        }
        return precioTotal;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Tipo de pizza: ").append(this.sabor).append("\n");
        sb.append("Tamaño: ").append(this.tamano).append("\n");
        sb.append("Precio Total: $").append(this.getPrecioTotal());
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Pizza)) {
            return false;
        }
        Pizza otro = (Pizza) obj;
        return this.sabor == otro.sabor && this.tamano == otro.tamano;
    }
    
}
