package cat.gestorincidencias.vista;

import java.util.List;
import cat.gestorincidencias.model.incidencies.Incidencia;

public class VistaIncidencies {

    public void mostrarIncidencia(Incidencia i) {
        System.out.println("----------------------------------------");
        System.out.println("ID: " + i.getId());
        System.out.println("Titol: " + i.getTitol());
        System.out.println("Descripcio: " + i.getDescripcio());
        System.out.println("Gravetat: " + i.getGravetat());
        System.out.println("Estat: " + i.getEstat());

        String assignada = (i.getAssignadaA() == null || i.getAssignadaA().isEmpty())
                ? "-"
                : i.getAssignadaA();
        System.out.println("Assignada a: " + assignada);

        System.out.println("Data: " + i.getDataCreacio());
        System.out.println("Accio recomanada: " + i.accioRecomanada());
        System.out.println("----------------------------------------");
    }

    public void mostrarLlista(List<Incidencia> llista) {
        if (llista == null || llista.isEmpty()) {
            System.out.println("No hi ha incidencies.");
            return;
        }

        for (Incidencia i : llista) {
            mostrarIncidencia(i);
        }
    }

    public void mostrarMissatge(String msg) {
        System.out.println(msg);
    }

    public void mostrarError(String msg) {
        System.out.println("ERROR: " + msg);
    }
}

