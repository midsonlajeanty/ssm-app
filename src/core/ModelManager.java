/**
 * 
 */
package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.reflect.Method;

import services.Database;

public class ModelManager<T extends Model<T>> {
	
	private String model;
	
	public ModelManager(String modelName){
		this.model = modelName;
	}
	
	public String getModelName() {
		return model;
	}

	public void setModelName(String modelName) {
		this.model = modelName;
	}

	public T find(int id) {
		Iterator<T> iterator = this.getRepository().iterator();
		
		while(iterator.hasNext()) {
			T el = iterator.next();
			if(el.getId() == id) {
				return el;
			}
		}
		
		return null;
	}
	
	public T findBy(String getter, Object value){
		Iterator<T> iterator = this.getRepository().iterator();
		
		while(iterator.hasNext()) {
			T el = iterator.next();
			try {
				Method declaredMethod = el.getClass().getMethod(getter);
				if(declaredMethod.invoke(el).equals(value)) {
					return el;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public ArrayList<T> all(){
		return this.getRepository();
	}
	
	
	@SuppressWarnings("unchecked")
	protected ArrayList<T> getRepository() {
		Database db = Database.getInstance();
		
		try {
			return (ArrayList<T>) db.getCollections(this.model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<T>();
	}

}
