package programa;

/**
 * Esta clase es para crear trabajar con artículos
 *
 * @Author Javier Valladolid Luengo
 * @Version: 2024.04
 */
public class Articulo {

    // atributos ///////

    private static int productos = 1; //Contador de cuantos productos se han creado para darlen un código
    private int codigo;
    private String descripcion;
    private float precio_compra;
    private float precio_venta;
    private int stock; //Cantidad de artículos

    // metodos

    // constructor
    public Articulo(String descripcion, float precio_compra, float precio_venta, int stock) {
        this.codigo = productos;
        productos++;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock = stock;
    }

    // getter y setter
    public static int getProductos() {
        return productos;
    }
    public static void setProductos(int productos) {
        Articulo.productos = productos;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public float getPrecio_compra() {
        return precio_compra;
    }
    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }
    public float getPrecio_venta() {
        return precio_venta;
    }
    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    // to String
    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", precio_compra=" + precio_compra +
                ", precio_venta=" + precio_venta +
                ", stock=" + stock +
                '}';
    }

    // otros

    /**
     * Suma stock nuevo al que ya hay
     * @param cantidad
     */
    public void entrada(int cantidad){
        this.stock += cantidad;
    }

    /**
     * Resta stock al que ya hay comprobando que no baje de 0
     * @param cantidad
     */
    public void salida(int cantidad){
        if (cantidad > this.stock){
            System.out.println("No se puede sacar tanto, solo quedan "+this.stock);
        } else {
            this.stock -= cantidad;
        }
    }
}
