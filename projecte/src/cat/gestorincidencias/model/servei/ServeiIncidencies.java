package cat.gestorincidencias.model.servei;

import java.util.ArrayList;
import java.util.List;

import cat.gestorincidencias.model.enums.EstatIncidencia;
import cat.gestorincidencias.model.enums.Gravetat;
import cat.gestorincidencias.model.incidencies.Incidencia;
import cat.gestorincidencias.model.incidencies.IncidenciaMalware;
import cat.gestorincidencias.model.incidencies.IncidenciaPhishing;
import cat.gestorincidencias.model.repositori.RepositoriIncidencies;

public class ServeiIncidencies {

    private RepositoriIncidencies repositori;
    private List<Incidencia> incidencies;

    public ServeiIncidencies(RepositoriIncidencies repositori) {
        this.repositori = repositori;
        this.incidencies = new ArrayList<>(repositori.carregar());
    }

    private int seguentId() {
        return incidencies.size() + 1;  // simple
    }

    public Incidencia crearIncidenciaPhishing(String titol, String descripcio, Gravetat gravetat, String urlSospitosa) {
        Incidencia inc = new IncidenciaPhishing(seguentId(), titol, descripcio, gravetat, urlSospitosa);
        incidencies.add(inc);
        return inc;
    }

    public Incidencia crearIncidenciaMalware(String titol, String descripcio, Gravetat gravetat, String dispositiuAfectat) {
        Incidencia inc = new IncidenciaMalware(seguentId(), titol, descripcio, gravetat, dispositiuAfectat);
        incidencies.add(inc);
        return inc;
    }

    public List<Incidencia> llistarTotes() {
        return incidencies;
    }

    public List<Incidencia> filtrarPerGravetat(Gravetat g) {
        List<Incidencia> res = new ArrayList<>();
        for (Incidencia i : incidencies) {
            if (i.getGravetat() == g) res.add(i);
        }
        return res;
    }

    public List<Incidencia> filtrarPerEstat(EstatIncidencia e) {
        List<Incidencia> res = new ArrayList<>();
        for (Incidencia i : incidencies) {
            if (i.getEstat() == e) res.add(i);
        }
        return res;
    }

    public void assignarIncidencia(int id, String nom) {
        Incidencia inc = buscarPerId(id);
        if (inc != null) inc.assignarA(nom); // FIX: assignarA
    }

    public void canviarEstat(int id, EstatIncidencia nouEstat) {
        Incidencia inc = buscarPerId(id);
        if (inc != null) inc.canviarEstat(nouEstat);
    }

    public Incidencia buscarPerId(int id) {
        for (Incidencia i : incidencies) {
            if (i.getId() == id) return i;
        }
        return null;
    }

    public void desar() {
        repositori.guardar(incidencies);
    }
}
