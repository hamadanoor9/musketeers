package edu.osu.cse5234.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import edu.osu.cse5234.business.view.*;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.*;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Inventory inventory = ServiceLocator.getInventoryService().getAvailableInventory();
		
		Order order = new Order();
		List<Item> items = inventory.getItems();
		//List<LineItem> orderItems = order.getItems();
		order.setItems(items);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	// items?
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		//
		if(ServiceLocator.getOrderProcessingService().validateItemAvailability(order)){
			request.getSession().setAttribute("order", order);
			return "redirect:/purchase/paymentEntry";
		}else {
			
			request.setAttribute("message", "Please resubmit item quantities");
			return "OrderEntryForm";
		}
	}

	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("payment", new PaymentInfo());
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("payment", payment);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("shipping", new ShippingInfo());
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shipping") ShippingInfo shipping, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("shipping", shipping);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = new Order();
		order = (Order) request.getSession().getAttribute("order");
		request.setAttribute("order", order);
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request, Order order) throws Exception {
		
		request.getSession().setAttribute("confirm", ServiceLocator.getOrderProcessingService().processOrder(order));
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "Confirmation";
	}
}


