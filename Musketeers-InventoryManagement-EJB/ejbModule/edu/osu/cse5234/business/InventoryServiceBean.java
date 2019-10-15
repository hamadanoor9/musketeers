package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        
    }

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Inventory getAvailableInventory() {
		// TODO Auto-generated method stub
		Inventory inventory = new Inventory();
		List<Item> list = new ArrayList<Item>();
		String[] products = new String[5];
		products[0] = "Jacket";
		products[1] = "Pants";
		products[2] = "Sneakers";
		products[3] = "Shirt";
		products[4] = "Shorts";
					
		for(int i = 0; i < 5; i++) {
			Item itm = new Item();
			itm.setName(products[i]);
			itm.setPrice(String.valueOf(i+1));
			list.add(itm);
		}
		inventory.setItems(list);
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

}
