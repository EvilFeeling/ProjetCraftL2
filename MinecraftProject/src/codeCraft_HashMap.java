import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class codeCraft_HashMap extends HashMap<Integer, ArrayList<item>> {


	public void addVal(Integer K, item V) {
    	ArrayList<item> p = new ArrayList<item>();
    	if (this.containsKey(K)) {
    		p = this.get(K);
    		p.add(V);
    		this.put(K,p);
    	}
    	else{
    		p.add(V);
    		this.put(K,p);
    	}
    }



}
