package pt.upacademy.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import pt.upacademy.jseproject.model.Entity;
import pt.upacademy.jseproject.model.Product;
import pt.upacademy.jseproject.model.Shelf;

public abstract class EntityRepository<T extends Entity> {

	private LinkedHashMap<Integer, T> bd = new LinkedHashMap<Integer, T>(); 
	
	
	private int nextId = 0;


	private int returnNextId () {
		return ++nextId;
	}
	
	public int createEntity(T entity) {
		 int id = returnNextId();
		entity.setID(id);
		bd.put(id, entity);
		
		return nextId;
	}
	
	public Collection<Integer> getAllIds() {
		return bd.keySet();
	}
	
	public Collection<T> getAllValues() {
		return bd.values();		
	}
	
	public T getEntityByID(int id) {
		return bd.get(id);	
	}
	public T editEntity(T entity) {
		return bd.put(entity.getID(), entity);
	}
	public T remEntity(int id) {
		return bd.remove(id);
	}
}