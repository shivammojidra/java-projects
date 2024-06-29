package com.practice_jsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practice_jsp.entities.Animal;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "index";
	}

	/*
	 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
	 * String processForm(
	 * 
	 * @RequestParam("animalName") String animalName,
	 * 
	 * @RequestParam("animalFood") String animalFood, Model model) {
	 * 
	 * Animal animal = new Animal(); animal.setAnimalName(animalName);
	 * animal.setAnimalFood(animalFood);
	 * System.out.println("Hello! You're at process form");
	 * System.out.println(animal);
	 * 
	 * model.addAttribute("myAnimal", animal);
	 * 
	 * return "success"; //Now we'll learn ModelAttribute , with that we can perform
	 * all the above ops with less code }
	 */

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String processForm(@ModelAttribute Animal animal) {

		System.out.println(animal);

////		No need to write the below line to send data to view, ModelAttribute automatically does that
//		model.addAttribute("myAnimal", animal);

		return "success";
		// Now we'll learn Model , with that we can perform all the above ops with less
		// code
	}

	@RequestMapping("/jstlP")
	public String jstlPractice() {
		return "jstlPractice";
	}

	@RequestMapping("/jstlF")
	public String jstlFunction(Model model) {
		// Model
		ApplicationContext context = new ClassPathXmlApplicationContext("AppConfig.xml");
		List<String> fruits = new ArrayList();

		fruits.add("Orange");
		fruits.add("Banana");
		fruits.add("Mango");

		Animal animal = context.getBean("myAnimal", Animal.class);
//		Animal animal = new Animal("Lion", "Meat");

		model.addAttribute("animal", animal);
		model.addAttribute("fruitList", fruits);
		return "jstlFunction";
	}

	@RequestMapping("/jstlSQL")
	public String sqlWithJsp() {
		return "sqlWithJsp";
	}

	@RequestMapping("/mnv")
	public ModelAndView mNVPractice() {
		ModelAndView modelAndView = new ModelAndView();

		ApplicationContext context = new ClassPathXmlApplicationContext("AppConfig.xml");
		Animal animal = context.getBean("myAnimal", Animal.class);
		// adding object or anything which is required by the view
		modelAndView.addObject("myAnimal", animal);

		// setting view i.e. jsp file name in views folder
		modelAndView.setViewName("modelAndView");

		return modelAndView;
	}

}
