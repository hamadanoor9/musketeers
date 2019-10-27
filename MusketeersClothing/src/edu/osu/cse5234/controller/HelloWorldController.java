package edu.osu.cse5234.controller;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String printHelloNew() throws Exception {
		return "Home";
	}

	@RequestMapping(path = "/aboutus", method = RequestMethod.GET)
	public String aboutUs() throws Exception {
		return "AboutUs";
	}

	@RequestMapping(path = "/contactus", method = RequestMethod.GET)
	public String contactUs() throws Exception {
		return "ContactUs";
	}

}
