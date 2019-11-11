package com.dbms;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbms.dao.Feedbackdao;
import com.dbms.dao.Employeedao;
import com.dbms.dao.Vendordao;
import com.dbms.dao.Productdao;
import com.dbms.dao.Userdao;
import com.dbms.dao.Cartdao;
import com.dbms.dao.Dailyvendorbuydao;
import com.dbms.dao.Invoicedao;
import com.dbms.dao.PayLogdao;
import com.dbms.dao.Deliveryservicedao;
import com.dbms.dao.Deliveryentrydao;
import com.dbms.model.Employee;
import com.dbms.model.Feedback;
import com.dbms.model.Vendor;
import com.dbms.model.Product;
import com.dbms.model.User;
import com.dbms.model.Cart;
import com.dbms.model.Dailyvendorbuy;
import com.dbms.model.Invoice;
import com.dbms.model.PayLog;
import com.dbms.model.Deliveryservice;
import com.dbms.model.Deliveryentry;
@Controller
public class MainController {
	
	@Autowired
	public Feedbackdao feedbackdao;	
	@Autowired
	public Userdao userdao;
	@Autowired
	public Employeedao employeedao;
	@Autowired
	public Vendordao vendordao;
	@Autowired
	public Productdao productdao;
	@Autowired
	public Cartdao cartdao;
	@Autowired
	public Invoicedao invoicedao;
	@Autowired
	public PayLogdao paylogdao;
	@Autowired
	public Dailyvendorbuydao dailyvendorbuydao;
	@Autowired
	public Deliveryservicedao deliveryservicedao;
	@Autowired
	public Deliveryentrydao deliveryentrydao;
	
