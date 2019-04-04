package project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class codeCraft_HashMap extends HashMap<Integer, ArrayList<Item>> {


	public void addVal(Integer K, Item V) {
    	ArrayList<Item> p = new ArrayList<Item>();
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
