package com.choa.ex4;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.choa.freeboard.FreeboardServiceimpl;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/freeboard/**")
public class FreeboardController {

	@Inject
	private FreeboardServiceimpl freeboardServiceimpl ;
	
	@RequestMapping(value="freeboardList", method=RequestMethod.GET)
	public String freeboardList(Model model,ListInfo listInfo)throws Exception{
		model.addAttribute("board","freeboard");
		model.addAttribute("list", freeboardServiceimpl.boardList(listInfo));
		return "board/boardList";
	}
	
	@RequestMapping(value="freeboardWrite", method=RequestMethod.GET)
	public void freeboardWrite(){
		
	}
	
	@RequestMapping(value="freeboardUpdate", method=RequestMethod.GET)
	public void freeboardUpdate(){
		
	}
	
	@RequestMapping(value="freeboardDelete", method=RequestMethod.GET)
	public void freeboardDelete(){
		System.out.println("freeboardDelete Test!!");
	}
	
	@RequestMapping(value="freeboardView", method=RequestMethod.GET)
	public void freeboardView(){
		
	}

}
