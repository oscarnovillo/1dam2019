package dao.modelo;

public class CasasArmarios {

  private int idCasa;
  private int idArmario;

  public CasasArmarios(int idCasa, int idArmario) {
    this.idCasa = idCasa;
    this.idArmario = idArmario;
  }

  public CasasArmarios() {
  }

  public int getIdCasa() {
    return idCasa;
  }

  public void setIdCasa(int idCasa) {
    this.idCasa = idCasa;
  }

  public int getIdArmario() {
    return idArmario;
  }

  public void setIdArmario(int idArmario) {
    this.idArmario = idArmario;
  }
}

