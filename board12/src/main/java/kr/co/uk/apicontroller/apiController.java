package kr.co.uk.apicontroller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.uk.service.BoardService;

@RestController
public class apiController {

	@Autowired
	BoardService service;
	
	/*
	 * @PostMapping("/delete_pro") public Map<String, String>
	 * postDelete(@RequestParam String password,
	 * 
	 * @RequestParam String seq){
	 * 
	 * Map<String, String> map = new LinkedHashMap<>(); Integer result =
	 * service.getPassword(password);
	 * 
	 * if(result == 1) { service.deletePost(seq);
	 * 
	 * map.put("result", "삭제되었습니다"); }
	 * 
	 * map.put("result", "비밀번호가 틀립니다");
	 * 
	 * 
	 * return map; }
	 */
}
