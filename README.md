# Grup1_Gestor-de-incidencias
# Gestor d’Incidències de Ciberseguretat

## 1. Descripció del projecte

Aquest projecte té com a objectiu desenvolupar una aplicació en Java que simula un **gestor d’incidències de ciberseguretat**, similar a un mini-centre d'operacions de seguretat (Mini-SOC).

L’aplicació permet als usuaris que la facin servir crear, gestionar i fer un seguiment d’incidències relacionades amb problemes comuns de ciberseguretat, com ara podria ser el **phishing** i el **malware**, amb l’objectiu d’aplicar bones pràctiques de gestió i resposta a incidents.

## 2. Com executar el projecte

### Requisits

* Visual Studio Code amb l’extensió *Extension Pack for Java*

### Passos d’execució
   
1. Obrir el projecte amb Visual Studio Code.
2. Executar la classe `Main` situada a:

   projecte/src/cat/nomprojecte/app/Main.java

3. Utilitzar el menú per consola per interactuar amb l’aplicació.

Les incidències es guarden automàticament en un fitxer de text situat a:

projecte/resources/incidencies.txt

---

## 3. Arquitectura

### Arquitectura MVC

El projecte segueix el patró **Model-Vista-Controlador (MVC)**, separant clarament les responsabilitats:

* **Model**

  * Classes de domini com `Incidencia`, `IncidenciaPhishing` i `IncidenciaMalware`
  * Enums per a la gestió de gravetat i estat de les incidències
  * Persistència de dades mitjançant fitxers TXT
  * Lògica de negoci centralitzada en un servei

* **Vista**

  * Interfície d’usuari per consola
  * Mostra menús i informació a l’usuari
  * No gestiona dades directament

* **Controlador**

  * Rep les accions de la vista
  * Valida les dades introduïdes
  * Comunica la vista amb el model

### Estructura de paquets
```
cat.nomprojecte
├── app
├── controlador
├── model
│   ├── enums
│   ├── incidencies
│   ├── repositori
│   └── servei
└── vista
```
---

## 4. Funcionalitats principals

* Crear incidències de tipus phishing i malware
* Assignar incidències a una persona responsable
* Canviar l’estat d’una incidència
* Llistar totes les incidències existents
* Filtrar incidències per gravetat o per estat
* Guardar i carregar incidències des d’un fitxer de text
* Generació automàtica d’identificadors (ID)

---

## 5. Ús d’Intel·ligència Artificial

Durant el desenvolupament d'aquest projecte, s'ha utilitzat IA com a eina d'assistència per resoldre dubtes de programació i millorar la comprensió del codi.

Aspectes en els quals l'IA ha ajudat:

1.  Resolució d'errors
La IA ha ajudat a detectar errors en construciors i en variables no inicialitzades. A més a més, ha ajudat amb la millora de la gestió d'errors.  

2. Gestió de fitxers
També s'ha usat IA per la gestió de fitxers, ja que no hi havia coneixaments prèvis. Ens va explicar com utilitzar BufferedReader i BufferedWriter, ens va ensenyar com llegir línia per línia amb readLine(), ens va mostrar com gestionar excepcions amb IOException, ens va explicar el .equalsIgnoreCase() i com convertir una línia de text del fitxer en objecte incidencia. 

---

## 6. Limitacions i millores futures

En aquest projecte, s'han trobat diverses limitacions degudes principalment a la poca d'experiència prèvia amb alguns aspectes de la programació en Java.

La gestió de fitxers haa sigut un dels principals reptes, ja que no teníem coneixements previs sobre com llegir i escriure dades en fitxers de text. Això ha dificultat la implementació de la persistència de dades i ha requerit molta assistència per entendre conceptes. 

---

## Treball fet per:

Gisela Esteve, Sara Fíguls i Emma Rosendo