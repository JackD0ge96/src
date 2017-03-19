package Phases;

/**
 * interfaccia per la Fase, ogni fase deve avere la funzione playFase che si
 * occuperà della gestione della fase. Più che altro è per poter mettere tutte
 * le fasi nella stessa struttura dati del GestoreFasi. Inoltre potebbe servire
 * come base per sviluppi futuri.
 */
public interface Fase {

    public void playFase();

}
