package tpmat;

public class MyMat {
	
	public static void afficheM(int[][] m) {
		 System.out.println();
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++)
				System.out.printf("%3d",m[i][j]);
		 System.out.println();
		}	
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 5, 8, 2 }, { 7, 3, 5, 8 }, { 1, 7, 2, 3 } };
		afficheM(m);
	}

}
