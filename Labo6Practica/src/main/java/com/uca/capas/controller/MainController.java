package com.uca.capas.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {

		
		@Autowired
		ContribuyenteService contribuyenteService;
		
		@Autowired
		ImportanciaService importanciaService;
		
		@RequestMapping("/")
		public ModelAndView index() {
			
			ModelAndView mav = new ModelAndView();
			List<Importancia> importancias = importanciaService.findAll();
			Contribuyente contribuyente = new Contribuyente();
			
			mav.addObject("contribuyente", contribuyente);
			mav.addObject("importancias", importancias);
			mav.setViewName("insertar");
			
			return mav;
			
		}
		
		@RequestMapping("/guardar")
		public ModelAndView guardarCont(@ModelAttribute Contribuyente c, BindingResult result) {
			ModelAndView mav = new ModelAndView();

			

			if(result.hasErrors()) {
				mav.setViewName("insertar");
			} else {
				contribuyenteService.save(c);
			
			}
			
			mav.setViewName("exito");
			
			return mav;
			
		}
		
		@RequestMapping("/contribuyentes")
		public ModelAndView conts() {
			
			ModelAndView mav = new ModelAndView();
			List<Contribuyente> contribuyentes = contribuyenteService.findAll();
			
			mav.addObject("contribuyentes", contribuyentes);
			mav.setViewName("main");
			
			return mav;
			
		}
	
	
}
