package  dao;

import dao.modelo.Socio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoSocios {

    private static Map<String, Socio> socios = new HashMap<>();

    // devuelve si se metio o no
    public boolean addSocio(Socio socio){
        boolean insertado = false;
        if (socios.get(socio.getNif()) == null) {
            DaoSocios.socios.put(socio.getNif(), socio);
            insertado = true;
        }

        return insertado;
    }

    public List<Socio> getTodosSocios(){
        List<Socio> o = null;
        return o;
    }

    public Socio getSocioPorNif(String nif)
    {
        return null;
    }

}
