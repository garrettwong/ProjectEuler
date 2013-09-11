package questions;

/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 */
public class Q18MaxPathSum {
	private static class TreeNode
    {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public int getData()
        {
            return data;
        }

        public TreeNode getLeft()
        {
            return left;
        }

        public TreeNode getRight()
        {
            return right;
        }

        public TreeNode(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }

        public void setLeft(TreeNode left)
        {
            this.left = left;
        }

        public void setRight(TreeNode right)
        {
            this.right = right;
        }
    }
	
	private static TreeNode createTree(String[] in) {
		TreeNode root = new TreeNode(Integer.parseInt(in[0]));
		
		root.left = new TreeNode(7);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
		TreeNode temp = new TreeNode(4);
		root.left.right = temp;
		root.right.left = temp;
		root.right.right = new TreeNode(6);
		root.left.left.left = new TreeNode(8);
		temp = new TreeNode(5);
		root.left.left.right = temp;
		root.left.right.left = temp;
		temp = new TreeNode(9);
		root.right.left.right = temp;
		root.right.right.left = temp;
		root.right.right.right = new TreeNode(3);
		return root;
	}
	
	private static class TreeSum 
	{
		private int maxSumBetweenTwoNodes;
		private int maxSumFromRootToLeaf;
		
		public TreeSum(int maxSumBetweenTwoNodes, int maxSumFromRootToLeaf) {
			this.maxSumBetweenTwoNodes = maxSumBetweenTwoNodes;
			this.maxSumFromRootToLeaf = maxSumFromRootToLeaf;
		}
	}
	
	private static TreeSum findMaxSum(TreeNode root) {
		if (root == null) {
			return new TreeSum(0, 0);
		}
		TreeSum leftTreeSum = findMaxSum(root.getLeft());
		TreeSum rightTreeSum = findMaxSum(root.getRight());
		
		int maxSumBetweenTwoNodesOfChildren = Math.max(leftTreeSum.maxSumBetweenTwoNodes,  
			rightTreeSum.maxSumBetweenTwoNodes);
		maxSumBetweenTwoNodesOfChildren = Math.max(maxSumBetweenTwoNodesOfChildren, 
			leftTreeSum.maxSumFromRootToLeaf + rightTreeSum.maxSumFromRootToLeaf + root.getData());
		
		int maxSumFromRootToLeaf = leftTreeSum.maxSumFromRootToLeaf > rightTreeSum.maxSumFromRootToLeaf ?
				leftTreeSum.maxSumFromRootToLeaf + root.getData()
				: rightTreeSum.maxSumFromRootToLeaf + root.data;
		return new TreeSum(maxSumBetweenTwoNodesOfChildren, maxSumFromRootToLeaf);
	}
	
	
	public static void main(String[] args) {
		String in = "75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34 88 02 77 73 07 63 67 99 65 04 28 06 16 70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 04 68 89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
		
		int row = 15;
		int col = 15;
		
		// Pre-Process
		int[][] arr = new int[row][col];
		
		String[] values = in.split(" ");
		
		int i = 0;
		for (int j = 0; j < row; j++) {
			for (int k = 0; k <= j; k++) {
				int value = Integer.parseInt(values[i]);
				
				arr[j][k] = value;
				
				i++;
			}
		}
		
		int[][] distMatrix = arr.clone();
		
		// Traverse Upwards - can go up one and left one
		for (int j = row-1; j >= 0; j--) {
			updateDistance(j, distMatrix, arr);
		}
		System.out.println(distMatrix[0][0]);
	}
	public static void updateDistance(int row, int[][] distMatrix, int[][] arr) {
		if (row != 14) {
			// Add previous
			for (int i = 0; i < row+1; i++) {
				distMatrix[row][i] = Math.max(arr[row][i] + arr[row+1][i], arr[row][i]+arr[row+1][i+1]);
			}
		}
			
	}
}
