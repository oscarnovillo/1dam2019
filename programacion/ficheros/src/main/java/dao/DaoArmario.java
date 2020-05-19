package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import config.Config;
import dao.modelo.Armario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoArmario {

  private ObjectMapper mapper;

  public DaoArmario() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  public void nuevoArmario(Armario a) {
    List<Armario> armarios = this.getTodosArmarios();
    if (armarios == null) {
      armarios = new ArrayList<>();
    }
    a.setId(armarios.stream().mapToInt(value -> value.getId()).max().getAsInt() + 1);
    armarios.add(a);
    this.guardarFichero(armarios);
  }



  public void editarArmario(Armario a) {
    List<Armario> armarios = this.getTodosArmarios();
    if (armarios == null) {
      armarios = new ArrayList<>();
    }
    armarios.remove(a);
    armarios.add(a);

    this.guardarFichero(armarios);
  }

  public void borrarArmario(Armario a) {
    List<Armario> armarios = this.getTodosArmarios();
    if (armarios == null) {
      armarios = new ArrayList<>();
    }
    armarios.remove(a);

    this.guardarFichero(armarios);
  }

  public Armario getArmario(int id) {
    List<Armario> armarios = this.getTodosArmarios();
    return armarios.stream().filter(armario -> armario.getId() == id)
        .findFirst().orElse(null);
  }

  public List<Armario> getAlgunosArmario(List<Integer> ids) {
    List<Armario> armarios = this.getTodosArmarios();
    return armarios.stream().filter(armario -> ids.contains(armario.getId()))
        .collect(Collectors.toList());
  }


  private void guardarFichero(List<Armario> armarios) {
    try {
      mapper.writeValue(Files.newOutputStream(Paths.get(Config.getInstance().getRutaFicheros() + Config.getInstance().getFicheroArmarios())), armarios);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Armario> getTodosArmarios() {
    try {
      return mapper.readValue(Files.newBufferedReader(
          Paths.get(Config.getInstance().getRutaFicheros() + Config.getInstance().getFicheroArmarios())),
          new TypeReference<ArrayList<Armario>>() {
          });
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


}
