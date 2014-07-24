package aplicacion.Pedido;

/**
 *
 * @author Imprenta Laurita
 */
public class TCatalogo {

    private int idcatalogo;
    private String descripcion;
    private String imagen;

    public TCatalogo() {
    }

    public TCatalogo(int idcatalogo, String descripcion, String imagen) {
        this.idcatalogo = idcatalogo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public int getIdcatalogo() {
        return idcatalogo;
    }

    public void setIdcatalogo(int idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
