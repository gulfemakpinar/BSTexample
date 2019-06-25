//-----------------------------------------------------
// Title: Binary Search Tree
// Description: This class tests the binary search tree with arrays by using information for Friends.csv
//-----------------------------------------------------
import java.util.*;
import edu.princeton.cs.algs4.StdRandom;
public class Friends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 //creates and BST with name f.
		BST f = new BST();
		//to put gulfem as a root.
		f.put("GULFEM", 19);
		//creates string and integer arrays for names and ages.
		String [] friends={"AHMET EFE","ALI ARDA","ALPEREN","ARDA","ATAHAN","AYCEM","BASAKO","BASAKS","BENGISU","BERKE","CIHAD","EDIPCAN","EFE BERK","EGEMEN","ENES","EREN","ESIN","EYLUL ALEYNA","FATMA OZGE","KEMAL MERT","MEHMET CEM","MERT","MERVE","MINA EKIN","MUSTAFA MERT","ONUR","SERTAC","SINAN"};
		int [] age={23,	24,	19,	23,	22,	21,	20,	18,	22,	23,	19,	20,	23,	20,	21,	23,	18, 24,	19,	20,	20, 18,	23,	24,	21,	24,	23,	21};
		//shuffles the uniformly random.
		int N = friends.length;
		 for (int i = 0; i < N; i++)
		 {
		 int r = StdRandom.uniform(i + 1);
		 String swap = friends[i];
		 friends[i] = friends[r];
		 friends[r] = swap;
		 int s = age[i];
		 age[i] = age[r];
		 age[r] = s;
		 }
		//puts them starting from 0th index to last index.
		for(int i=0;i<friends.length;i++){
			f.put(friends[i], age[i]);
		}
		
		Scanner g =new Scanner(System.in);
		int entered;
		do{
			//prints the instructions.
		System.out.println("enter 1 to print all.");
		System.out.println("enter 2 to delete one of them.");
		System.out.println("enter 3 to get one of them.");
		System.out.println("enter 4 to insert new one.");
		System.out.println("enter 5 to exit.");
		//gets an integer from user.
		entered=g.nextInt();
		//do the step according to integer taken from user.
		switch(entered){
		case 1:
			//prints the BST in alphabetic order.
			f.print();
			break;
		case 2:
			//deletes the item that's key taken by the user.(key insensitive)
			System.out.println("enter the key:");
			String k=g.next();
			f.delete(k.toUpperCase());
			break;
		case 3:
			//gets the item that's key taken by the user.(key insensitive)
			System.out.println("enter the key:");
			k=g.next();
			System.out.println(f.get(k.toUpperCase()));
			break;
		case 4:
			//insert a item that's key and value taken by the user.(key insensitive)
			System.out.println("enter the key:");
			k=g.next();
			System.out.println("enter the value:");
			String v=g.next();
			f.put(k.toUpperCase(), v);;
			break;
		case 5:
			//exits the program.
			break;
			default:
				//warns users if they enter an invalid number.
				System.out.println("Invalid entry!");
			
		}
		}while(entered!=5);
		

}
	
}
