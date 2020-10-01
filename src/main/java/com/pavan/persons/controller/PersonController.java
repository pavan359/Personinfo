package com.pavan.persons.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pavan.persons.Adress;
import com.pavan.persons.Person;
import com.pavan.persons.dao.AdressDao;
import com.pavan.persons.dao.PersonDao;

@Controller
public class PersonController {

	//private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	private static final Logger LOGGER = LogManager.getLogger(PersonController.class);
	 
	@Autowired(required=true)
	PersonDao dao;	
	@Autowired(required=true)
	AdressDao adao;	
	
	
	@RequestMapping("/")
	public String hmePage() {
		return "addperson.jsp";
	}
	
	public Person getPersonAdress(HttpServletRequest req) {

		int pid=0;
		try {
			pid=Integer.parseInt(req .getParameter("apid")==null?"0":req .getParameter("apid"));
		}catch(NumberFormatException ee) {
		}
		Person p1=dao.findById(pid).orElse(new Person());
		//Adress ad=getcAddress(req);
	//	p1.getAd().add(ad);
		return p1;
	}
	
	
	public Adress getcAddress(HttpServletRequest req) {
		int aid=0;
		int postCode=0;
		try {
			aid=Integer.parseInt(req .getParameter("aid")==null?"0":req .getParameter("aid"));
			postCode=Integer.parseInt(req .getParameter("postCode")==null?"0":req .getParameter("postCode"));

		}catch(NumberFormatException ee) {
			
		}
		String street=req .getParameter("street");
		String city=req .getParameter("city");
		String state=req .getParameter("state");
		Adress ad=new Adress();
		ad.setAid(aid);
		ad.setState(state);
		ad.setCity(city);
		ad.setStreet(street);
		ad.setPostCode(postCode);
		return ad;
	}
	
	  @RequestMapping("/addPerson")
	  public ModelAndView addPesron(Person p,HttpServletRequest req) {
		  // p.getAd().add(getAddress(req));
		  ModelAndView m=new ModelAndView();
		  if(p.getEid()==0 )
		  {
			  m.addObject("result", "No record found with id="+p.getEid());
		  }else {
			  dao.save(p);
			  m.addObject("result", "Record added successfully");
		  }		 
		  m.setViewName("addperson.jsp");
		  return m;
	  }
	
	  @RequestMapping( "/delPerson" )
	
	  public ModelAndView delPerson(Person p) {

		  Person p1=dao.findById(p.getEid()).orElse(new Person());
		  ModelAndView m=new ModelAndView();
		  if(p1.getEid()==0 )
		  {
			  m.addObject("result", "No record found with id="+p.getEid());
		  }else {
			  dao.deleteById(p.getEid());
			  m.addObject("result", "Record deleted successfully");
		  }
		  m.setViewName("addperson.jsp");
		  return m;
	  }
	
	  @RequestMapping("/modifyPerson")
	  public ModelAndView modifyPerson(Person p) {
		  Person p1=dao.findById(p.getEid()).orElse(new Person());
		  
		  ModelAndView m=new ModelAndView();
		  if(p1.getEid()==0 )
		  {
			  m.addObject("result", "No record found with id="+p.getEid());
		  } 
		  
		 
		  else {
			  dao.save(p);
			  m.addObject("result", "Record modified successfully");
		  }
		  m.setViewName("addperson.jsp");
		  return m;
	  }
	
	@RequestMapping("/viewPerson")
	public ModelAndView viewPesron(Person p) {
		Person p1=dao.findById(p.getEid()).orElse(new Person());

		ModelAndView m=new ModelAndView();
		if(p== null ||p1.getEid()==0 )
		{
			m.addObject("result", "No record found with id="+p.getEid());
		}else {
			List<Person> l=new ArrayList<Person>();
			l.add(p1);
			m.addObject("personlist",l.stream().iterator());
		}
		m.setViewName("viewList.jsp");
		return m;
	}
	
	@RequestMapping("/viewAllPerson")
	public ModelAndView viewAllPesron() {
		Iterable<Person> list=dao.findAll();
		ModelAndView m=new ModelAndView();
		m.addObject("personlist", list);
		m.setViewName("viewList.jsp");
		return m;
	}
	
	  @RequestMapping("/addAdress")
	  public ModelAndView addAdress(HttpServletRequest req) {
		  Person p = getPersonAdress(req);
		  Adress ad=getcAddress(req);
		  p.getAd().add(ad);
		  ModelAndView m=new ModelAndView();
		  if(p.getEid()==0 )
		  {
			  m.addObject("result1", "No Person found with person id or address id should not be empty or zero");
		  }else {
			  dao.save(p);
			  m.addObject("result1", "AddressRecord added successfully for person id "+p.getEid());
		  }
		  // p.getAd().add(getAddress(req));
		  m.setViewName("addperson.jsp");

		  return  m;
	  }
	  
	  @RequestMapping("/modifyAddress")
	  
	  public ModelAndView modifyAdress(HttpServletRequest req) {
		  System.out.println(" add recird dele");
		  Person p = getPersonAdress(req);
		  Adress ad=getcAddress(req);
		  Adress addb= adao.findById(ad.getAid()).orElse(new Adress());
		  // p.getAd().add(getAddress(req));
		  ModelAndView m=new ModelAndView();
		  if(p.getEid()==0 || addb.getAid()==0 )
		  {
			  m.addObject("result1", "No Person found with person id or address id should not be empty or zero");
		  }else {
			  p.getAd().add(ad);
			  dao.save(p); 
			  m.addObject("result1","AddressRecord modied successfully for person id "+p.getEid());
		  }

		  m.setViewName("addperson.jsp");
		  return m;
	  }
	  
	  @RequestMapping("/delAddress")
	  public ModelAndView delAddress(HttpServletRequest req) {
		  Person p = getPersonAdress(req);
		  Adress ad=getcAddress(req);
		  ModelAndView m=new ModelAndView();
		  Adress addb= adao.findById(ad.getAid()).orElse(new Adress());
		  if(p.getEid()==0 || addb.getAid()==0 )
		  {
			  m.addObject("result1", "No Person found with person id or address id should not be empty or zero");
			  
		  }else {
			  p.getAd().remove(ad);
			  dao.save(p);
			  m.addObject("result1","AddressRecord deleted successfully for person id ");
		  }
		  m.setViewName("addperson.jsp");
		  return  m;
	  }
	  @RequestMapping("/viewAddress")
	  public ModelAndView viewAddress(HttpServletRequest req) {

		  Adress ad= adao.findById(Integer.parseInt(req .getParameter("aid")==null?"0":req .getParameter("aid"))).orElse(new Adress());
		  ModelAndView m=new ModelAndView();
		  if(ad== null ||ad.getAid()==0 )
		  {
			  m.addObject("result", "No record found given addressid="+Integer.parseInt(req .getParameter("aid")==null?"0":req .getParameter("aid")));
		  }else {
			  List<Adress> l=new ArrayList<Adress>();
			  l.add(ad);
			  m.addObject("addresslist",l.stream().iterator()); 

		  }

		  m.setViewName("addressview.jsp");
		  return  m;
	  }

}
