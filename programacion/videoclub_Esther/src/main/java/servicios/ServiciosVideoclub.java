package servicios;

import config.Configuration;
import dao.DaoAlquileres;
import dao.DaoProductos;
import dao.DaoSocios;
import dao.DaoSociosI;
import dao.modelo.*;

import javax.inject.Inject;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.List;

public class ServiciosVideoclub {


    private DaoSocios daoSocios;

    // add socio
    public String addSocio(Socio socio) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        final StringBuilder error = new StringBuilder();
        validator.validate(socio).stream().forEach(bookConstraintViolation ->
            error.append(bookConstraintViolation.getMessage()));

        if (error.length() <= 0) {
            DaoSocios daoSocios = new DaoSocios();
            if (daoSocios.addSocio(socio))
            {
                return "";
            }
        }
        return error.toString();
    }

    // borrarSocio
    public boolean borrarSocio(String dni) {
        DaoSocios daoSocio = new DaoSocios();
        if (daoSocios.getSocioPorNif(dni) != null) {
            return daoSocios.deleteSocio(daoSocios.getSocioPorNif(dni));
        }
        return false;
    }

    public List<Socio> getSocios() {
        DaoSocios daoSocio = new DaoSocios();
        return daoSocio.getSocios();
    }

    public Socio getSocio(String nif) {
        DaoSocios daoSocio = new DaoSocios();
        return daoSocio.getSocioPorNif(nif);
    }

    public boolean addProducto(Producto producto) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.addProducto(producto);
    }

    public void actualizarStockProducto(Producto p, int cantidad) {
        p.setCantidad(p.getCantidad() + cantidad);
    }

    public boolean devolverProducto(String nifSocio, Encuesta e) {
        boolean devolucion = false;
        DaoAlquileres daoAlquileres = new DaoAlquileres();
        Alquiler alquiler = daoAlquileres.alquilerSocio(nifSocio);
        if (alquiler != null) {
            Producto producto = alquiler.getProductoAlquilado();
            producto.setCantidadAlquilada(producto.getCantidadAlquilada() - 1);

            //sancion --> comprobar si se pasa del tiempo
            int tiempoAlquiler;
            if (producto instanceof Documental) {
                tiempoAlquiler = Configuration.getDiasAlquilerPeliculas();
            } else {
                tiempoAlquiler = Configuration.getDiasAlquilerVideojuego();
            }
            LocalDateTime ld = LocalDateTime.now();
            if (!daoAlquileres.alquilerSocio(nifSocio).getFechaAlquiler().plusSeconds(tiempoAlquiler).isAfter(ld)) {
                daoAlquileres.alquilerSocio(nifSocio).getSocio().setSancionado(true);
            }
            devolucion = daoAlquileres.borrarAlquiler(daoAlquileres.alquilerSocio(nifSocio));
            //añadir encuesta a producto
            producto.getEncuestas().add(e);
        }
        return devolucion;
    }

    public String alquilarProducto(Producto p, String nifSocio) {
        String alquilado = null;
        DaoAlquileres daoAlquileres = new DaoAlquileres();
        DaoSocios daoSocios = new DaoSocios();
        if(daoSocios.getSocioPorNif(nifSocio) == null){
            alquilado = "Lo siento, pero aun no esta registrado.\n" +
                    "Debera primero registrarse para poder realizar un alquiler";
        } else if (daoSocios.getSocioPorNif(nifSocio).isSancionado()) {
            alquilado = "Esta sancionado proceda primero a pagar su multa.\n" +
                    "MUCHAS GRACIAS";
        }else if (daoAlquileres.alquilerSocio(nifSocio) != null) {
            alquilado = "Actualmente tiene un producto alquilado.\n" +
                    "Devuelvalo primero, por favor.";
        } else if ((p.getCantidad() - p.getCantidadAlquilada()) < 1) {
            alquilado = "Actualmente no tenemos este producto disponible.\n" +
                    "Disculpe las molestias";
        } else {
            p.setCantidadAlquilada(p.getCantidadAlquilada() + 1);
            LocalDateTime ld = LocalDateTime.now();
            Alquiler alquiler = new Alquiler(ld, daoSocios.getSocioPorNif(nifSocio), p);
            if(daoAlquileres.addAlquiler(alquiler)){
                alquilado = "Producto alquilado correctamente\n" +
                        "MUCHAS GRACIAS";
            }
        }
        return alquilado;
    }

    public List<Pelicula> getTodasPeliculas() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getTodasPeliculas();
    }

    public List<Documental> getTodosDocumentales() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getTodosDocumentales();
    }

    public List<Videojuego> getTodosVideoJuegos() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getTodosVideojuegos();
    }

}
