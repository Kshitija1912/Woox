package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Dao.RegisterRepository;
import com.example.demo.Dao.bookingRepositiory;
import com.example.demo.Dao.contactRepository;
import com.example.demo.Dao.imagesRepository;
import com.example.demo.Dao.offersRepository;
import com.example.demo.Dao.reservationRepository;
import com.example.demo.Dao.wooxRepository;
import com.example.demo.bean.woox;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.example.demo.bean.Email;
import com.example.demo.bean.Register;
import com.example.demo.bean.booking;
import com.example.demo.bean.contact;
import com.example.demo.bean.images;
import com.example.demo.bean.offers;

import com.example.demo.bean.reservation;
@Controller
public class SpringBootController {

    @RequestMapping ("/index")
    public String index() {
    	return "index";
    
    }
    @RequestMapping ("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user");
    	return "index";
    
    }
    
    
    @RequestMapping("/reservation")
    public String reservation(HttpSession session) {
    	System.out.println("hello=");
    	
    	session.setAttribute("usernot", "please login");
    	
    	
    		return "login";
    	
		
    }
    @Autowired
    bookingRepositiory br1;
    
    @RequestMapping ("/reserve")
    public String reservation(booking b,HttpSession session) {
    	
    	br1.save(b);
    	session.setAttribute("book",b);
    	
    	return "check";
    
    }
         
    @Autowired
    RegisterRepository rr;
    
    @GetMapping("/register")
    public String register() {
    	return "register";
    }
   
    @PostMapping("/register")
    public String showregister(Register r,HttpSession session) {
    	try {
    		rr.save(r);
    		System.out.println("register");
    		session.setAttribute("msg", "Register Successfully!.....");
    	}catch(DataIntegrityViolationException e) {
    		session.setAttribute("failed","Email Id already exists");
			
			return "register";
			
		}
		
		return "register";
    	}
    
    @GetMapping ("/login")
    
    public String login() {
    	
    	
    	return "login";
    
    }
   
    @PostMapping("/login")
	public String login(Register r,HttpSession session) {
		System.out.println(r.getEmail());
	    System.out.println(r.getPassword());
		
        Iterable<Register> itr=rr.findAll();
		
          
          ModelAndView mv=new ModelAndView();
		
		int count=0;
		for(Register u1:itr) {
			System.out.println(u1.getEmail());
			if(u1.getEmail().equals(r.getEmail())&&(u1.getPassword().equals(r.getPassword())) ){
				Optional<Register> optional=rr.findById(u1.getEmail());
				Register reg=optional.get();
				System.out.println(reg);
				System.out.println("login");
				
				session.setAttribute("user",u1);
//				System.out.println(u1.getName());
			   
				
				return "redirect:/index";
				
				
			}else {
				
				count++;
				
			}
		}
		
		if(count>0) {
			System.out.print("failed");
			session.setAttribute("failedlogin", "Invalid email or password");
			return "login";
		}
		
		return "login";
		
		
		
	}
    
    
    
    @RequestMapping ("/contact")
    public String contact() {
    	return "contact";
    	
    
    }
    
    @Autowired
       contactRepository cr;
      @RequestMapping ("/contactus")
      public String contactus( contact c) {
    	  
    	  cr.save(c);
	   return "index";
	   
    
     
      }
      
      @Autowired
      offersRepository or;
      @Autowired
     bookingRepositiory br;
      @RequestMapping ("/adddest")
      public String Reservation(booking b,offers o,HttpSession session) {
    	
    	 
    	
    	session.setAttribute("offers", o);
    	
    	session.setAttribute("book", b);
		return "reservation";
    	  
    	 
      
      }
      
//      @RequestMapping ("/about")
//      public String about() {
//      	return "about";
//      	
//      
//      }
      @Autowired
      imagesRepository rm;
      
      @Autowired
      
      offersRepository of;
      @RequestMapping ("/about")
      public List <images> showAllUsers(HttpServletRequest request){
    	  
    	  List<images>images=new ArrayList<>();
    	  
    	  List<offers> offers=new ArrayList<>();
    	  
    	  for(images image:rm.findAll()){
    		  images.add(image);
    		  
    	  }
    	  for(offers offer:of.findAll()){
    		 offers.add(offer);
    		  
    	  }
    	  
    	  request.setAttribute("offers", offers);
    	  request.setAttribute("images", images);
      	return images;
      	 
      }
      @RequestMapping ("/deals")
      public String deals() {
      	return "deals";
      	
      
 }
//      @RequestMapping ("/cart")
//      public String cart() {
//      	return "cart";
//      	
//      }
     
      
//      @PostMapping("/register")
//      public String register(reg r) {
//    	  
//    	  rrr.save(r);
//		return "login";
//    	  
//      }
      
      @RequestMapping("/check")
      public String check() {
    	  
    	  
    	 
    	  return "check";
      }
      
      @RequestMapping("/newlogin")
      public String newlogin() {
    	  return "newlogin";
      }
      
      @Autowired
  	
  	private JavaMailSender javaMailSender;
  	
  	
  	@RequestMapping("/sendemail")
  	public String sendEmail(Email em,HttpSession session) throws MessagingException {
  		

  		
  				 try {
  					  MimeMessage messege=javaMailSender.createMimeMessage();
  					  MimeMessageHelper helper=new MimeMessageHelper(messege);
  					  helper.setFrom("padmarekhaj18@gmail.com");
  					  helper.setTo(em.getEmail());
  					  helper.setSubject("Confirmation of Your Booking Registration");
  					  helper.setText("Dear [Customer's Nikhil],\r\n"
  					  		+ "\r\n"
  					  		+ "Thank you for choosing to book with us for your upcoming trip. We are delighted to confirm that your registration has been successfully processed.\r\n"
  					  		+ "\r\n"
  					  		+ "Here are the details of your booking:\r\n"
  					  		+ "\r\n"
  					  		+ "Booking Reference Number: []\r\n"
  					  		+ "Name of Tour/Service: [WooX]\r\n"
  					  		+ "Date of Booking: [19/12/2023]\r\n"
  					  		+ "Duration: [5 Days]\r\n"
  					  		+ "Total Number of Participants: [21]\r\n"
  					  		+ "Payment Details: [20000]\r\n"
  					  		+ "Should you have any queries or require further assistance, please do not hesitate to reach out to our customer support team at [8766502466]. We are here to ensure your travel experience is smooth and enjoyable.\r\n"
  					  		+ "\r\n"
  					  		+ "We look forward to welcoming you on board for an incredible journey!\r\n"
  					  		+ "\r\n"
  					  		+ "Warm regards,\r\n"
  					  		+ "\r\n"
  					  		+ "[WooX]\r\n"
  					  		+ "[kshitija Nade]\r\n"
  					  		+ "[woox@gmail.com/8766502466]");
  					 
  					  System.out.println("email");
  					  javaMailSender.send(messege);
  					  
  				  }catch(MailSendException e) {
  					  System.out.println(e);
  					  System.out.println("hi");
  					  e.printStackTrace();
  					  
  				  }
  				 
  				 session.setAttribute("msg", "send");
  				return "redirect:/check";
  			}
}