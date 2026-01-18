package cat.gestorincidencias.model.repositori;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cat.gestorincidencias.model.enums.EstatIncidencia;
import cat.gestorincidencias.model.enums.Gravetat;
import cat.gestorincidencias.model.incidencies.Incidencia;
import cat.gestorincidencias.model.incidencies.IncidenciaMalware;
import cat.gestorincidencias.model.incidencies.IncidenciaPhishing;

public class RepositoriFitxerIncidencies implements RepositoriIncidencies{
    private String rutaFitxer;

    public RepositoriFitxerIncidencies(String rutaFiter){
        if (rutaFitxer == null || rutaFitxer.isEmpty()){
            System.out.println("La ruta del fitxer no pot estar buida.");
            this.rutaFitxer = "projecte/resources/incidencies.txt";
        } else {
            this.rutaFitxer = rutaFitxer.trim();
        }
    }

    @Override
    public List<Incidencia> carregar() {
        List<Incidencia> llista = new ArrayList<>();
        File f = new File(rutaFitxer);

        if(!f.exists()) {
            return llista;
        }


        //AJUDA D'IA
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linia;

            // Saltem la primera línia
            br.readLine();

            while ((linia = br.readLine()) != null) {
                Incidencia inc = convertirLiniaAIncidencia(linia);
                if (inc != null) {
                    llista.add(inc);
                }
            }

        //Per si hi ha exepcions
        } catch (IOException e) {
            System.out.println("Error llegint el fitxer d'incidències: " + e.getMessage());
        }

        return llista;
    }
            
    @Override
    public void guardar(List<Incidencia> incidencies){
        File f = new File(rutaFitxer);

        //AJUDA D'IA
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write("# TIPUS;ID;TITOL;DESCRIPCIO;GRAVETAT;ESTAT;DATA_CREACIO;ASSIGNADA_A;EXTRA");
            bw.newLine();

            for (Incidencia inc : incidencies) {
                bw.write(toLinia(inc));
                bw.newLine();
            }

        //Per si hi ha exepcions
        } catch (IOException e) {
            System.out.println("Error guardant el fitxer d'incidències: " + e.getMessage());
        }
    }        

    private static String toLinia(Incidencia inc){
        String tipus;
        String extra;

        if (inc instanceof IncidenciaPhishing){
            tipus = "PHISHING";
            extra = ((IncidenciaPhishing) inc).getUrlString();
        } else if (inc instanceof IncidenciaMalware){
            tipus = "MALWARE";
            extra = ((IncidenciaMalware)inc).getDispositiuAfectat();
        } else{
            tipus = "ALTRE";
            extra = "-";
        }

        String assignada;
        if (inc.getAssignadaA() == null || inc.getAssignadaA().isEmpty()) {
            assignada = "-";
        } else {
            assignada = netejarText(inc.getAssignadaA());
        }

        //AJUDA D'IA
        //Crea una línia unint tots els camps amb ";"
        String linia = tipus + ";" + inc.getId() + ";" + netejarText(inc.getTitol()) + ";" + netejarText(inc.getDescripcio()) + ";" + inc.getGravetat().name() + ";" + inc.getEstat().name() + ";" + inc.getDataCreacio().toString() + ";" + assignada + ";" + netejarText(extra);
        
        return linia;
    }

    //Converteix una línia de text del fitxer en objecte Incidencia
    private static Incidencia convertirLiniaAIncidencia(String linia) {
        // Divideix la línia pels punts i coma (esperem 9 camps)
        String[] parts = linia.split(";", -1);
        
        // Si no té 9 camps, la línia no s'ha creat bé
        if (parts.length < 9) {
            return null;
        }

        // Extreu cada camp (AJUDA D'IA)
        String tipus = parts[0].trim();
        int id = Integer.parseInt(parts[1].trim());
        String titol = parts[2].trim();
        String descripcio = parts[3].trim();
        Gravetat gravetat = Gravetat.valueOf(parts[4].trim());
        EstatIncidencia estat = EstatIncidencia.valueOf(parts[5].trim());
        String assignadaA = parts[7].trim();
        String campExtra = parts[8].trim();

        // Crea l'objecte segons el tipus
        Incidencia incidencia;
        
        //AJUDA D'IA
        if (tipus.equalsIgnoreCase("PHISHING")) {
            incidencia = new IncidenciaPhishing(id, titol, descripcio, gravetat, campExtra);
        } else if (tipus.equalsIgnoreCase("MALWARE")) {
            incidencia = new IncidenciaMalware(id, titol, descripcio, gravetat, campExtra);
        } else {
            // Tipus desconegut, ignora aquesta línia
            return null;
        }

        // Restaura l'estat
        incidencia.canviarEstat(estat);

        // Restaura l'assignació
        if (!assignadaA.equals("-") && !assignadaA.isEmpty()) {
            incidencia.assignadaA(assignadaA);
            incidencia.canviarEstat(estat); // Torna a posar l'estat correcte
        }

        return incidencia;
    }

    //Neteja el text per evitar problemes amb el format del fitxer
    private static String netejarText(String text) {
        if (text == null) {
            return "-";
        }
        // Substitueix els ";" per "," per no trencar el format (AJUDA D'IA)
        return text.replace(";", ",").trim();
    }
}
