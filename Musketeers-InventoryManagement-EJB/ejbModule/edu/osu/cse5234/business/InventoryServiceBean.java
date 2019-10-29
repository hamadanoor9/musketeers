package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
public class InventoryServiceBean implements InventoryService {

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

	public InventoryServiceBean() {
        
    }
	String MY_QUERY = "Select i from Item i";

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Inventory getAvailableInventory() {
		// TODO Auto-generated method stub
		Inventory inventory = new Inventory();
		//List<Item> list = new ArrayList<Item>();
		
		List<Item> list = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		
		inventory.setItems(list);
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		// TODO Auto-generated method stub
		List<Item> inventoryList = getAvailableInventory().getItems();
		for(Item item : items) {
		
			for(Item inventoryItem : inventoryList) {
				if(item.getId() == inventoryItem.getId() && item.getAvailableQuantity() > inventoryItem.getAvailableQuantity()) {
					return false;
				}
			}
			
		}
		
		return true;
	}

}
