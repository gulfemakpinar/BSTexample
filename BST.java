
//-----------------------------------------------------
// Title: Binary Search Tree
// Description: This class is the implementation of a binary search tree with arrays.
//-----------------------------------------------------
import java.lang.Math;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {

	private Key[] key;
	private Value[] val;
	int N = 1;
	static boolean done;

	public BST() {
		key = (Key[]) new Comparable[2];
		val = (Value[]) new Comparable[2];
	}

	private void resize(int capacity)

	// --------------------------------------------------------
	// Summary: resize the array with capacity capacity.
	// Precondition: capacity is integer and bigger than 0.
	// Postcondition: key and val arrays' elements copied to new arrays with
	// capacity size.
	// --------------------------------------------------------
	{
		// creates temporary arrays for values and keys.
		Key[] copy = (Key[]) new Comparable[capacity];
		Value[] copy1 = (Value[]) new Comparable[capacity];
		// copies all the items original arrays to temporary arrays.
		for (int i = 0; i < key.length; i++) {
			if (key[i] != null) {
				copy[i] = key[i];
				copy1[i] = val[i];
			}
		}
		// copies temporary arrays back to original ones.
		key = copy;
		val = copy1;
	}

	public void put(Key k, Value v)

	// --------------------------------------------------------
	// Summary: to start the recursion
	// Precondition: k is a key and v is a value
	// --------------------------------------------------------
	{
		put(1, k, v);

	}

	private void put(int x, Key k, Value v)

	// --------------------------------------------------------
	// Summary: takes key and value and put the place according to bst.
	// Precondition: x is an integer, k is a key and v is a value.
	// Postcondition: a correct tree for bst.
	// --------------------------------------------------------
	{
		// if x is the correct place of the key insert key and value to tree.
		int n = key.length;
		if (x >= n || key[x] == null) {
			if (x >= n)
				// if x is not in the capacity of the array resize the array.
				resize(x + 1);
			key[x] = k;
			val[x] = v;
			return;
		}
		// finds the correct place of the key.
		int cmp = k.compareTo(key[x]);
		if (cmp < 0) {
			put(2 * x, k, v);
		} else if (cmp > 0) {

			put(2 * x + 1, k, v);

		} else
			// if key is already in array puts to value according to key.
			val[x] = v;
		return;
	}

	public Value get(Key k)
	// --------------------------------------------------------
	// Summary: finds the index of the key and returns the value of the key.
	// Precondition: k is a key.
	// --------------------------------------------------------
	{
		// finds the index of the key.
		int x = 1;
		while (x < key.length && key[x] != null) {
			int cmp = k.compareTo(key[x]);
			if (cmp < 0)
				x = 2 * x;
			else if (cmp > 0)
				x = 2 * x + 1;
			// finds the corresponding value and returns it.
			else
				return val[x];
		}
		// if the key is not in the tree returns null.
		return null;

	}

	public void delete(Key k)
	// --------------------------------------------------------
	// Summary: to start the recursion
	// Precondition: k is a key
	// --------------------------------------------------------
	{
		done = false;
		delete(1, k, 0);

	}

	private void delete(int x, Key k, int index)
	// --------------------------------------------------------
	// Summary: finds the key and deletes it.
	// Precondition: x and index is an integer, k is a key .
	// Postcondition: a correct tree for bst.
	// --------------------------------------------------------
	{
		// to check whether there are more items or not.
		if (x >= key.length || key[x] == null) {
			return;
		}
		// finds the key that needs to be deleted.
		int cmp = k.compareTo(key[x]);
		if (cmp < 0 && index == 0) {
			delete(2 * x, k, 0);

		} else if (cmp > 0 && index == 0) {
			delete(2 * x + 1, k, 0);

		} else if (index == 0) {
			// records the index of the deleted key.
			index = x;
			delete(x, k, index);
		} else {
			// finds the minimum key of the right side of the key that needs to
			// be deleted. And replace key and min.
			if (index == x) {
				int i = Min(2 * index + 1);
				key[index] = key[i];
				val[index] = val[i];
				x = i;
			}
			// rearrange the remaining part of the tree(right part of the min)
			if (2 * x + 1 < key.length && key[2 * x + 1] != null) {
				key[x] = key[2 * x + 1];
				val[x] = val[2 * x + 1];
				delete(2 * x + 1, k, index);
			} else if (2 * x < key.length && key[2 * x] != null) {
				key[x] = key[2 * x];
				val[x] = val[2 * x];
				delete(2 * x, k, index);
			}
			// delete duplicate key that happen when we copy key to higher
			// levels.
			if (!done) {
				key[x] = null;
				val[x] = null;
				done = true;
			}
			return;

		}

	}

	private void printarray()
	// --------------------------------------------------------
	// Summary: prints the array to check it is correct or not.

	// --------------------------------------------------------

	{
		for (int i = 0; i < key.length; i++) {
			if (key[i] != null) {
				System.out.println(key[i] + " " + i);
			} else {
				System.out.println("null " + i);
			}
		}

	}

	private int Min(int x)
	// --------------------------------------------------------
	// Summary: finds the min key's index in the tree choose root as key in xth
	// index.
	// Precondition: x is an integer.
	// --------------------------------------------------------
	{
		// goes to left until find null or exceeds to array size.
		while (2 * x < key.length && key[2 * x] != null) {
			x = 2 * x;
		}
		return x;
	}

	public void print()
	// --------------------------------------------------------
	// Summary: to start the recursion
	// --------------------------------------------------------
	{

		int x = 1;
		inorder(x);
	}

	private void inorder(int x)
	// --------------------------------------------------------
	// Summary: trace the tree inorder traversal .
	// Postcondition: print keys in ascending order with values.
	// --------------------------------------------------------
	{
		if (key.length <= x || key[x] == null)
			return;
		inorder(2 * x);
		System.out.println(key[x] + " " + val[x]);

		inorder(2 * x + 1);
	}
}
