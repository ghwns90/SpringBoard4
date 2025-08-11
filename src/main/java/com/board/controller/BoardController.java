package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.board.menus.domain.MenuDTO;
import com.board.menus.mapper.MenuMapper;

@Controller
public class BoardController {
	
	@Autowired
	private MenuMapper  menuMapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	// http://localhost:9090/Board/List?menu_id=MENU01
	@RequestMapping("/Board/List")
	public ModelAndView list( MenuDTO menuDTO ) {
		// 메뉴 리스트
		List<MenuDTO>  menuList  =  menuMapper.getMenuList();
		
		// 게시물 목록처리
		List<BoardDTO> boardList =  boardMapper.getBoardList( menuDTO ); 
		// System.out.println( boardList );
	
		menuDTO                  =  menuMapper.getMenu( menuDTO );
		
		ModelAndView  mv  = new ModelAndView();
		mv.addObject("menuList",  menuList);		
		//mv.addObject("menu_id",   menu_id );		
		mv.addObject("menuDTO",   menuDTO );		
		mv.addObject("boardList", boardList );
		mv.setViewName( "board/list" );
		return  mv;
	}
	
	// http://localhost:9090/Board/WriteForm?menu_id=MENU01
	@RequestMapping("/Board/WriteForm")
	public  ModelAndView  writeForm( MenuDTO  menuDTO  ) {
		
		// 메뉴 목록을 조회
		List<MenuDTO>  menuList = menuMapper.getMenuList();
		
		menuDTO                 = menuMapper.getMenu( menuDTO );
		
		ModelAndView  mv  =  new ModelAndView();
		mv.addObject("menuList", menuList );
		mv.addObject("menuDTO",  menuDTO);
		mv.setViewName( "board/write" );
		return        mv;
		
	}
	
	@RequestMapping("/Board/Write")
	public  ModelAndView  write( BoardDTO boardDTO ) {
		
		boardMapper.insertBoard( boardDTO  );
		
		String menu_id = boardDTO.getMenu_id();
		
		ModelAndView  mv   = new ModelAndView();
		mv.setViewName("redirect:/Board/List?menu_id=" + menu_id);
		return  mv;
		
	}
	 
}




