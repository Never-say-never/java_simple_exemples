import java.util.Arrays;

public class Fperdesc {
	
	private static int[][] desc;
	
	private static int fers = 12;
	
	private static final int FERZ = 4;
	
	private static final int BLACK_CELL = 0;
	
	private static final int WHITE_CELL = 1;
		
	static{
		desc = new int[4][4];
		resetDesk();
		
	}
	
	private static void resetDesk(){
		for(int ix = 0; ix < desc.length; ++ix){
			for(int iy = 0; iy < desc[ix].length; ++iy){
				if((iy % 2) == 0 && ((ix % 2) == 0)){
					desc[ix][iy] = BLACK_CELL;
				}
					
				if((iy % 2) != 0 && (ix % 2) != 0){
					desc[ix][iy] = BLACK_CELL;
				}
			}
		}
	}
	
	public static void main(String[] args){	
		int maxferzOndesc = 0;
		int[][] bestDesc = new int[desc.length][desc.length];
		for(int ix = 0; ix < desc.length; ++ix){
			for(int iy = 0; iy < desc.length; ++iy){
				runTest(new int[]{ix, iy});
				
				int cferz = calculateFerz();
				if(maxferzOndesc < cferz){
					maxferzOndesc = cferz;
					bestDesc = copyArr(bestDesc);
				}

				resetDesk();
			}
		}
		
		printDesc(bestDesc);
		System.out.println("\n" + "Max ferz counter = " + maxferzOndesc);
	}
	
	private static int[][] copyArr(int[][] arr){
		for(int ix = 0; ix < desc.length; ++ix){
			for(int iy = 0; iy < desc.length; ++iy){
				arr[ix][iy] = desc[ix][iy];
			}
		}
		
		return arr;
	}
	
	private static int calculateFerz(){
		int count = 0;
		for(int ix = 0; ix < desc.length; ++ix){
			for(int iy = 0; iy < desc.length; ++iy){
				if(desc[ix][iy] == Fperdesc.FERZ){
					count++;
				}
			}
		}
		
		return count;
	}
	
	private static void runTest(int[] pos){
		try {
			putFers(fers, pos);
		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}
		
		//printDesc();
	}
	
	private static boolean putFers(int implemented, int[] pos) throws Exception{	
		if(implemented < 0){
			return true;
		}

		if(check(pos) == false){
			desc[pos[0]][pos[1]] = FERZ;
		}else{
			while(check(pos)){
				//pos = calculateNewPosition(pos);
				pos = calculateNewPositionUpgrated(pos);
			}
			
			desc[pos[0]][pos[1]] = FERZ;
		}
		
		return putFers(implemented, pos);
	}
	
	private static boolean check(int[] pos){	
		return isHorizontalbinded(pos) || checkDiagonals(pos);
	}
	
	private static boolean checkDiagonals(int[] pos){
		int topLeft  = 0;
		int topRight = 0;
		int botLeft  = 0;
		int botRight = 0;

		for(int ix = 0; ix < desc.length; ++ix){
			if(pos[0] - ix >= 0 && pos[1] - ix >= 0) {
				topLeft = desc[pos[0] - ix][pos[1] - ix];
				if(!isEmptyCell(topLeft)){
					return true;
				}
			}
			
			if(pos[0] - ix >= 0 && pos[1] + ix <= desc.length - 1) {
				topRight = desc[pos[0] - ix][pos[1] + ix];
				if(!isEmptyCell(topRight)){
					return true;
				}
			}

			if(pos[0] + ix <= desc.length - 1 && pos[1] - ix >= 0) {
				botLeft = desc[pos[0] + ix][pos[1] - ix];
				if(!isEmptyCell(botLeft)){
					return true;
				}
			}
			
			if(pos[0] + ix <= desc.length - 1 && pos[1] + ix <= desc.length - 1) {
				botRight = desc[pos[0] + ix][pos[1] + ix];
				if(!isEmptyCell(botRight)){
					return true;
				}
			}
		}

		return false;
	}

	private static boolean isEmptyCell(int cell){
		return cell == WHITE_CELL || cell == BLACK_CELL;
	}
	
	private static boolean isHorizontalbinded(int[] pos){
		for(int ix = 0; ix < desc.length; ++ix){
			int horPath = desc[pos[0]][ix];
			int verPath = desc[ix][pos[1]];
			
			if(!isEmptyCell(horPath) || !isEmptyCell(verPath)){
				return true;
			}
		}
		
		return false;
	}
	
	
	private static int[] calculateNewPosition(int[] currentPos) throws Exception{
		if(currentPos[1] < desc.length - 1){
			currentPos[1]++;
			
			return currentPos;
		}else{
			if(currentPos[0] >= desc.length - 1){
				throw new Exception("The end");
			}
			currentPos[0]++;
			currentPos[1] = 0;
			
			return currentPos;
		}
	}
	
	private static int[] calculateNewPositionUpgrated(int[] currentPos) throws Exception{
		if(currentPos[1] < desc.length - 1){
			currentPos[1]++;
			
			return currentPos;
		}else{
			if(currentPos[0] >= desc.length - 1){
				throw new Exception("The end");
			}
			currentPos[0]++;
			currentPos[1] = 0;
			
			return currentPos;
		}
	}
	
	
	private static void printDesc(){
		for(int ix = 0; ix < desc.length; ++ix){
			System.out.println();
			System.out.print("[" + ix + "] ");
			for(int iy = 0; iy < desc[ix].length; ++iy){
				System.out.print(desc[ix][iy] + " ");
			}
		}
		
		System.out.println();
	}
	
	private static void printDesc(int[][] decsCopy){
		for(int ix = 0; ix < decsCopy.length; ++ix){
			System.out.println();
			System.out.print("[" + ix + "] ");
			for(int iy = 0; iy < decsCopy[ix].length; ++iy){
				System.out.print(decsCopy[ix][iy] + " ");
			}
		}
	}
}
