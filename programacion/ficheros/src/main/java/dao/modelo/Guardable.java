package dao.modelo;

public interface Guardable {

  String guardar();
  void cargar(String linea);
}
