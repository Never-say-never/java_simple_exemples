package PathFinder;

import java.util.Arrays;

import PathHelper.Helper;

public class PathConfig implements IConfig{

	private int[][] map;
	
	@Override
	public void load() {
		// example of input array data nodes
		int[] input = new int[]{0,1,0,2,2,3,2,4,1,3,4,3};
		
		int[] inputCopy = input.clone();
		
		// get max node to calculate array size
		Arrays.sort(inputCopy);
		int max = inputCopy[inputCopy.length - 1] + 1;
		
		this.map = new int[max][max];
		this.generateGraf(input);
		
		// debug information
		Helper.printArray(input);
		System.out.println("max element: " + max);
		Helper.printArray(this.map);
	}

	@Override
	public int[][] get() {
		return this.map;
	}

	/**
	 * Generate map of relations.
	 * Convert input array into map array as two dominations.
	 * 
	 * @param arr
	 */
	private void generateGraf(int[] arr){
		for(int ix = 0; ix < arr.length; ix += 2){
			this.map[arr[ix]][arr[ix + 1]] = 1;
		}
	}
}
