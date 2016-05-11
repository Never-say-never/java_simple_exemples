package PathHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Node.Node;

public class Helper {

	public static void printArray(int[][] arr){
		int index = 0;
		for(int[] t : arr){
			System.out.print("node:[" + index + "] ");
			for(int i : t){
				System.out.print(i + " ");
			}
			System.out.println();
			++index;
		}
		System.out.println();
	}
	
	public static void printArray(int[] arr){
		for(int ix : arr){
			System.out.print(ix + " ");
		}
		System.out.println();
	}

	public static void printArray(List<Node> nodeLiust) {
		for(Node node : nodeLiust){
			System.out.println(node);
		}
	}

	public static void printArray(ArrayList<List> pathMap) {
		System.out.println(" get result pathes :");
		for(List node : pathMap){
			System.out.println(Arrays.toString(node.toArray()));
		}
		
	}
	
}
