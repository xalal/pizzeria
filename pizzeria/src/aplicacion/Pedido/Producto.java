package aplicacion.Pedido;

import java.util.ArrayList;

/**
 *
 * @author Abimael
 */
public class Producto {

    public ArrayList getCatalogos() {
        FCatalogo func = new FCatalogo();
        ArrayList catalogos = func.buscarLista();

        return catalogos;
    }

    public ArrayList getProductos(String catalogo) {
        FProducto func = new FProducto();
        ArrayList productos = func.buscarLista(catalogo);

        return productos;
    }

    public double getPrecioProducto(String catalogo, String producto) {
        double precio = 0.0;

        FProducto func = new FProducto();
        precio = func.damePrecio(catalogo, producto);

        return precio;
    }
}
