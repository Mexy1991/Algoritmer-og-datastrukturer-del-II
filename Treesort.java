/* * * * * * * * * * * * * * 
* Forfattere:
* Josephine Søgaard Andersen, josea18@student.sdu.dk
* Josias Kure, joulr18@student.sdu.dk 
* Kasper Jonassen, kajon18@student.sdu.dk 
* * * * * * * * * * * * * */

import java.util.Scanner; 
import java.util.ArrayList;

public class Treesort{

     /*
     * Vi laver en ArrayList hvor vi sætter vores tal ind fra scanneren, hvor while-lækken indsætter en værdi ind på hver plads i arrayet.
     */
    public static void main(String[] args) {

        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextInt())
            listOfNumbers.add(scanner.nextInt());

        Dict dictonary = new DictBinTree();

      /*
       * Dette for-each loop kopierer alle elementer fra ListOfNumbers over i variablen number, 
	   * hvorefter den indsætter i dictionarien.
       */
        for (int number : listOfNumbers)
            dictonary.insert(number);

	  /*
       * Dette for-each loop kopierer alle elementer fra dictonary.orderedTraversal over i variablen number
	   * Derefter udskrives værdien i terminalen
       */
        for (int number : dictonary.orderedTraversal())
            System.out.println(number);
    }
}