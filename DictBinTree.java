/* * * * * * * * * * * * * * 
* Forfattere:
* Josephine S�gaard Andersen, josea18@student.sdu.dk
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
	 * hvor st�rrelsen er lig med 0.
	 */
	public DictBinTree(){
		this.root = null;
		this.size = 0;
	}

	/* 
	 * Metoden foruds�tter at x ikke er lig med null. Herefter tager metoden f�rst det venstre step, 
	 * hvor den s�tter x.key til at v�re lig array[i], s� vi gemmer vores x.key i arrayet.
	 * Herefter t�lles i �n op og v�lger h�jre siden.
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
	 * Metoden l�ber igennem tr�et, startende ved roden, og returnerer elementets n�gle (k)
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
	 * Metoden bruger metoden treeSearch til at tjekke om elementet k findes i vores tr�. Herefter returnes enten sandt eller falsk
	 */
	public boolean search(int k){
		if(treeSearch(root, k) != null){
			return true;
			}
		return false;
	}

	/*
	 * Metoden returnerer en kopi af tr�ets elementer i et array i sorteret orden 
	 */
	public int[] orderedTraversal(){
		array = new int[size];
		i = 0;
		inOrderTreeWalk(root);
		return array;
	}

	/*
	 * Metoden treeInsert inds�tter tr�et T med n�glen z i tr�ets dictionary
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
		* Hvis noden er tom, s�tter vi z til at v�re roden. Hvis noden ikke er tom
		* placeres z afh�ngigt af v�rdien.
		*/
		if (y == null)
			root = z ;
		else if (z.key < y.key)
			y.left = z;
		else
			y.right = z;
	}
 
 	/*
	 * Her bruges metoden treeInsert til at t�lle size op hver gang der er
	 * indsat et element i tr�et
	 */
	public void insert(int k){ 
		treeInsert(root, new Node(k));
		size++;
	}


	/*
	 * Metoden krydser hver knude i tr�et rekrusivt. hvorefter den t�ller i en op.
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
	 * Vi har lavet en separat klasse til at repr�sentere de forskellige knuder.
	 */
		public int key;
		public Node left;
		public Node right;

		/*
		 * Her inds�ttes n�glen k i hver Node samt s�tter h�jre og venstre del af tr�et til null.
	     */
		Node(int k){

		this.key = k;
		left = null;
		right = null;
		}
	}
}

