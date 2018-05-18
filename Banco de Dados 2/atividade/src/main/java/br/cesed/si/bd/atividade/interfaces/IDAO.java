package br.cesed.si.bd.atividade.interfaces;

public interface IDAO <T>{
 
	public void create(T t);
	
	public T retrieve(T t);
	
	public void update(T t);
	
	public void delete(T t);
}
