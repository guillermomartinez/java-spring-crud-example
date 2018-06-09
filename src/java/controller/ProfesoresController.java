/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.ProfesorModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
