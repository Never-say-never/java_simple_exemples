package Node;

import java.util.ArrayList;
import java.util.Arrays;

public class Node extends PrimalNode{

	private int nodeNumber;
	
	public boolean isOffice(){
		return this.office;
	}
	
	public boolean isHome(){
		return this.home;
	}
	
	public Node setupAsHome(){
		this.home = true;
		return this;
	}
	
	public Node setupAsOffice(){
		this.office = true;
		return this;
	}
		
	public Node(int number){
		super();
		
		this.nodeNumber = number;
	}
	
	public void setIncoming(ArrayList<Integer> income){
		this.income = income;
	}
	
	public void setOutgone(ArrayList<Integer> outgone){
		this.outgone = outgone;
	}
	
	public ArrayList<Integer> getIncoming(){
		return this.income;
	}
	
	public ArrayList<Integer> getOutgoing(){
		return this.outgone;
	}
	
	public void setNumber(int number){
		this.nodeNumber = number;
	}
	
	public int getnumber(){
		return this.nodeNumber;
	}
	
	public void addIncoming(int i){
		this.income.add(i);
	}
	
	public void addOutgoing(int i){
		this.outgone.add(i);
	}
	
	public String toString(){
		return "[" + this.nodeNumber + "]"
				+ " O:" + this.office
				+ " H:" + this.home
				+ " [reations]"
				+ " income:"  + Arrays.toString(this.income.toArray())
				+ " outgone:" + Arrays.toString(this.outgone.toArray());
	}
}
