package dao;

import dao.modelo.Socio;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class DaoSocios implements DaoSociosI {

    private static Map<String, Socio> socios = new HashMap<>();

    // devuelve si se metio o no
    @Override
    public boolean addSocio(Socio socio) {
        boolean insertado = false;
        if (socios.get(socio.getNif()) == null) {
            DaoSocios.socios.put(socio.getNif(), socio);
            insertado = true;
        }

        return insertado;
    }


    @Override
    public List<Socio> getSocios() {
        return socios.values().stream().collect(Collectors.toList());
    }

    @Override
    public Socio getSocioPorNif(String nif) {
        return socios.get(nif);
    }

    @Override
    public boolean deleteSocio(Socio socio) {
        boolean borrado = false;
        if (socios.containsKey(socio.getNif())) {
            DaoSocios.socios.remove(socio.getNif());
            borrado = true;
        }
        return borrado;
    }

}
