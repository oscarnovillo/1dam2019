package dao;

import dao.modelo.Socio;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;


public interface DaoSociosI {
  // devuelve si se metio o no
  boolean addSocio(Socio socio);

  List<Socio> getSocios();

  Socio getSocioPorNif(String nif);

  boolean deleteSocio(Socio socio);
}
