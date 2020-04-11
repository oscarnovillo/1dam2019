package dao;

import javax.enterprise.inject.Produces;


public class DaoSociosProducer {



  public DaoSociosI getDaoSociosI(){
    return new DaoSocios();
  }

}
