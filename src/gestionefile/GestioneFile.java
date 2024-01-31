package gestionefile;

import java.io.*;

/**
 *
 * @author Kristian Xoxe
 * @version 28/01/24
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        try {
            lettore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        } 
       

        //2)ELABORAZIONE
        String username = null;
        String password = null;
       
        try( BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Inserisci l'username");
            username = br.readLine().toUpperCase();  // Legge una riga dall'input
            System.out.println("Inserisci la password");
             password = br.readLine().toUpperCase(); // Legge una riga dall'input
        } catch (IOException e) {
            System.err.println("Errore durante la lettura dell'input: " + e.getMessage());
        }
        
        //Istanzio un Cifratore
        Cifratore cifratore=new Cifratore("MARZO");
        String passwordCifrata = cifratore.cifra(password);
      
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username + ";" + passwordCifrata);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
         try {
            threadScrittore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        } 
         
         //Copiatura
        
          Copiatore copiatore = new Copiatore("output.csv","copia.csv");
        copiatore.start();
        try {
            copiatore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        }
        
        
        
        
        
    }
    
}

