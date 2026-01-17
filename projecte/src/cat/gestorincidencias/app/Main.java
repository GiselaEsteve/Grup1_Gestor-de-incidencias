package cat.gestorincidencias.app;

import cat.gestorincidencias.controlador.ControladorIncidencies;
import cat.gestorincidencias.model.repositori.RepositoriFitxerIncidencies;
import cat.gestorincidencias.model.servei.ServeiIncidencies;
import cat.gestorincidencias.vista.VistaMenu;

public class Main {
    public static void main(String[] args) {
    
        String ruta = "projecte/resources/incidencies.txt";

            RepositoriFitxerIncidencies repositori = new RepositoriFitxerIncidencies(ruta);
            ServeiIncidencies servei = new ServeiIncidencies(repositori);
            ControladorIncidencies controlador = new ControladorIncidencies(servei);
            VistaMenu vista = new VistaMenu(controlador);

            vista.iniciar();
    }
}
