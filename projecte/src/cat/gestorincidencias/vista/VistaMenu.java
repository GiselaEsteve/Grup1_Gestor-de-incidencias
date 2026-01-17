package cat.gestorincidencias.vista;

import java.util.Scanner;

import cat.gestorincidencias.controlador.ControladorIncidencies;
import cat.gestorincidencias.model.enums.EstatIncidencia;
import cat.gestorincidencias.model.enums.Gravetat;
import cat.gestorincidencias.model.incidencies.Incidencia;

public class VistaMenu {
    private final ControladorIncidencies controlador;
    private final VistaIncidencies vistaIncidencies;
    private final Scanner sc;

    public VistaMenu(ControladorIncidencies controlador) {
        this.controlador = controlador;
        this.vistaIncidencies = new VistaIncidencies();
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        boolean sortir = false;

        while (sortir == false) {
            mostrarMenu();

            String opcio = sc.nextLine();

            try {
                switch (opcio) {
                    case "1" -> crearIncidenciaPhishing();
                    case "2" -> crearIncidenciaMalware();
                    case "3" -> vistaIncidencies.mostrarLlista(controlador.llistar());
                    case "4" -> filtrarPerGravetat();
                    case "5" -> filtrarPerEstat();
                    case "6" -> assignarIncidencia();
                    case "7" -> canviarEstat();
                    case "0" -> {
                        controlador.desar();
                        vistaIncidencies.mostrarMissatge("Incidències guardades. Fins una altra!");
                        sortir = true;
                    }
                    default -> vistaIncidencies.mostrarError("Opció no vàlida.");
                }
            } catch (Exception e) {
                vistaIncidencies.mostrarError(e.getMessage());
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n===== GESTOR D'INCIDÈNCIES =====");
        System.out.println("1) Crear incidència PHISHING");
        System.out.println("2) Crear incidència MALWARE");
        System.out.println("3) Llistar incidències");
        System.out.println("4) Filtrar per gravetat");
        System.out.println("5) Filtrar per estat");
        System.out.println("6) Assignar incidència a una persona");
        System.out.println("7) Canviar estat d'una incidència");
        System.out.println("0) Guardar i sortir");
        System.out.print("Escull una opció: ");
    }

    private void crearIncidenciaPhishing() {
        System.out.print("Títol: ");
        String titol = sc.nextLine();

        System.out.print("Descripció: ");
        String desc = sc.nextLine();

        Gravetat g = llegirGravetat();

        System.out.print("URL sospitosa: ");
        String url = sc.nextLine();

        Incidencia creada = controlador.crearPhishing(titol, desc, g, url);
        vistaIncidencies.mostrarMissatge("Incidència creada amb ID " + creada.getId());
    }

    private void crearIncidenciaMalware() {
        System.out.print("Títol: ");
        String titol = sc.nextLine();

        System.out.print("Descripció: ");
        String desc = sc.nextLine();

        Gravetat g = llegirGravetat();

        System.out.print("Dispositiu afectat (ex: PC-01): ");
        String disp = sc.nextLine();

        Incidencia creada = controlador.crearMalware(titol, desc, g, disp);
        vistaIncidencies.mostrarMissatge("Incidència creada amb ID " + creada.getId());
    }

    private void filtrarPerGravetat() {
        Gravetat g = llegirGravetat();
        vistaIncidencies.mostrarLlista(controlador.filtrarPerGravetat(g));
    }

    private void filtrarPerEstat() {
        EstatIncidencia e = llegirEstat();
        vistaIncidencies.mostrarLlista(controlador.filtrarPerEstat(e));
    }

    private void assignarIncidencia() {
        int id = llegirInt("ID de la incidència: ");

        System.out.print("Nom de la persona: ");
        String nom = sc.nextLine();

        controlador.assignar(id, nom);
        vistaIncidencies.mostrarMissatge("Incidència assignada.");
    }

    private void canviarEstat() {
        int id = llegirInt("ID de la incidència: ");
        EstatIncidencia e = llegirEstat();
        controlador.canviarEstat(id, e);
        vistaIncidencies.mostrarMissatge("Estat actualitzat.");
    }

    private int llegirInt(String missatge) {
        while (true) {
            System.out.print(missatge);
            String txt = sc.nextLine();
            try {
                return Integer.parseInt(txt);
            } catch (NumberFormatException e) {
                System.out.println("Introdueix un número vàlid.");
            }
        }
    }

    private Gravetat llegirGravetat() {
        while (true) {
            System.out.print("Gravetat (BAIXA/MITJANA/ALTA/CRITICA): ");
            String txt = sc.nextLine().trim().toUpperCase();
            try {
                return Gravetat.valueOf(txt);
            } catch (Exception e) {
                System.out.println("Valor no vàlid.");
            }
        }
    }

    private EstatIncidencia llegirEstat() {
        while (true) {
            System.out.print("Estat (NOVA/EN_PROCES/RESOLTA/TANCADA): ");
            String txt = sc.nextLine();
            try {
                return EstatIncidencia.valueOf(txt);
            } catch (Exception e) {
                System.out.println("Valor no vàlid.");
            }
        }
    }
}
