package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Item> list = new ArrayList<Item>();
		for(int i = 0; i < 5; i++) {
			Item itm = new Item();
			itm.setName(String.valueOf(i));
			itm.setPrice(String.valueOf(i));
			//itm.setQuantity(String.valueOf(i));
			list.add(itm);
		}
		Order order = new Order();
		order.setItems(list);
		request.setAttribute("order", order);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	// items?
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
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
	public String confirmOrder(HttpServletRequest request) throws Exception {
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "Confirmation";
	}
}