	@RequestMapping(value = "/")
	public String welcome(Model model) {
		System.out.println(" / Controller Called!");
		model.addAttribute("name", "Home Page");
		model.addAttribute("description", "unsecured page !");
		List<Product> allpro=productdao.showProducts();
		model.addAttribute("allpro",allpro);
		return "home";

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("/login get Controller Called!");

		return "login";

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		System.out.println("/logout get Controller Called!");

		return "redirect:/";

	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		System.out.println("/loginError get Controller Called!");
		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping("/admin")
	public String admin(Model model, Principal principal) {
		System.out.println("/admin Controller Called!");

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security Custom Login Demo");
		model.addAttribute("description", "Protected page !");
		return "admin";
	}
	
	@RequestMapping("/empl")
	public String empl(Model model, Principal principal) {
		System.out.println("/empl Controller Called!");

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security Custom Login Demo");
		model.addAttribute("description", "Protected page !");
		return "empl";
	}
	
	@RequestMapping("/user")
	public String user(Model model, Principal principal) {
		System.out.println("/user Controller Called!");

		String loggedInUserName = principal.getName();
		model.addAttribute("user", loggedInUserName);
		model.addAttribute("name", "Spring Security USER Custom Login Demo");
		model.addAttribute("description", "Protected page for user !");
		List<Product> allpro=productdao.showProducts();
		model.addAttribute("allpro",allpro);
		return "user";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		System.out.println(" /register get Controller Called!");
		
		User user = new User();
		model.addAttribute("user", user);

		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerProcess(@Valid @ModelAttribute("user") User user,BindingResult result,Model model) {
		System.out.println("/register post Controller Called!");

		if(result.hasErrors()) {
			return "register";
		}
		else {
			if(!user.getPassword().equals(user.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "register";
			}
			if(userdao.getUser(user.getUsername())!=null) {
				model.addAttribute("error", "username exists");
				return "register";
			}
			userdao.saveOrUpdate(user);
			return "redirect:/";
		}
	}
	
	
	
	
	@RequestMapping(value="admin/empregister",method=RequestMethod.GET)
	public String empregister(Model model) {
		System.out.println("admin/empregister get Controller Called!");
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "empregister";
	}
	
	@RequestMapping(value="admin/empregister",method=RequestMethod.POST)
	public String empregisterProcess(@Valid @ModelAttribute(""
			+ "") Employee employee,BindingResult result,Model model) {
		System.out.println("admin/empregister post Controller Called!");
		if(result.hasErrors()) {
			return "empregister";
		}
		else {
			if(!employee.getPassword().equals(employee.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "empregister";
			}
			if(employeedao.getEmployeeUser(employee.getUsername())!=null) {
				model.addAttribute("error", "username exists");
				return "empregister";
			}
			employeedao.saveOrUpdate(employee);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showemployees")
	public String adshowemployees(Model model) {
		System.out.println("admin/showemployees  Controller Called!");
		List<Employee> allemp=employeedao.showEmployee();
		model.addAttribute("allemp",allemp);
		return "showemployees";
	}
	
	@RequestMapping(value="/admin/showemployees/delete/{username}")
	public String delemp(@PathVariable("username") String username) {
		System.out.println("/admin/showemployees/delete/ Controller Called!");
		employeedao.delete(username);
		return "redirect:/admin/showemployees";
	}
	
	@RequestMapping(value="/admin/showemployees/update",method=RequestMethod.GET)
	public String adempupdate(HttpServletRequest request, Model model) {
		System.out.println("/admin/showemployees/update/ get Controller Called!");
		String username = request.getParameter("user");
		Employee employee = employeedao.getEmployee(username);
		model.addAttribute("employee", employee);
		model.addAttribute("username", username);
		return "empupdate";
	}
	
	@RequestMapping(value="/admin/showemployees/update",method=RequestMethod.POST)
	public String adempupdateProcess(@Valid @ModelAttribute("employee") Employee employee,BindingResult result,Model model) {
		System.out.println("/admin/showemployees/update / post Controller Called!");
		
		if(result.hasErrors()) {
			System.out.println("45");
			return "empupdate";
		}
		else {
			if(!employee.getPassword().equals(employee.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "empupdate";
			}
			System.out.println("bgdf"+employee.getName());
			employeedao.empUpdate(employee);
			return "redirect:/admin/showemployees";
		}
	}
	
	@RequestMapping(value="admin/proregister",method=RequestMethod.GET)
	public String adproregister(Model model) {
		System.out.println("/admin/proregister get Controller Called!");
		
		Product product = new Product();
		model.addAttribute("product", product);
		List<Vendor> allven=vendordao.showVendor();
		model.addAttribute("allven",allven);
		return "proregister";
	}
	
	@RequestMapping(value="admin/proregister",method=RequestMethod.POST)
	public String adproregisterProcess(@Valid @ModelAttribute("product") Product product,BindingResult result,Model model) {
		System.out.println("/admin/proregister post Controller Called!");
		if(result.hasErrors()) {
			return "redirect:/admin/proregister";
		}
		else {
			productdao.saveOrUpdateProduct(product);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showproducts")
	public String adshowproducts(Model model, Principal principal) {
		System.out.println("/admin/showproducts Controller Called!");
		List<Product> allpro=productdao.showProducts();
		String username = principal.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		model.addAttribute("allpro",allpro);
		return "showproducts";
	}
	
	@RequestMapping(value="/admin/showproducts/delete/{name}")
	public String addelpro(@PathVariable("name") Long name) {
		System.out.println("/admin/showproducts/delete/ Controller Called!");
		productdao.delete(name);
		return "redirect:/admin/showproducts";
	}
	
	@RequestMapping(value="/admin/showproducts/update",method=RequestMethod.GET)
	public String adproupdate(HttpServletRequest request, Model model) {
		System.out.println("/admin/showemployees/update/  get Controller Called!");
		Long pid = Long.parseLong(request.getParameter("name"));
		Product product = productdao.getProduct(pid);
		model.addAttribute("product", product);
		model.addAttribute("pid", pid);
		List<Vendor> allven=vendordao.showVendor();
		model.addAttribute("allven",allven);
		return "proupdate";
	}
	
	@RequestMapping(value="/admin/showproducts/update",method=RequestMethod.POST)
	public String adproupdateProcess(@Valid @ModelAttribute("product") Product product, BindingResult result,Model model) {
		System.out.println("/admin/show products/upadte post  Controller Called!");
		if(result.hasErrors()) {
			System.out.println("45");
			return "proupdate";
		}
		else {
			productdao.proUpdate(product);
			return "redirect:/admin/showproducts";
		}
	}
	
	@RequestMapping(value="admin/venregister",method=RequestMethod.GET)
	public String venregister(Model model) {
		System.out.println("/admin/venregister get  Controller Called!");
		
		Vendor vendor = new Vendor();
		model.addAttribute("vendor", vendor);

		return "venregister";
	}
	
	@RequestMapping(value="admin/venregister",method=RequestMethod.POST)
	public String venregisterProcess(@Valid @ModelAttribute("vendor") Vendor vendor,BindingResult result,Model model) {
		System.out.println("/admin/venregister get  Controller Called!");

		if(result.hasErrors()) {
			return "venregister";
		}
		else {
			vendordao.saveOrUpdateVendor(vendor);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showvendors")
	public String adshowvendors(Model model) {
		System.out.println("/admin/showvendors  Controller Called!");

		List<Vendor> allven=vendordao.showVendor();
		model.addAttribute("allven",allven);
		return "showvendors";
	}
	
	@RequestMapping(value="/admin/showvendors/delete/{name}")
	public String delven(@PathVariable("name") String name) {
		System.out.println("/admin/showvendors/delete/name   Controller Called!");

		vendordao.delete(name);
		return "redirect:/admin/showvendors";
	}
	
	@RequestMapping(value="/admin/showvendors/update",method=RequestMethod.GET)
	public String advenpupdate(HttpServletRequest request, Model model) {
		System.out.println("/admin/showvendors/update get  Controller Called!");

		String name = request.getParameter("user");
		Vendor vendor = vendordao.getVendor(name);
		model.addAttribute("vendor", vendor);
		model.addAttribute("name", name);
		return "venupdate";
	}
	
	@RequestMapping(value="/admin/showvendors/update",method=RequestMethod.POST)
	public String advenupdateProcess(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result,Model model) {
		System.out.println("/admin/showvendors/update post  Controller Called!");

		if(result.hasErrors()) {
			return "venupdate";
		}
		else {
			vendordao.venUpdate(vendor);
			return "redirect:/admin/showvendors";
		}
	}
	


	
	@RequestMapping(value="admin/dsregister",method=RequestMethod.GET)
	public String addsregister(Model model) {
		System.out.println("/admin/dsregister get  Controller Called!");

		
		Deliveryservice deliveryservice = new Deliveryservice();
		model.addAttribute("deliveryservice", deliveryservice);
		return "dsregister";
	}
	
	@RequestMapping(value="admin/dsregister",method=RequestMethod.POST)
	public String addsregisterProcess(@Valid @ModelAttribute("deliveryservice") Deliveryservice deliveryservice,BindingResult result,Model model) {
		System.out.println("/admin/dsregister post  Controller Called!");

		if(result.hasErrors()) {
			return "dsregister";
		}
		else {
			deliveryservicedao.saveOrUpdateDservice(deliveryservice);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showdss")
	public String adshowdss(Model model) {
		System.out.println("/admin/showdss Controller Called!");

		List<Deliveryservice> allds=deliveryservicedao.showDservice();
		model.addAttribute("allds",allds);
		return "showdss";
	}
	
	@RequestMapping(value="/admin/showdss/delete/{ds}")
	public String delds(@PathVariable("ds") Long ds) {
		System.out.println("/admin/showdss/delete/{ds}  Controller Called!");

		deliveryservicedao.delete(ds);
		return "redirect:/admin/showdss";
	}
	
	@RequestMapping(value="/admin/showdss/update",method=RequestMethod.GET)
	public String addsupdate(HttpServletRequest request, Model model) {
		System.out.println(" /admin/showdss/update get Controller Called!");

		Long sid = Long.parseLong(request.getParameter("ds"));
		Deliveryservice deliveryservice = deliveryservicedao.getDservice(sid);
		model.addAttribute("deliveryservice", deliveryservice);
		model.addAttribute("sid", sid);
		return "dsupdate";
	}
	
	@RequestMapping(value="/admin/showdss/update",method=RequestMethod.POST)
	public String addsupdateProcess(@Valid @ModelAttribute("deliveryservice") Deliveryservice deliveryservice,BindingResult result,Model model) {
		System.out.println(" /admin/showdss/update post Controller Called!");
		if(result.hasErrors()) {
			System.out.println("45");
			return "dsupdate";
		}
		else {
			deliveryservicedao.dsUpdate(deliveryservice);
			return "redirect:/admin/showdss";
		}
	}
	
	@RequestMapping(value="admin/payemp",method=RequestMethod.GET)
	public String emppay(Model model) {
		
		System.out.println(" /admin/payemp get Controller Called!");
		
		PayLog paylog = new PayLog();
		model.addAttribute("paylog", paylog);
		List<Employee> allemp=employeedao.showEmployee();
		model.addAttribute("allemp",allemp);
		return "payemp";
	}
	
	@RequestMapping(value="admin/payemp",method=RequestMethod.POST)
	public String emppayProcess(@Valid @ModelAttribute("paylog") PayLog paylog,BindingResult result,Model model) {
		System.out.println(" /admin/payemp post Controller Called!");

		if(result.hasErrors()) {
			return "redirect:/admin/payemp";
		}
		else {
			if(paylog.getAmount()<=0) {
				model.addAttribute("error", "payment must be positive");
				return "redirect:/admin/payemp";
			}
			paylogdao.updateELog(paylog);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/payven",method=RequestMethod.GET)
	public String venpay(HttpServletRequest request, Model model) {
		System.out.println(" /admin/payven get Controller Called!");

		
		PayLog paylog = new PayLog();
		model.addAttribute("paylog", paylog);
		List<Vendor> allven=vendordao.showVendor();
		model.addAttribute("allven",allven);

		return "payven";
	}
	
	@RequestMapping(value="admin/payven",method=RequestMethod.POST)
	public String venpayProcess(@Valid @ModelAttribute("paylog") PayLog paylog,BindingResult result,Model model) {
		System.out.println(" /admin/payven post Controller Called!");
		if(result.hasErrors()) {
			return "redirect:/admin/payven";
		}
		else {
			if(paylog.getAmount()<=0) {
				model.addAttribute("error", "payment must be positive");
				return "redirect:/admin/payven";
			}
			paylogdao.updateMLog(paylog);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="admin/showlog")
	public String showpayLog(Model model) {
		
		List<PayLog> allpay = paylogdao.displog();
		model.addAttribute("allpay",allpay);
		
		return "showlog";
		
	}
	
	
	@RequestMapping(value="admin/showfeedback")
	public String showfeedback(Model model) {
		System.out.println(" /admin/show feedback  Controller Called!");
		
		List<Feedback> allfeedback = feedbackdao.disfeedback();
		model.addAttribute("allfeedback",allfeedback);
		
		return "showfeedback";
		
	}
	
	

	
	
	@RequestMapping(value="admin/showvendortrans")
	public String showvendortrans(Model model) {
		System.out.println(" /admin/show vendortrans Controller Called!");
		
		List<Dailyvendorbuy> alltrans = dailyvendorbuydao.disdailyvendorbuy();
		model.addAttribute("alltrans",alltrans);
		
		return "showvendortrans";
		
	}
	
	////////////////////////////////////////////////////////////////
	
	
	
	
	/////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	@RequestMapping(value="admin/showproductyettodeliver")
	public String showproductyettodeliver(Model model, HttpServletRequest request) {
		System.out.println(" /admin/showproductyettodeliver Controller Called!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		String role=userdao.findRole(username);
		model.addAttribute("role",role);
		List<Deliveryentry> allde=deliveryentrydao.showDentry("No");
		model.addAttribute("allde",allde);
		return "showproductyettodeliver";
	}
	
	@RequestMapping(value="admin/showproductyettodeliver/setds",method=RequestMethod.GET)
	public String adsetds(HttpServletRequest request, Model model) {
		System.out.println(" /admin/showproductyettodeliver/setds get Controller Called!");

		
		Deliveryentry deliveryentry = new Deliveryentry();
		model.addAttribute("deliveryentry", deliveryentry);
		Long invid = Long.parseLong(request.getParameter("invid"));
		model.addAttribute("invid", invid);
		List<Deliveryservice> allds=deliveryservicedao.showDservice();
		model.addAttribute("allds",allds);
		return "setds";
	}
	
	@RequestMapping(value="admin/showproductyettodeliver/setds",method=RequestMethod.POST)
	public String adsetdsProcess(@Valid @ModelAttribute("deliveryentry") Deliveryentry deliveryentry,BindingResult result,Model model) {
		System.out.println(" /admin/showproductyettodeliver/setds post Controller Called!");

		if(result.hasErrors()) {
			return "redirect:/admin/showds/setds";
		}
		else {
			deliveryentrydao.updateDentry(deliveryentry,"Yes");
			return "redirect:/admin/showproductyettodeliver";
		}
	}
	
	@RequestMapping(value="admin/showdeliveredproducts")
	public String showdeliveredproducts(Model model, HttpServletRequest request) {
		System.out.println(" /admin/showdeliveredproducts Controller Called!");

		List<Deliveryentry> allde=deliveryentrydao.showDentry("Yes");
		model.addAttribute("allde",allde);
		return "showdeliveredproducts";
	}
	
	@RequestMapping(value="admin/showinvoice")
	public String adshowinv(Model model) {
		System.out.println(" /admin/showinvoice Controller Called!");

		List <Invoice> allinv=invoicedao.showallInvoice();
		model.addAttribute("allinv",allinv);
		return "showadinvoice";
	}
	
	@RequestMapping(value="admin/showinvoice/invoice")
	public String adshowpinv(Model model, HttpServletRequest request) {
		System.out.println(" /admin/showinvoice/invoice Controller Called!");

		Integer invid=Integer.parseInt(request.getParameter("id"));
		List<Invoice> allinv = invoicedao.showInvoice(invid);
		String username=invoicedao.findUser(invid);
		List<User> allusr=userdao.showUser(username);
		List<Invoice> allinvent= invoicedao.showInvoiceEntry(invid);
		model.addAttribute("allinv",allinv);
		model.addAttribute("allusr",allusr);
		model.addAttribute("allinvent",allinvent);
		return "showinvoice";
	}
	
	
	
	@RequestMapping(value="empl/updatedailyvendorbuy",method=RequestMethod.GET)
	public String updatedailyvendorbuy(Model model,HttpServletRequest request) {
		System.out.println("empl/updatedailyvendorbuyget Controller Called!");
		
		Dailyvendorbuy dailyvendorbuy  = new Dailyvendorbuy();
		model.addAttribute("dailyvendorbuy", dailyvendorbuy);
		List<Vendor> allven=vendordao.showVendor();
		model.addAttribute("allven",allven);
		List<Product> allpro=productdao.showProducts();
		model.addAttribute("allpro",allpro);
	
		
		

		return "dailyvendorbuy";
	}
	
	@RequestMapping(value="empl/updatedailyvendorbuy",method=RequestMethod.POST)
	public String updatedailyvendorbuy(@Valid @ModelAttribute("dailyvendorbuy") Dailyvendorbuy dailyvendorbuy,BindingResult result,Model model,HttpServletRequest request) {
		System.out.println("/emp/updatevendbuy post Controller Called!");
		
		String prodidd = request.getParameter("proddid");
		System.out.println(prodidd);
		if(result.hasErrors()) {
			return "redirect:/emp/updatedailyvendorbuy";
		}
		else {
			
			dailyvendorbuydao.updatedailyvendorbuy(dailyvendorbuy);
			return "redirect:/";
		}
	}
	


	
	@RequestMapping(value="empl/emshowfeedback")
	public String emshowfeedback(Model model) {
		System.out.println(" /employ/show feedback  Controller Called!");
		
		List<Feedback> allfeedback = feedbackdao.disfeedback();
		model.addAttribute("allfeedback",allfeedback);
		
		return "showfeedback";
		
	}
	
	
	@RequestMapping(value="empl/proregister",method=RequestMethod.GET)
	public String proregister(Model model) {
		System.out.println(" empl/proregister get Controller Called!");

		
		Product product = new Product();
		model.addAttribute("product", product);
		List<Vendor> allven=vendordao.showVendor();
		model.addAttribute("allven",allven);
		return "proregister";
	}
	
	@RequestMapping(value="empl/proregister",method=RequestMethod.POST)
	public String proregisterProcess(@Valid @ModelAttribute("product") Product product,BindingResult result,Model model) {
		System.out.println(" empl/proregister post Controller Called!");

		if(result.hasErrors()) {
			return "proregister";
		}
		else {
			productdao.saveOrUpdateProduct(product);
			return "redirect:/empl";
		}
	}
	
	@RequestMapping(value="empl/showproducts")
	public String showproducts(Model model) {
		System.out.println(" empl/showproducts Controller Called!");

		List<Product> allpro=productdao.showProducts();
		model.addAttribute("allpro",allpro);
		return "showproducts";
	}
	
	@RequestMapping(value="/empl/showproducts/delete/{name}")
	public String empdelpro(@PathVariable("name") Long name) {
		System.out.println(" empl/showproducts/delete/{name} Controller Called!");

		productdao.delete(name);
		return "redirect:/empl/showproducts";
	}
	
	@RequestMapping(value="/empl/showproducts/update",method=RequestMethod.GET)
	public String empproupdate(HttpServletRequest request, Model model) {
		System.out.println(" empl/showproducts/update get Controller Called!");

		Long pid = Long.parseLong(request.getParameter("name"));
		Product product = productdao.getProduct(pid);
		model.addAttribute("product", product);
		model.addAttribute("pid", pid);
		List<Vendor> allven=vendordao.showVendor();
		model.addAttribute("allven",allven);
		return "proupdate";
	}
	
	@RequestMapping(value="/empl/showproducts/update",method=RequestMethod.POST)
	public String empproupdateProcess(@Valid @ModelAttribute("product") Product product, BindingResult result,Model model) {
		System.out.println(" empl/showproducts/update post Controller Called!");

		if(result.hasErrors()) {
			System.out.println("45");
			return "proupdate";
		}
		else {
			productdao.proUpdate(product);
			return "redirect:/empl/showproducts";
		}
	}
	
	@RequestMapping(value="empl/showdeliveredproducts")
	public String empshowdeliveredproducts(Model model, HttpServletRequest request) {
		System.out.println(" empl/showdeliveredproducts Controller Called!");

		List<Deliveryentry> allde=deliveryentrydao.showDentry("Yes");
		model.addAttribute("allde",allde);
		return "showdeliveredproducts";
	}
	
	@RequestMapping(value="empl/showproductyettodeliver")
	public String empshowproductyettodeliver(Model model, HttpServletRequest request) {
		System.out.println(" empl/showproductyettodeliver Controller Called!");

		List<Deliveryentry> allde=deliveryentrydao.showDentry("No");
		model.addAttribute("allde",allde);
		return "showproductyettodeliver";
	}
	
	@RequestMapping(value="empl/showproductyettodeliver/setds",method=RequestMethod.GET)
	public String empsetds(HttpServletRequest request, Model model) {
		System.out.println(" empl/showproductyettodeliver/setds get Controller Called!");

		
		Deliveryentry deliveryentry = new Deliveryentry();
		model.addAttribute("deliveryentry", deliveryentry);
		Long invid = Long.parseLong(request.getParameter("invid"));
		model.addAttribute("invid", invid);
		List<Deliveryservice> allds=deliveryservicedao.showDservice();
		model.addAttribute("allds",allds);
		return "setds";
	}
	
	@RequestMapping(value="empl/showproductyettodeliver/setds",method=RequestMethod.POST)
	public String empsetdsProcess(@Valid @ModelAttribute("deliveryentry") Deliveryentry deliveryentry,BindingResult result,Model model) {
		System.out.println(" empl/showproductyettodeliver/setds post Controller Called!");

		if(result.hasErrors()) {
			return "redirect:/empl/showproductyettodeliver/setds";
		}
		else {
			deliveryentrydao.updateDentry(deliveryentry,"Yes");
			return "redirect:/empl/showproductyettodeliver";
		}
	}
	
	@RequestMapping(value="/user/update",method=RequestMethod.GET)
	public String userupdate(HttpServletRequest request, Model model) {
		System.out.println("/user/update get Controller Called!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		User user = userdao.getCustomer(username);
		model.addAttribute("user", user);
		model.addAttribute("username", username);
		System.out.println(user.getAddress());
		return "userupdate";
	}
	
	@RequestMapping(value="/user/update",method=RequestMethod.POST)
	public String userupdate(@Valid @ModelAttribute("user") User user,BindingResult result,Model model) {
		System.out.println("/user/update post Controller Called!");

		if(result.hasErrors()) {
			return "userupdate";
		}
		else {
			if(!user.getPassword().equals(user.getMpassword())) {
				model.addAttribute("error","passwords dont match");
				return "userupdate";
			}
			userdao.userUpdate(user);
			return "redirect:/user";
		}
	}
	
	
	
	
	@RequestMapping(value="/user/feedback",method=RequestMethod.GET)
	public String feedback(HttpServletRequest request, Model model) {
		System.out.println("/user/feedback get Controller Called!");

		Feedback feedback = new Feedback();
		model.addAttribute("feedback", feedback);
		return "feedback";
	}
	
	
	@RequestMapping(value="/user/feedback",method=RequestMethod.POST)
	public String emppayProcess(@Valid @ModelAttribute("feedback") Feedback feedback,BindingResult result,Model model, HttpServletRequest request) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		
		System.out.println("/user/Feedback Post Controller Called!");
		String feed_back = request.getParameter("comment");
		System.out.println(feed_back);
		String feed2 = request.getParameter("comment2");
		System.out.println(feed2);
		feedback.setUsername(username);
		feedback.setFeed_back(feed_back);
		feedback.setSuggestion(feed2);
		
		feedbackdao.updateFeedback(feedback);

			return "redirect:/user";
		
		}
	
	
	
	
	
	
	/*@RequestMapping(value="/user/feedback",method=RequestMethod.POST)
	public String feedbackgiving(@Valid @ModelAttribute("feedback") Feedback feedback,BindingResult result,Model model, HttpServletRequest request) {
//		if(result.hasErrors()) {
//			return "feedback";
//		}
//		else {
//			if(!employee.getPassword().equals(employee.getMpassword())) {
//				model.addAttribute("error","passwords dont match");
//				return "empregister";
//			}
//			if(employeedao.getEmployeeUser(employee.getUsername())!=null) {
//				model.addAttribute("error", "username exists");
//				return "empregister";
//			}
//			feedbackdao.updateFeedback(feedback);
//			return "redirect:/admin";
//		}

		
		String feed = request.getParameter("comment");
		System.out.println(feed);
		
		return "home";
	}
	
	
	*/
	
		
	
	
	@RequestMapping(value="/user/showuserprofile")
	public String shuser(HttpServletRequest request, Model model) {
		System.out.println("/user/showuserprofile Controller Called!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		System.out.println(username);
		List<User> allusr=userdao.showUser(username);
		model.addAttribute("allusr",allusr);
		return "userdetails";
	}
	
	@RequestMapping(value="/user/products")
	public String checker(Model model,Principal principal) {
		System.out.println("/user/products Controller Called!");

		String user = principal.getName();
		model.addAttribute("user",user);
		model.addAttribute("product","product");
		return "product";
	}
	
	@RequestMapping(value="/user/showinvoice")
	public String usrshowinv(Model model,Principal principal) {
		System.out.println("/user/showinvoice Controller Called!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		List<Invoice> allinv=invoicedao.showInvoiceEntryuser(username);
		model.addAttribute("allinv",allinv);
		return "showusrinvoice";
	}
	
	@RequestMapping(value="user/showinvoice/invoice")
	public String usrshowpinv(Model model, HttpServletRequest request) {
		System.out.println("/user/showinvoice/invoice Controller Called!");

		Integer invid=Integer.parseInt(request.getParameter("id"));
		List<Invoice> allinv = invoicedao.showInvoice(invid);
		String username=invoicedao.findUser(invid);
		List<User> allusr=userdao.showUser(username);
		List<Invoice> allinvent= invoicedao.showInvoiceEntry(invid);
		model.addAttribute("allinv",allinv);
		model.addAttribute("allusr",allusr);
		model.addAttribute("allinvent",allinvent);
		return "showinvoice";
	}
	
	@RequestMapping(value="/user/cart")
	public String addcart(HttpServletRequest request) {
		System.out.println("/user/cart Controller Called!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		Long pid = Long.parseLong(request.getParameter("pid"));
		cartdao.saveCart(username,pid);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/user/showcart")
	public String showcart(HttpServletRequest request, Model model) {
		System.out.println("/user/showcart Controller Called!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		System.out.println("showcart");
		List<Cart> allcart = cartdao.showUserCart(username);
		Long price = cartdao.showPrice(username);
		System.out.println("showcartprice");
		Integer csize=allcart.size();
		model.addAttribute("allcart",allcart);
		model.addAttribute("csize",csize);
		model.addAttribute("price",price);
		return "showcart";
	}
	
	@RequestMapping(value="/user/showcart/delete")
	public String delcartentry(HttpServletRequest request, Model model) {
		System.out.println("/user/showcart/delete Controller Called!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		Long pid = Long.parseLong(request.getParameter("pid"));
		cartdao.deleteCartEntry(username, pid);
		List<Cart> allcart = cartdao.showUserCart(username);
		model.addAttribute("allcart",allcart);
		return "redirect:/user/showcart";
	}
	
	@RequestMapping(value="/user/showcart/update",method=RequestMethod.GET)
	public String usercartupdate(HttpServletRequest request, Model model) {
		System.out.println("/user/showcart/update get Controller Called!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		Long pid = Long.parseLong(request.getParameter("pid"));
		Long maxq=cartdao.getMaxQuantity(pid);
		Cart cart=new Cart();
		model.addAttribute("cart", cart);
		model.addAttribute("username", username);
		model.addAttribute("pid", pid);
		model.addAttribute("maxq", maxq);
		return "cartupdate";
	}
	
	@RequestMapping(value="/user/showcart/update",method=RequestMethod.POST)
	public String usercartupdateProcess(@Valid @ModelAttribute("cart") Cart cart,BindingResult result,Model model) {
		System.out.println("/user/showcart/update post Controller Called!");

		if(result.hasErrors()) {
			System.out.println("result.hasError has run");
			return "cartupdate";
		}
		else {
			if(cart.getQincart()>cart.getMaxq() || cart.getQincart()<1) {
				model.addAttribute("error","please alter quantity");
				return "cartupdate";
			}
			cartdao.updateCartEntry(cart);
			return "redirect:/user/showcart";
		}
	}
	
	@RequestMapping(value="/user/showcart/checkout",method=RequestMethod.GET)
	public String usercartcheckout(HttpServletRequest request, Model model) {
		System.out.println("/user/showcart/checkout    get   Controller Called!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username=authentication.getName();
		Deliveryentry deliveryentry=new Deliveryentry();
		model.addAttribute("deliveryentry",deliveryentry);
		model.addAttribute("username",username);
		//System.out.println("ljkfm");
		return "checkout";
	}
	
	@RequestMapping(value="/user/showcart/checkout",method=RequestMethod.POST)
	public String usercartupdateProcess(@Valid @ModelAttribute("deliveryentry") Deliveryentry deliveryentry,BindingResult result,Model model) {
		System.out.println("/user/showcart/checkout post  Controller Called!");

		if(result.hasErrors()) {
			System.out.println("45");
			return "checkout";
		}
		else {
			String username=deliveryentry.getUsername();
			List<Cart> centry = cartdao.showUserCart(username);
			for(Cart c: centry) {
				if(c.getQincart()>cartdao.getMaxQuantity(c.getPid())){
					return "redirect:/user/showcart";
				}
			}
			Long amount=cartdao.showPrice(username);
			Integer invid=invoicedao.fillInvoice(username, amount);
			deliveryentrydao.saveDentry(deliveryentry, invid);
			List<Invoice> allinvent=invoicedao.fillInvoiceentry(username,amount,centry,invid);
			List<Invoice> allinv = invoicedao.showInvoice(invid);
			List<User> allusr=userdao.showUser(username);
			model.addAttribute("allusr",allusr);
			model.addAttribute("allinvent",allinvent);
			model.addAttribute("allinv",allinv);
			return "showinvoice";
		}
	}

	
}
