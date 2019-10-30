package edu.osu.cse5234.business;

import edu.osu.cse5234.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Item;
//
//import edu.osu.cse5234.business.view.*;
import edu.osu.cse5234.model.*;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;

    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
  
    
    public String processOrder(Order order) {
    	
    	
    	List<Item>  inventoryList = new ArrayList<>();
    	List<LineItem> orderItems = order.getItems();
    	for(LineItem li : orderItems) {
    		if(li.getQuantity() == 0) {
    			continue;
    		}
    		Item item = new Item();
    		item.setItemNumber(li.getItemNumber());
    		item.setAvailableQuantity(li.getQuantity());
    		inventoryList.add(item);
    	}

    	if(ServiceLocator.getInventoryService().validateQuantity(inventoryList)) {
    		//ServiceLocator.getInventoryService().updateInventory(inventoryList);
    		entityManager.persist(order); 
    		entityManager.flush();
    		return "Order confirmed";
    	}else {
    		
    		return "Items not available";
    	}
    	
    }
    
    public boolean validateItemAvailability(Order order) {
    	List<Item>  inventoryList = new ArrayList<>();
    	List<LineItem> orderItems = order.getItems();
    	for(LineItem li : orderItems) {
    		if(li.getQuantity() == 0) {
    			continue;
    		}
    		Item item = new Item();
    		item.setItemNumber(li.getItemNumber());
    		item.setAvailableQuantity(li.getQuantity());
    		inventoryList.add(item);
    	}
    	return ServiceLocator.getInventoryService().validateQuantity(inventoryList);
    }

}
