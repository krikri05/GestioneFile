package gestionefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kristian Xoxe
 * @version 28/01/24
 */

public class Scrittore implements Runnable{

    String nomeFile;
    String messaggio;
    
    public Scrittore(String nomeFile,String messaggio){
        this.nomeFile = nomeFile;
        this.messaggio = messaggio;
    }

    
    @Override
    public void run() {
        scrivi();
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi(){
        //1) apro il file
        try(BufferedWriter br=new BufferedWriter(new FileWriter(nomeFile))) {
            //2) scrivo nel buffer
            br.write(messaggio);
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}