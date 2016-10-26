package P05_SpeedComparison;

import P04_Baume.BinarySearchTree;
import P05_AVLTree.AvlTree;

/**
 * Created by lucaegli on 23.10.16.
 */
public class Main {

	private static int N_TESTS = 5;
	private static int START = 1000;
	private static int STEP = 2;
	private static int[] n;
    private static AvlTree avlTree;
    private static BinarySearchTree<Integer> binSearchTree;

    public static void main(String[] args){
        avlTree = new AvlTree();
        binSearchTree = new BinarySearchTree<>();
		n = new int[N_TESTS];
		for (int i=0; i<N_TESTS; i++){
			n[i] = START*(int)Math.pow(STEP,i);
		}
        compareInsert(true);
		compareInsert(false);
        compareFind(true);
		compareFind(false);
        compareRemoveSorted();
        compareRemoveSortedReverse();
    }

    private static void compareInsert(boolean sorted){
        long[][] times = new long[2][N_TESTS];
		long start;
		long end;
		int[] indices = null;
		
		
		// AVL
		for (int i=0; i<N_TESTS; i++){
			if (!sorted) indices = getDistributedValues(n[i]);
			avlTree = new AvlTree();
			start = System.currentTimeMillis();
			for (int j=0; j<n[i]; j++){
				int val = sorted? j : indices[j];
				avlTree.insert(val);
			}
			end = System.currentTimeMillis();
			times[0][i] = end-start;
		}

		// BinSearchTree
		for (int i=0; i<N_TESTS; i++){
			if (!sorted) indices = getDistributedValues(n[i]);
			binSearchTree = new BinarySearchTree<>();
			start = System.currentTimeMillis();
			for (int j=0; j<n[i]; j++){
				int val = sorted? j : indices[j];
				binSearchTree.add(val);
			}
			end = System.currentTimeMillis();
			times[1][i] = end-start;
		}

        // Print
		String title = sorted? "Sorted Inserting" : "Distributed Inserting";
        printStats(n, title, times);
    }

    private static void compareFind(boolean sorted){
        long[][] times = new long[2][N_TESTS];
        long start;
        long end;

        // AVL
        for (int i=0; i<N_TESTS; i++){
            if (sorted) insertAVLSorted(n[i]);
			else insertAVLDistributed(n[i]);
            start = System.currentTimeMillis();
            for (int j=0; j<n[i]; j++){
                avlTree.find(j);
            }
            end = System.currentTimeMillis();
            times[0][i] = end-start;
        }

        // BinSearchTree
        for (int i=0; i<N_TESTS; i++){
            if (sorted) insertSearchTreeSorted(n[i]);
			else insertSearchTreeDistributed(n[i]);
            start = System.currentTimeMillis();
            for (int j=0; j<n[i]; j++){
                try { binSearchTree.find(j); } catch (Exception e){}
            }
            end = System.currentTimeMillis();
            times[1][i] = end-start;
        }

        // Print
		String title = sorted? "Sorted Finding" : "Distributed Finding";
        printStats(n, title, times);
    }

    private static void compareRemoveSorted(){
        long[][] times = new long[2][N_TESTS];
        long start;
        long end;

        // AVL
        for (int i=0; i<N_TESTS; i++){
            insertAVLSorted(n[i]);
            start = System.currentTimeMillis();
            for (int j=0; j<n[i]; j++){
                avlTree.remove(j);
            }
            end = System.currentTimeMillis();
            times[0][i] = end-start;
        }

        // BinSearchTree
        for (int i=0; i<N_TESTS; i++){
            insertSearchTreeSorted(n[i]);
            start = System.currentTimeMillis();
            for (int j=0; j<n[i]; j++){
                binSearchTree.remove(j);
            }
            end = System.currentTimeMillis();
            times[1][i] = end-start;
        }

        // Print
        printStats(n, "Sorted Removing", times);
    }

    private static void compareRemoveSortedReverse(){
        long[][] times = new long[2][N_TESTS];
        long start;
        long end;

        // AVL
        for (int i=0; i<N_TESTS; i++){
            insertAVLSorted(n[i]);
            start = System.currentTimeMillis();
            for (int j=n[i]-1; j>=0; j--){
                avlTree.remove(j);
            }
            end = System.currentTimeMillis();
            times[0][i] = end-start;
        }

        // BinSearchTree
        for (int i=0; i<N_TESTS; i++){
            insertSearchTreeSorted(n[i]);
            start = System.currentTimeMillis();
            for (int j=n[i]-1; j>=0; j--){
                binSearchTree.remove(j);
            }
            end = System.currentTimeMillis();
            times[1][i] = end-start;
        }

        // Print
        printStats(n, "Reverse Removing", times);
    }

    private static void insertAVLSorted(int n){
        avlTree = new AvlTree();
        for (int i = 0; i<n; i++) {
            avlTree.insert(i);
        }
    }
	
	private static void insertAVLDistributed(int n){
        avlTree = new AvlTree();
		int[] distributed = getDistributedValues(n);
        for (int i = 0; i<n; i++) {
            avlTree.insert(distributed[i]);
        }
    }

    private static void insertSearchTreeSorted(int n){
		binSearchTree = new BinarySearchTree<>();
		for (int i = 0; i<n; i++) {
			binSearchTree.add(i);
		}
	}
	
	private static void insertSearchTreeDistributed(int n){
        binSearchTree = new BinarySearchTree<>();
		int[] distributed = getDistributedValues(n);
        for (int i = 0; i<n; i++) {
            binSearchTree.add(distributed[i]);
        }
    }
	
	private static int[] getDistributedValues(int nElements) {
		int[] indices = new int[nElements];
		int i = 0;
		int j = nElements-1;
		int nRounds = (nElements/8);
		for (int round = 0; round<nRounds; round++){
			for (int part = 0; part < 2; part++){
				indices[(round * 8 + part * 4)] = i;
				i += 2;
				indices[(round * 8 + part * 4)+1] = i--;
				indices[(round * 8 + part * 4)+2] = j;
				j -= 2;
				indices[(round * 8 + part * 4)+3] = j++;
			}
			i+=2;
			j-=2;
		}
		for (int k=nRounds*8; k<nElements; k++){
			indices[k] = i++;
		}
		int[] temp = new int[nElements];
		System.arraycopy(indices, nElements/2, temp, 0,(nElements-nElements/2));
		System.arraycopy(indices, 0, temp, (int)Math.ceil((double)nElements/2.0) , nElements-(nElements-nElements/2));
		return temp;
	}

    private static void printStats(int[] n, String title, long[][] times){
        System.out.print(title+"\n");
        System.out.print("AVL-Tree;");
        for(long l : times[0]){
            System.out.print(l+";");
        }
        System.out.print("\nSearch Tree;");
        for(long l : times[1]){
            System.out.print(l+";");
        }
        System.out.print("\nElements;");
        for(int i : n){
            System.out.print(i+";");
        }
        System.out.print("\n;\n");
    }

}
