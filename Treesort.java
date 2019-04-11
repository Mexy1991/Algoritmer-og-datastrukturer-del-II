/* * * * * * * * * * * * * * 
* Forfattere:
* Josephine S�gaard Andersen, josea18@student.sdu.dk
* Josias Kure, joulr18@student.sdu.dk 
* Kasper Jonassen, kajon18@student.sdu.dk 
* * * * * * * * * * * * * */

import java.util.Scanner; 
import java.util.ArrayList;

public class Treesort{

     /*
     * Vi laver en ArrayList hvor vi s�tter vores tal ind fra scanneren, hvor while-l�kken inds�tter en v�rdi ind p� hver plads i arrayet.
     */
    public static void main(String[] args) {

        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextInt())
            listOfNumbers.add(scanner.nextInt());

        Dict dictonary = new DictBinTree();

      /*
       * Dette for-each loop kopierer alle elementer fra ListOfNumbers over i variablen number, 
	   * hvorefter den inds�tter i dictionarien.
       */
        for (int number : listOfNumbers)
            dictonary.insert(number);

	  /*
       * Dette for-each loop kopierer alle elementer fra dictonary.orderedTraversal over i variablen number
	   * Derefter udskrives v�rdien i terminalen
       */
        for (int number : dictonary.orderedTraversal())
            System.out.println(number);
    }
}