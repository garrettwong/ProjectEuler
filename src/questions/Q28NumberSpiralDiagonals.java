package questions;

public class Q28NumberSpiralDiagonals {

	public static void main(String[] args) {
		int[][] arr = createArray(1001);
		int sum = sumDiagonals(arr);
		System.out.println(sum);
	}
	
	public enum Direction {
		Down,
		Left,
		Up,
		Right
	}
	
	public static int[][] createArray(int dim) {
		int[][] arr = new int[dim][dim];
		
		int center = dim / 2;
		int row = center;
		int col = center;
		
		int spiralFactor = 2;
		Direction direction = Direction.Down; 
		// base case
		arr[center][center] = 1;
		// iterate right
		col++;
		
		for (int i = 2; i < (dim*dim)+1; ) {
			// Down, Left, Up, Right
			for (int j = 0; j < spiralFactor; j++) {
				switch (direction) {
					case Down:
						arr[row+j][col] = i;
						break;
					case Left:
						arr[row][col-j] = i;
						break;
					case Up:
						arr[row-j][col] = i;
						break;
					case Right:
						arr[row][col+j] = i;
						break;
					default:
						break;
				}
				i++;
			}
			switch (direction) {
			case Down:
				direction = Direction.Left;
				col -= 1;
				row += (spiralFactor-1);
				break;
			case Left:
				direction = Direction.Up;
				col -= (spiralFactor-1);
				row -= 1;
				break;
			case Up:
				direction = Direction.Right;
				col += 1;
				row -= (spiralFactor-1);
				break;
			case Right:
				direction = Direction.Down;
				col += (spiralFactor);
				break;
			}
			
			// Increase Spiral Factor by 1 every Down
			if (direction == Direction.Down) { 
				spiralFactor+=2;
			}
		}
		
		return arr;
	}
	
	public static int sumDiagonals(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int first = i;
			int end = arr.length - (i+1);
			
			// Middle
			if (first == end) {
				sum += arr[first][first];
			} else {
				sum += arr[i][first];
				sum += arr[i][end];
			}
		}
		
		return sum;
	}

}
