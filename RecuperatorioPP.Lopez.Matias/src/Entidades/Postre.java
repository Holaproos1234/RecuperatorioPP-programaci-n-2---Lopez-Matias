package Entidades;

public class Postre extends Producto implements IVendible{
    private TipoPostre tipoPostre;

    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre ) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }
    
    @Override
    public double getPrecioTotal() {
        double precioTotal = this.precio;
        
        switch (this.tipoPostre) {
            case TIRAMISU:
                precioTotal = this.precio * 1.20;
                break;
            case HELADO:
                precioTotal = this.precio * 1.15;
                break;
            case FLAN:
                precioTotal = this.precio * 1.10;
                break;
        }
        return precioTotal;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Tipo de postre: ").append(this.tipoPostre).append("\n");
        sb.append("Precio Total: $").append(this.getPrecioTotal());
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Postre)) {
            return false;
        }
        Postre otro = (Postre) obj;
        return this.tipoPostre == otro.tipoPostre;
    }
}
