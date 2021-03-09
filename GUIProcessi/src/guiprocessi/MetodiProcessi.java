/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiprocessi;

/**
 *
 * @author PC
 */
public class MetodiProcessi {

    /**
     * Questo metodo carica randomicamente un array che ha un numero definito di
     * processi da caricare al suo interno
     *
     * @param array Array da caricare dato in input da caricare randomicamente
     */
    public static void RandomArray(double[] array) {
        //Carico randomicamente ogni posizione dell'array   
        for (int i = 0; i < array.length; i++) {
            array[i] = (double) (Math.random() * 100);
        }
    }

    /**
     * Questo metodo carica un array parallelo all'array contenente processi con
     * i corrispondenti tempi di elaborazione. Formula usata: TempoProcesso[] =
     * TempoProcessoPrecedente[i - 1] + TempoElaborazioneAccumulato[i - 1];
     *
     * @param arrayProcessi Array contenente processi caricati randomicamente
     * @param TempoProcessi Array da carica con i tempi di elaborazione di ogni
     * singolo processo
     */
    public void TempoElaborazione(double[] arrayProcessi, double[] TempoProcessi) {

        /*Il tempo di elaborazione del primo processo sarà zero perché non ci sono processi precedenti */
        TempoProcessi[0] = 0;

        //Il processo 1 dovrà attendere il completamento del processo 0 e basta
        TempoProcessi[1] = arrayProcessi[0];

        //Riempio ogni singola posizione dell'array con i tempi di elaborazione
        for (int i = 2; i < TempoProcessi.length; i++) {
            TempoProcessi[i] = arrayProcessi[i - 1] + TempoProcessi[i - 1];
        }
    }

    /**
     * Questo metodo calcola il tempo medio di elaborazione di tutti i processi.
     *
     * @param TempoProcessi Array contenente il tempo di elaborazione di ogni
     * singolo processo
     * @return il tempo medio di elaborazione
     */
    public double CalcoloTempoMedio(double[] TempoProcessi) {

        double tempomedio, sommatotale = 0;
        //Trovo la somma totale dei tempi di elaborazione dei processi
        for (int i = 0; i < TempoProcessi.length; i++) {
            sommatotale = sommatotale + TempoProcessi[i];
        }
        //Trovo la media dividendo la somma per il numero di processi
        tempomedio = sommatotale / TempoProcessi.length;
        return tempomedio;
    }

    /**
     * Questo metodo ordina l'array contenente i processi in ordine crescente di
     * peso di ogni singolo processo
     *
     * @param array Array contenente il peso di ogni singolo processo
     */
    public void SortArray(double[] array) {
        //Ordino l'array con un ciclo semplice, in cui se un processo più grande si trova prima di uno più piccolo, i due processi si invertono di posizione
        for (int j = 0; j < array.length - 1; j++) {

            if (array[j] > array[j + 1]) {

                double temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;

                j = -1;
            }

        }
    }
}
