package dao.modelo;

public class Documental extends Producto{

  private FormatoPelicula formato;

  public Documental(String titulo, int cantidad, String genero, double valoracionMedia, FormatoPelicula formato) {
    super(titulo, cantidad, genero, valoracionMedia);
    this.formato = formato;
  }

  public FormatoPelicula getFormato(FormatoPelicula dvd) {
    return formato;
  }

  public void setFormato(FormatoPelicula formato) {
   this.formato = formato;

  }

  @Override
  public String toString() {
    return "Documental{" +
        "formato=" + formato +super.toString() +
        '}' ;
  }
}
