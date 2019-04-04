public class DictBinTree implements Dict{


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