package cat.gestorincidencias.model.repositori;

import java.util.List;
import cat.gestorincidencias.model.incidencies.Incidencia;

public interface RepositoriIncidencies {
    List<Incidencia> carregar();

    public void guardar(List<Incidencia> incidencies);
}
