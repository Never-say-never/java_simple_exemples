package Node;

import java.util.ArrayList;

public abstract class PrimalNode {

	protected boolean home;
	
	protected boolean office;
	
	protected ArrayList<Integer> income;
	
	protected ArrayList<Integer> outgone;
	
	public PrimalNode(){
		this.home 	= false;
		this.office = false;
		
		this.income  = new ArrayList<Integer>();
		this.outgone = new ArrayList<Integer>();
	}
}
