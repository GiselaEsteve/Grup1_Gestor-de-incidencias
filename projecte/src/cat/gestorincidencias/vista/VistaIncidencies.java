package cat.gestorincidencias.vista;

import java.util.List;

import cat.gestorincidencias.model.incidencies.Incidencia;

public class VistaIncidencies {
    public void mostrarIncidencia(Incidencia i) {
        System.out.println("----------------------------------------");
        System.out.println("ID: " + i.getId());
        System.out.println("Títol: " + i.getTitol());
        System.out.println("Descripció: " + i.getDescripcio());
        System.out.println("Gravetat: " + i.getGravetat());
        System.out.println("Estat: " + i.getEstat());
        
        if (i.getAssignadaA() == null) {
            System.out.println("Assignada a: -");
        } else {
            System.out.println("Assignada a: " + i.getAssignadaA());
        }

        System.out.println("Data: " + i.getDataCreacio());
        System.out.println("Acció recomanada: " + i.accioRecomanada());
        System.out.println("----------------------------------------");
    }

    public void mostrarLlista(List<Incidencia> llista) {
        // Comprova si la llista està buida
        if (llista == null || llista.isEmpty()) {
            System.out.println("No hi ha incidències per mostrar.");
            return;
        }

        // Mostra cada incidència de la llista
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
