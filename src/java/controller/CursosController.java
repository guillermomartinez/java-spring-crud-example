/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Curso;
import entity.Profesor;
import java.util.ArrayList;
import java.util.List;
import model.CursoModel;
import model.ProfesorModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CursosController {
	
	@RequestMapping("cursos/list.htm")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cursos/list");	
		CursoModel model = new CursoModel();
		mav.addObject("lst", model.getAll());
		return mav;
	}	
	
	@RequestMapping(value="cursos/create.htm",method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("Curso") Curso p){		
		ProfesorModel modelProfesor = new ProfesorModel();
		List<Profesor> profesores = modelProfesor.getAll();		        
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cursos/create");			
		mav.addObject("profesores", profesores);
		mav.addObject("Curso", p);
		return mav;
	}
	
	@RequestMapping(value="cursos/add.htm",method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("Curso") Curso p){		
		CursoModel model= new CursoModel();
        model.create(p);        
		return new ModelAndView("redirect:/cursos/list.htm");
	}
	
	@RequestMapping(value="cursos/edit.htm",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value="id") int id, @ModelAttribute("Curso") Curso p){		
		ProfesorModel modelProfesor = new ProfesorModel();
		List<Profesor> profesores = modelProfesor.getAll();		
		int identificador = Integer.parseInt(String.valueOf(id));
		CursoModel model= new CursoModel();		
		p = model.getCurso(identificador);				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cursos/edit");		
		mav.addObject("profesores", profesores);		
		mav.addObject("p", p);
		return mav;
	}
	
	@RequestMapping(value="cursos/update.htm",method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="Curso") Curso p){		
		CursoModel model=new CursoModel();
		Curso aux= new Curso();
        aux= model.getCurso(p.getId());
		aux.setProfesor(p.getProfesor());        
        aux.setNombre(p.getNombre());        
        model.edit(aux);        
		return new ModelAndView("redirect:/cursos/list.htm");
	}
	
	@RequestMapping(value="cursos/delete.htm",method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam(value="id") int id){		
		int identificador = Integer.parseInt(String.valueOf(id));
		CursoModel model= new CursoModel();		
		Curso p = model.getCurso(identificador);				
		model.remove(p);
		return new ModelAndView("redirect:/cursos/list.htm");
	}
}
