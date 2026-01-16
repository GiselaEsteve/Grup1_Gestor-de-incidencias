package cat.gestorincidencias.model.incidencies;

import cat.gestorincidencias.model.enums.Gravetat;

public class IncidenciaPhishing extends Incidencia{
    private String urlSospitosa;

    public IncidenciaPhishing(int id, String titol, String descripcio, Gravetat gravetat, String urlSospitosa) {
        super(id, titol, descripcio, gravetat);
        this.urlSospitosa = urlSospitosa;
    }

    public String getUrlString() {
        return urlSospitosa;
    }

    @Override
    public String accioRecomanada() {
        return "No facis clic a l'enllaç i avisa.";
    }

    @Override
    public String toString() {
        return super.toString() + "URL: " + urlSospitosa;
    }
}
