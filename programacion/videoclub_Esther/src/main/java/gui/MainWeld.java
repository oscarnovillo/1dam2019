package gui;

import dao.modelo.Socio;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import servicios.ServiciosVideoclub;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

public class MainWeld {

  private static Weld weld ;
  private static WeldContainer container ;

  public static void main(String[] args) {
    SeContainerInitializer containerInit = SeContainerInitializer.newInstance();
    SeContainer container = containerInit.initialize();

    MainWeld main = container.select(MainWeld.class).get();
    main.start();

  }

  @Inject
  private ServiciosVideoclub sv;

  public void start()
  {
    sv.addSocio(new Socio("","","","",16));
  }
}
