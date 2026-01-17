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
    private final RepositoriIncidencies repositori;
    private final List<Incidencia> incidencies;

    public ServeiIncidencies(RepositoriIncidencies repositori) {
        if (repositori == null) {
            System.out.println("ERROR: El repositori no pot ser null.");
        }
        this.repositori = repositori;
        this.incidencies = new ArrayList<>(repositori.carregar());
    }

    private int seguentId() {
        int max = 0;
        for (Incidencia i : incidencies) {
            if (i.getId() > max) max = i.getId();
        }
        return max + 1;
    }

    public Incidencia crearIncidenciaPhishing(String titol, String descripcio, Gravetat gravetat, String urlSospitosa) {
        int id = seguentId();
        Incidencia inc = new IncidenciaPhishing(id, titol, descripcio, gravetat, urlSospitosa);
        incidencies.add(inc);
        return inc;
    }

    public Incidencia crearIncidenciaMalware(String titol, String descripcio, Gravetat gravetat, String dispositiuAfectat) {
        int id = seguentId();
        Incidencia inc = new IncidenciaMalware(id, titol, descripcio, gravetat, dispositiuAfectat);
        incidencies.add(inc);
        return inc;
    }

    public List<Incidencia> llistarTotes() {
        return new ArrayList<>(incidencies);
    }

    public List<Incidencia> filtrarPerGravetat(Gravetat g) {
        if (g == null) {
            System.out.println("ERROR: La gravetat no pot ser null.");
            return new ArrayList<>();
        }
        List<Incidencia> res = new ArrayList<>();
        for (Incidencia i : incidencies) {
            if (i.getGravetat() == g) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Incidencia> filtrarPerEstat(EstatIncidencia e) {
        if (e == null) {
            System.out.println("ERROR: L'estat no pot ser null.");
            return new ArrayList<>();
        }
        List<Incidencia> res = new ArrayList<>();
        for (Incidencia i : incidencies) {
            if (i.getEstat() == e) {
                res.add(i);
            }
        }
        return res;
    }

    public void assignarIncidencia(int id, String nom) {
        Incidencia inc = buscarPerId(id);
        if (inc == null) {
            System.out.println("ERROR: No existeix cap incidència amb id " + id);
            return;
        }
        inc.assignadaA(nom);
    }

    public void canviarEstat(int id, EstatIncidencia nouEstat) {
        Incidencia inc = buscarPerId(id);
        if (inc == null) {
            System.out.println("ERROR: No existeix cap incidència amb id " + id);
            return;
        }
        inc.canviarEstat(nouEstat);
    }

    public Incidencia buscarPerId(int id) {
        for (Incidencia i : incidencies) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void desar() {
        repositori.guardar(incidencies);
    }
}
