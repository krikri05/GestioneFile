package gestionefile;

/**
 *
 * @author Kristian Xoxe
 * @version 28/01/24
 */
public class Copiatore extends Thread {
    String nomeFileDaCopiare;
    String nomeFileFinale;
   
    
    public Copiatore(String nomeFileDaCopiare,String nomeFileFinale){
         this.nomeFileDaCopiare=nomeFileDaCopiare;
       this.nomeFileFinale=nomeFileFinale;
    }
    
    
    public void copia(){
        //1) Leggo il contenuto del file da copiare
        Lettore lettore = new Lettore(nomeFileDaCopiare);
        String contenuto=lettore.leggi();

        //2)Scrivo il contenuto del file copiato
        Scrittore scrittore = new Scrittore(nomeFileFinale,contenuto );
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
         try {
            threadScrittore.join();
        } catch (InterruptedException ex) {
            System.err.println("Errore nel metodo join()");
        } 
    }
    

    @Override
    public void run(){
        copia();
    }
}
