package cat.gestorincidencias.model.incidencies;

import java.util.Date;

import cat.gestorincidencias.model.enums.EstatIncidencia;
import cat.gestorincidencias.model.enums.Gravetat;

public abstract class Incidencia {
    private int id;
    private String titol;
    private String descripcio;
    private Gravetat gravetat;
    private EstatIncidencia estat;
    private Date dataCreacio;
    private String assignadaA;

    public Incidencia(int id, String titol, String descripcio, Gravetat gravetat) {
        this.id = id;
        this.titol = titol;
        this.descripcio = descripcio;
        this.gravetat = gravetat;
        this.estat = EstatIncidencia.NOVA;
        this.dataCreacio = new Date();
        this.assignadaA = "";
    }

    public void assignadaA(String nom) {
        this.assignadaA = nom;
        if (estat == EstatIncidencia.NOVA) {
            estat = EstatIncidencia.EN_PROCES;
        }
    }

    public void canviarEstat(EstatIncidencia nouEstat) {
        this.estat = nouEstat;
    }

    public abstract String accioRecomanada();

    public int getId() {
        return id;
    }

    public String getTitol() {
        return titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public Gravetat getGravetat() {
        return gravetat;
    }

    public EstatIncidencia getEstat() {
        return estat;
    }

    public Date getDataCreacio() {
        return dataCreacio;
    }

    public String getAssignadaA() {
        return assignadaA;
    }

    @Override
    public String toString() {
        return "Incidencia{id=" + id + ", titol='" + titol + "'" + ", gravetat=" + gravetat + ", estat=" + estat + ", assignadaA=" + assignadaA + ", dataCreacio=" + dataCreacio + "}";
    }
}
