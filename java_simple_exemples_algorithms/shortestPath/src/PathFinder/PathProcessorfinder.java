package PathFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Node.Node;
import PathHelper.Helper;

public class PathProcessorfinder {

	private int[][] primalMap;
	
	private List<Node> nodeLiust;
	
	private Node start;
	
	private Node finish;
	
	public PathProcessorfinder(){
		this.nodeLiust = new ArrayList<Node>();
	}
	
	public void setGraf(int[][] map){
		this.primalMap = map;
	}
	
	public void process(){
		this.createNodList();
		this.setRelations();
		
		this.setupStartNode().setupFinishNode();
		
		Helper.printArray(this.nodeLiust);
		
		this.thentaclesGo();
	}
	
	private PathProcessorfinder setupStartNode(){
		this.start = this.nodeLiust.get(0).setupAsHome();
		return this;
	}
	
	private PathProcessorfinder setupFinishNode(){
		this.finish = this.nodeLiust.get(this.nodeLiust.size() - 1).setupAsOffice();
		return this;
	}
	
	/**
	 * 
	 */
	private void createNodList(){
		for(int ix = 0; ix < this.primalMap.length; ++ix){
			this.nodeLiust.add(new Node(ix));
		}
	}
	
	/**
	 * 
	 */
	private void setRelations(){
		for(Node node : this.nodeLiust){
			for(int ix = 0; ix < this.primalMap[node.getnumber()].length; ++ix){
				if(this.primalMap[node.getnumber()][ix] == 1){
					node.addOutgoing(ix);
				}
				
				if(this.primalMap[ix][node.getnumber()] == 1){
					node.addIncoming(ix);
				}
			}
		}
	}
	
	private void thentaclesGo(){
		ArrayList<List> pathMap = new ArrayList<>();
		
		pathMap.add(this.deepPenetration(
				this.start.getOutgoing(),
				new ArrayList<Integer>()
			));
		
		Helper.printArray(pathMap);
	}
	
	private List<Integer> deepPenetration(ArrayList<Integer> currentPosiblePath, ArrayList<Integer> pathForNode){
		for(int next : currentPosiblePath){
			if(this.finish.getnumber() == next){
				// get office, return collected path nodes
				System.out.println("Finish:" + next);
				return pathForNode;
			}
			
			if(pathForNode.contains(next)){
				// return to privies node, switch to next
				System.out.println(Arrays.toString(pathForNode.toArray()) + " : " + next);
				continue;
			}
			
			pathForNode.add(next);
			List<Integer> rez = this.deepPenetration(this.nodeLiust.get(next).getOutgoing(), pathForNode);
			if(!rez.isEmpty()){
				return rez;
			}
		}
		
		return Collections.emptyList();
	}
}
