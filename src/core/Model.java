package core;

import java.util.ArrayList;

import services.Database;
import services.Utils;

public abstract class Model<T extends Model<T>> implements Cloneable {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@SuppressWarnings("unchecked")
	public boolean save() {
		if(this._getObject(this.getId()) == null) {
			this.setId(Utils.getRandomId());
			return getRepository().add((T)this);
		}
		return true;
	}
	
	public boolean delete() {
		if(this._getObject(this.getId()) != null) {
			return getRepository().remove(this);
		}
		return false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected T clone() throws CloneNotSupportedException {
        return (T) super.clone();
    }
	
	private T _getObject(int id) {
		ArrayList<T> data;
		try {
			data = getRepository();
			
			for(T el : data) {
				if(el.getId() == id) {
					try {
						return el.clone();
					}catch(CloneNotSupportedException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected ArrayList<T> getRepository() {
		
		Database db = Database.getInstance();
		
		String modelName = getClass().getSimpleName() + "s";
		
		try {
			return (ArrayList<T>) db.getCollections(modelName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<T>();
	}
	
	@Override
	public String toString() {
		return "Models || " + getClass().getSimpleName() + " (" + getId() + ")";
	}
}
 