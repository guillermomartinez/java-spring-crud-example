/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Profesor;
import java.util.ArrayList;
import model.ProfesorModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfesoresController {
	
	@RequestMapping("profesores/list.htm")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("profesores/list");	
		ProfesorModel model = new ProfesorModel();
		mav.addObject("lst", model.getAll());
		return mav;
	}	
	
	@RequestMapping(value="profesores/create.htm",method = RequestMethod.GET)
	public ModelAndView create(Model m){		
        Profesor p = new Profesor();                                
		ModelAndView mav = new ModelAndView();
		mav.setViewName("profesores/create");			
		mav.addObject("Profesor", p);
		return mav;
	}
	
	@RequestMapping(value="profesores/add.htm",method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="Profesor") Profesor p){
		ProfesorModel model=new ProfesorModel();
        model.create(p);        
		return new ModelAndView("redirect:/profesores/list.htm");
	}
	
	@RequestMapping(value="profesores/edit.htm",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value="id") int id, @ModelAttribute(value="Profesor") Profesor p){		
		int identificador = Integer.parseInt(String.valueOf(id));
		ProfesorModel model= new ProfesorModel();		
		p = model.getProfesor(identificador);				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("profesores/edit");				
		mav.addObject("p", p);
		return mav;
	}
	
	@RequestMapping(value="profesores/update.htm",method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="Profesor") Profesor p){		
		ProfesorModel model=new ProfesorModel();
		Profesor aux= new Profesor();
        aux=model.getProfesor(p.getId());
        aux.setNombre(p.getNombre());        
        model.edit(aux);        
		return new ModelAndView("redirect:/profesores/list.htm");
	}
	
	@RequestMapping(value="profesores/delete.htm",method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam(value="id") int id){		
		int identificador = Integer.parseInt(String.valueOf(id));
		ProfesorModel model= new ProfesorModel();		
		Profesor p = model.getProfesor(identificador);				
		model.remove(p);
		return new ModelAndView("redirect:/profesores/list.htm");
	}
}
