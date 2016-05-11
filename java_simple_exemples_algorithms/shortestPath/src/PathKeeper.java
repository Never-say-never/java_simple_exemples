import PathFinder.PathConfig;
import PathFinder.PathProcessorfinder;
import PathFinder.PathRunner;

public class PathKeeper {
	public static void main(String[] args){
		PathRunner pr = new PathRunner();
		try {
			pr.setConfig(new PathConfig());
			pr.setProcessor(new PathProcessorfinder());
			pr.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
