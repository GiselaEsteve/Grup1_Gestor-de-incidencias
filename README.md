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

cat.nomprojecte
├── app
├── controlador
├── model
│   ├── enums
│   ├── incidencies
│   ├── repositori
│   └── servei
└── vista

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


---

## 6. Limitacions i millores futures

* 

---

## Treball fet per:

Gisela Esteve, Sara Figuls i Emma Rosendo
