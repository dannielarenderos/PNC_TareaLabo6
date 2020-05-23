package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.service.ContribuyenteService;

@Controller
public class MainController {

	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@RequestMapping("/contribuyente")	
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		
		try {
			contribuyentes = contribuyenteService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("main");
		return mav;		
	}
	
	

	@RequestMapping(value ="/mostrarContribuyente", method= RequestMethod.POST)	
	public ModelAndView findOne(@RequestParam(value="codigo")int id) {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = null;
		
		try {
			contribuyente = contribuyenteService.findOne(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("estudiante");
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente estudiante, BindingResult result ) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("agregarEstudiante");
		} else {
			contribuyenteService.save(estudiante);
			List<Contribuyente> contribuyentes = null;
			
			try {
				contribuyentes = contribuyenteService.findAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("contribuyentes", contribuyentes);
			mav.setViewName("lista");

		}
		return mav;
		
		
	}
	
	
	@RequestMapping(value = "/borrarEstudiante", method= RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="codigo") int id)
	{
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyenteService.delete(id);
			contribuyentes = contribuyenteService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("main");
		return mav;
	}
	
	
	@GetMapping("/insertar")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("contribuyente", new Contribuyente());
		mav.setViewName("agregar");

		return mav;
	}
}
