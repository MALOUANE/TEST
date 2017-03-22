package fr.product.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.product.modele.Product;

/**
 * 
 * @author Moose 
 * Cette Classe Gere les Problématiques (CRUD) de l'objet Produit.
 *
 */
public class ProductDao {
	
	/**
	 * Factory de l'entity manager
	 */
    protected  EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("persistenceUnit");
	
	protected EntityManager manager;
	
	/**
	 * Gestionnaire de transaction
	 */
	protected  EntityTransaction transaction;
	
	/**
	 * 
	 * @param product
	 * @return Le produit qu'on a enregistré
	 */
	public Product save(Product product){
		//Dans le cas ou l'entity manager n'est pas instancié, on le fait.
		if (manager==null)
	      	manager=entityManagerFactory.createEntityManager();
		//Onbtention de la transaction
	   	transaction=manager.getTransaction();
        //Demarrage de la transaction
	   	transaction.begin();
	   	try {
	   	   	//On enregistre le produit
		    manager.persist(product);
		    //On valide la transaction
		    transaction.commit();
		} catch (Exception e) {
		    //Au cas ou il ya probleme on annule la transaction
			transaction.rollback();
		}
		return product;
	
	}
	
	
	
	
	/**
	 * 
	 * @param product
	 * @return Le produit qu'on a modifié
	 */
	public Product update(Product product){
		//Dans le cas ou l'entity manager n'est pas instancié, on le fait.
		if (manager==null)
	      	manager=entityManagerFactory.createEntityManager();
		//Onbtention de la transaction
	   	transaction=manager.getTransaction();
        //Demarrage de la transaction
	   	transaction.begin();
	   	try {
	   	   	//On enregistre le produit
		    manager.persist(manager.merge(product));
		    //On valide la transaction
		    transaction.commit();
		} catch (Exception e) {
		    //Au cas ou il ya probleme on annule la transaction
			transaction.rollback();
		}
		return product;
	
	}
	
	
	
	
	/**
	 * 
	 * @param product a supprimer
	 * Suppréssion de l'entité
	 */
	public void delete(Product product){
		//Dans le cas ou l'entity manager n'est pas instancié, on le fait.
		if (manager==null)
	      	manager=entityManagerFactory.createEntityManager();
		//Onbtention de la transaction
	   	transaction=manager.getTransaction();
        //Demarrage de la transaction
	   	transaction.begin();
	   	try {
	   	   	//On enregistre le produit
		    manager.remove(product);
		    //On valide la transaction
		    transaction.commit();
		} catch (Exception e) {
		    //Au cas ou il ya probleme on annule la transaction
			transaction.rollback();
		}
	
	}
	

}
