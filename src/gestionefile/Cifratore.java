
package gestionefile;

import java.util.ArrayList;

/**
 *
 * @author Kristian Xoxe
 * @version 28/01/24
 */

/**
 * 
 * Questa classe serve per non istanziare il tutto 
 * sulla classe GestioneFile
 */

public class Cifratore {
    private  Matrice matrice;
    private ArrayList<Vigenere> quadranti = new ArrayList<Vigenere>();   
    public Cifratore(String verme){
    this.matrice = new Matrice(verme);
    Vigenere quadrante_1=new Vigenere(0,12,0,12,matrice);
     quadranti.add(quadrante_1);
    
    Vigenere quadrante_2=new Vigenere(0,12,12,26,matrice);
     quadranti.add(quadrante_2);
    
    Vigenere quadrante_3=new Vigenere(12,26,0,12,matrice);
     quadranti.add(quadrante_3);
    
    Vigenere quadrante_4=new Vigenere(12,26,12,26,matrice);
    quadranti.add(quadrante_4);

    for(Vigenere v:quadranti){
     Thread t= new Thread(v);
     t.start();
     try {
       t.join();
     }catch (InterruptedException ex) {
         System.err.println("Errore metodo join");
     }
    }  
    }
    public String cifra(String messaggio){
          String fraseCriptata=matrice.cifra(messaggio);
    
        return fraseCriptata;
    }
    
    public String decifra(String messaggio){
          String fraseCriptata=matrice.deCifra(messaggio);
    
        return fraseCriptata;
    }
}
