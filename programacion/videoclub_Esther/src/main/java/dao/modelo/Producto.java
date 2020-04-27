package dao.modelo;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Producto {

    private String titulo;
    private List<Encuesta> encuestas;
    @Positive
    private int cantidad;
    private int cantidadAlquilada;
    private String genero;
    private double valoracionMedia;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Producto producto = (Producto) o;
        return getCantidad() == producto.getCantidad() &&
            getCantidadAlquilada() == producto.getCantidadAlquilada() &&
            Objects.equals(getTitulo(), producto.getTitulo()) &&
            Objects.equals(getGenero(), producto.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getCantidad(), getCantidadAlquilada(), getGenero());
    }

    public Producto(String titulo, int cantidad, String genero) {
        this();
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.genero = genero;
    }

    public Producto() {
        encuestas = new ArrayList<>();
        this.cantidadAlquilada = 0;
        this.valoracionMedia = 0;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", cantidad=" + cantidad +
                ", cantidadAlquilada=" + cantidadAlquilada +
                ", cantidadDisponible=" + (cantidad - cantidadAlquilada) +
                ", genero='" + genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;
    }

    public int getCantidadAlquilada() {
        return cantidadAlquilada;
    }

    public void setCantidadAlquilada(int cantidadAlquilada) {
        this.cantidadAlquilada = cantidadAlquilada;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(double valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }
}
