package cn.edu.neu.action;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexAction{
	
	@RequestMapping("/index")
	public String getIndexPage(){
		return "test";
	}
}
