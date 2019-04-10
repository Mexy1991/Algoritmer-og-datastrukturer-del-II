public class DictBinTree implements Dict{
	Node root;
	int size;
	int[] array;
	int i;

	public DictBinTree(){
		this.root = null;
		this.size = 0;
	}

	public void TreeWalk(Node x){
		if(x != null){
		TreeWalk(x.left);
		array[i] = x.key;
		i++;
		TreeWalk(x.right);
		}
	}

	public Node TreeSearch(Node x, int k){
		if (x == null || k == x.key)
			return x;
		if (k < x.key)
			return TreeSearch(x.left, k);
		else
			return TreeSearch(x.right, k);
	}

	public boolean search(int k){
		if(TreeSearch(root, k) != null){
			return true;
			}
		return false;
	}

	public int[] orderedTraversal(){
	// Returnerer en kopi af trets elementer i et array i sorteret orden 
	//(fremfor at printe dem pa skærmen som i bogens pseudo-kode).
		array = new int[size];
		i = 0;
		inOrderTreeWalk(root);
		return array;
	}

	public void insert(int k){
		//Indsætter nøglen k i træet
		Node y = null;
		Node x = root;

		while (x != null){
			y = x;
			if(k < x.key)
				x = x.left;
			else
				x = x.right;
		}

		if(y == null){
			root.key = k;
			}
		else if (k < y.key){
			y.left = new Node(k);
		}
		else {
			y.right = new Node(k);
		}

		//root  = y.key;
		//k.parent = y.key;
		/*if(y == null)
			root.key = k; 
			//træet er tomt
		else if (k < y.key)
			y.left = new Node(k);
		else 
			y.right = new Node(k);

			*/
	}


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
		public int key;
		public Node left;
		public Node right;
   
    Node(int k){
        this.key = k;
		left = null;
		right = null;
		}
	}
}



/*
	public DictBinTree(){
		DictBinTree newTree = new DictBinTree();
	
	}


	public void insert(int k){
	//Indsætter nøglen k i træet

	int y = null;
	int x = T.root;
	while(x != null){
	y=x;
	if(z.key < x.key)
		x= x.left;	
	else
		x = x.right;
	}
	z.p = y;
	

	if (y==null)
		T.root = z; // tree T is empty
	else if(z.key < y.key)
		y.left = z;
	else 
		y.right=z;
	}



	    public boolean search(int k){
		if(x==null || k==x.key)
			return x;
		if(k < x.key)
			return treeSearch(x.left, k);
		else
			return treeSearch(x.right, k)
		
		
		}


	
}


*/