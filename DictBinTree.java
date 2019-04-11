/* * * * * * * * * * * * * * 
* Forfattere:
* Josephine Søgaard Andersen, josea18@student.sdu.dk
* Josias Kure, joulr18@student.sdu.dk 
* Kasper Jonassen, kajon18@student.sdu.dk 
* * * * * * * * * * * * * */

/*
 * Her bliver de forskellige variabler deklareret. 
 */
public class DictBinTree implements Dict{
	Node root;
	int size;
	int[] array;
	int i;

	/*
	 * Contructoren hvor der bliver lavet et ny dictionary, der er tomt og 
	 * hvor størrelsen er lig med 0.
	 */
	public DictBinTree(){
		this.root = null;
		this.size = 0;
	}

	/* 
	 * Metoden forudsætter at x ikke er lig med null. Herefter tager metoden først det venstre step, 
	 * hvor den sætter x.key til at være lig array[i], så vi gemmer vores x.key i arrayet.
	 * Herefter tælles i én op og vælger højre siden.
	 */
	public void treeWalk(Node x){
		if(x != null){
		treeWalk(x.left);
		array[i] = x.key;
		i++;
		treeWalk(x.right);
		}
	}

	/*
	 * Metoden løber igennem træet, startende ved roden, og returnerer elementets nøgle (k)
	 */
	public Node treeSearch(Node x, int k){
		if (x == null || k == x.key)
			return x;
		if (k < x.key)
			return treeSearch(x.left, k);
		else
			return treeSearch(x.right, k);
	}

	/*
	 * Metoden bruger metoden treeSearch til at tjekke om elementet k findes i vores træ. Herefter returnes enten sandt eller falsk
	 */
	public boolean search(int k){
		if(treeSearch(root, k) != null){
			return true;
			}
		return false;
	}

	/*
	 * Metoden returnerer en kopi af træets elementer i et array i sorteret orden 
	 */
	public int[] orderedTraversal(){
		array = new int[size];
		i = 0;
		inOrderTreeWalk(root);
		return array;
	}

	/*
	 * Metoden treeInsert indsætter træet T med nøglen z i træets dictionary
	 */
	public void treeInsert(Node T, Node z){
		Node y = null;
		Node x = root;

		while (x != null){
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}

		/* 
		* Hvis noden er tom, sætter vi z til at være roden. Hvis noden ikke er tom
		* placeres z afhængigt af værdien.
		*/
		if (y == null)
			root = z ;
		else if (z.key < y.key)
			y.left = z;
		else
			y.right = z;
	}
 
 	/*
	 * Her bruges metoden treeInsert til at tælle size op hver gang der er
	 * indsat et element i træet
	 */
	public void insert(int k){ 
		treeInsert(root, new Node(k));
		size++;
	}


	/*
	 * Metoden krydser hver knude i træet rekrusivt. hvorefter den tæller i en op.
	 */
	public int[] inOrderTreeWalk(Node x){
		if (x != null){
			inOrderTreeWalk(x.left);
			array[i] = x.key;
			i++;
			inOrderTreeWalk(x.right);
		}
		return array;
	}

	class Node {
	/*
	 * Vi har lavet en separat klasse til at repræsentere de forskellige knuder.
	 */
		public int key;
		public Node left;
		public Node right;

		/*
		 * Her indsættes nøglen k i hver Node samt sætter højre og venstre del af træet til null.
	     */
		Node(int k){

		this.key = k;
		left = null;
		right = null;
		}
	}
}

