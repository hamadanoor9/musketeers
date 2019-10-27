package edu.osu.cse5234.business;

import edu.osu.cse5234.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    	
    }
    
    public String processOrder(Order order) {
    	if(ServiceLocator.getInventoryService().validateQuantity(order.getItems())) {
    		ServiceLocator.getInventoryService().updateInventory(order.getItems());
    		return "Order confirmed";
    	}else {
    		return "Items not available";
    	}
    	
    }
    
    public boolean validateItemAvailability(Order order) {
    	
    	return ServiceLocator.getInventoryService().validateQuantity(order.getItems());
    }

}
