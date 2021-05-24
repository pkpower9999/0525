package kr.co.uk.controller;

import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.uk.service.BoardService;
import kr.co.uk.vo.BoardVO;
import kr.co.uk.vo.Criteria;
import kr.co.uk.vo.PageMaker;
import kr.co.uk.vo.PageVO;

@Controller
public class controller {
	
	@Autowired
	BoardService service;

	@GetMapping("/list")
	public String getList(@ModelAttribute("cri") Criteria cri,
						  Model model) {
		
		List<BoardVO> list = service.listPage(cri);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		
		return "list";
	}
	
	@GetMapping("/write")
	public String getWrite(@ModelAttribute("boardVO") BoardVO boardVO) {
			
		return "write";
	}
	
	@PostMapping("/write_pro")
	public String write_pro(@ModelAttribute("boardVO") BoardVO boardVO) {
				
		String pw = boardVO.getPassword();
		String user = boardVO.getRegistuser();
		
		String final_pw = user+pw;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(final_pw.getBytes());
			StringBuilder sb = new StringBuilder();
		
		    for(byte b : md.digest()) {
		        sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
			System.out.println("암호화: "+sb.toString());
			final_pw = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boardVO.setPassword(final_pw);
		service.insertPost(boardVO);
		return "write_success";
	}
	
	@GetMapping("/view")
	public String getView(@ModelAttribute("boardVO") BoardVO boardVO,
						  @RequestParam int seq,
						  Model model) {
		BoardVO post = service.getPost(seq);
		model.addAttribute("post", post);
		return "view";
	}
	
	@GetMapping("/modify")
	public String getModify(@ModelAttribute("boardVO") BoardVO boardVO,
							@RequestParam int seq, Model model) {
	
		BoardVO modifyBoard = service.getPost(seq);
		model.addAttribute("modifyBoard", modifyBoard);
		return "modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@ModelAttribute("boardVO") BoardVO boardVO) {
		
		service.updatePost(boardVO);
		return "modify_success";
	}
	
	@GetMapping("/delete")
	public String getDelete(@ModelAttribute("boardVO") BoardVO boardVO,
							@RequestParam("seq") int seq, Model model) {
		BoardVO deleteBoard = service.getPost(seq);
		model.addAttribute("deleteBoard", deleteBoard);
		return "delete";
	}
	
	@PostMapping("/delete_pro")
	public String delete_pro(@ModelAttribute("boardVO") BoardVO boardVO,
							 @RequestParam("seq") int seq,
							 @RequestParam("password") String password, Model model) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			StringBuilder sb = new StringBuilder();
		
		    for(byte b : md.digest()) {
		        sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
			System.out.println("암호화: "+sb.toString());
			password = sb.toString();
		} catch (Exception e) {
				e.printStackTrace();
		}
		Integer result = service.getPassword(seq, password);
		
		if(result == 1) {
			service.deletePost(seq);
			return "delete_success";
		}
		return "delete_fail";
	}
	
	@GetMapping("/view_pwd")
	public String getView_pwd(@ModelAttribute("boardVO") BoardVO boardVO,
							@RequestParam("seq") int seq, Model model) {
		BoardVO secretVO = service.getPost(seq);
		model.addAttribute("secretVO", secretVO);
		return "view_pwd";
	}
	
	@GetMapping("/view_pwd_fail")
	public String getViewPwd_fail() {
		return "view_pwd_fail";
	}
	
	@PostMapping("/view_pwd_pro")
	public String view_pwd_pro(@ModelAttribute("boardVO") BoardVO boardVO,
							 @RequestParam("seq") int seq,
							 @RequestParam("password") String password, Model model) {
		
		String pw = boardVO.getPassword();
		String user = boardVO.getRegistuser();
		
		String final_pw = user+pw;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(final_pw.getBytes());
			StringBuilder sb = new StringBuilder();
		
		    for(byte b : md.digest()) {
		        sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
			System.out.println("암호화: "+sb.toString());
			final_pw = sb.toString();
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		Integer result = service.getPassword(seq, final_pw);
		System.out.println(result);
		
		if(result == 1) {
			return "redirect:/view?seq="+seq;
		}
		
		return "redirect:view_pwd_fail";
	}
	
	
}
