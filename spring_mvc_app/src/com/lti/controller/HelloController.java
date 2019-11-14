package com.lti.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController 
{
	@RequestMapping(value = "/hi" ,method = RequestMethod.GET)
	public ModelAndView sayHello()
	{
		ModelAndView model=new ModelAndView("helloWorld");
		model.addObject("message","This is our App");
		return model;
	}
	
	@RequestMapping(value="/sayhello", method=RequestMethod.GET)
	public ModelAndView sayHelloToName(@RequestParam String name,String title)
	{
		ModelAndView model=new ModelAndView("sayHello");
		model.addObject("name",name);
		model.addObject("title",title);
		model.addObject("todaysdate",new Date());
		return model;
	}
	
	@RequestMapping(value="/prime", method=RequestMethod.GET)
	public ModelAndView sayHelloToName(@RequestParam ("number") int number)
	{
		ModelAndView model=new ModelAndView("prime");
		
		for(int i=2;i<=number/2;i++)
		{
			if(number%i==0) 
			{
				model.addObject("number",number);
				model.addObject("prime","not prime");
			}
			else
			{
				model.addObject("number",number);
				model.addObject("prime","prime");
			}
		}
		
		return model;
	}
}
