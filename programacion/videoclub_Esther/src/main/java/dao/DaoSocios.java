package dao;

import dao.modelo.Socio;

import java.util.List;

public interface DaoSocios {
  boolean addSocio(Socio socio);

  List<Socio> getSocios();

  Socio getSocioPorNif(String nif);

  boolean deleteSocio(Socio socio);
}
