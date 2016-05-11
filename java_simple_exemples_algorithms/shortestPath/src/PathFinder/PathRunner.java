package PathFinder;

public class PathRunner {

	private PathConfig config;
	
	private PathProcessorfinder pathFinder;
	
	public void run() throws Exception{
		this.config.load();
		this.pathFinder.setGraf(this.config.get());
		
		this.pathFinder.process();
	}
	
	public void setConfig(PathConfig conf){
		this.config = conf;
	}
	
	public void setProcessor(PathProcessorfinder pathFinder){
		this.pathFinder = pathFinder;
	}
	
}
