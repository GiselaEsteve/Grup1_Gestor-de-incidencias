package cat.gestorincidencias.controlador;

import java.util.List;

import cat.gestorincidencias.model.enums.EstatIncidencia;
import cat.gestorincidencias.model.enums.Gravetat;
import cat.gestorincidencias.model.incidencies.Incidencia;
import cat.gestorincidencias.model.servei.ServeiIncidencies;

public class ControladorIncidencies {
    private final ServeiIncidencies servei;

    public ControladorIncidencies(ServeiIncidencies servei) {
        if (servei == null) {
            System.out.println("ERROR: El servei no pot ser null.");
        }
        this.servei = servei;
    }

    public Incidencia crearPhishing(String titol, String descripcio, Gravetat gravetat, String urlSospitosa) {
        return servei.crearIncidenciaPhishing(titol, descripcio, gravetat, urlSospitosa);
    }

    public Incidencia crearMalware(String titol, String descripcio, Gravetat gravetat, String dispositiuAfectat) {
        return servei.crearIncidenciaMalware(titol, descripcio, gravetat, dispositiuAfectat);
    }

    public List<Incidencia> llistar() {
        return servei.llistarTotes();
    }

    public List<Incidencia> filtrarPerGravetat(Gravetat g) {
        return servei.filtrarPerGravetat(g);
    }

    public List<Incidencia> filtrarPerEstat(EstatIncidencia e) {
        return servei.filtrarPerEstat(e);
    }

    public void assignar(int id, String nom) {
        servei.assignarIncidencia(id, nom);
    }

    public void canviarEstat(int id, EstatIncidencia e) {
        servei.canviarEstat(id, e);
    }

    public Incidencia buscarPerId(int id) {
        return servei.buscarPerId(id);
    }

    public void desar() {
        servei.desar();
    }
}
