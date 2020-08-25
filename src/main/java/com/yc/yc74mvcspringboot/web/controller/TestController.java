package com.yc.yc74mvcspringboot.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.yc74mvcspringboot.bean.Student;
@Controller
public class TestController {
	
	private Logger log=Logger.getLogger(TestController.class);
	/**
	 * 请求映射
	 * 
	 */
	@RequestMapping(value="/get/{id}")
	public @ResponseBody String getByid(@PathVariable("id")Long id){
		return "用户"+id;
	}
	//?匹配任何单字符
	//*匹配0或者任意数量的字符
	//**匹配0或者更多的目录
	@RequestMapping(path="/user/*.json")
	public @ResponseBody List<String> getById(){
		List<String> list=new ArrayList<String>();
		for(int i=0;i<10;i++){
			list.add(i+"");
		}
		return list;
	} 
	//只能post请求  用form
	@PostMapping(value="/post/{id}")
	public @ResponseBody String getByid2(@PathVariable("id")Long id){
		return "提交post请求，用户"+id;
	}
	
	@RequestMapping(value="/post2/{id}",method=RequestMethod.POST)
	public @ResponseBody String getByid3(@PathVariable("id")Long id){
		return "提交post222请求，用户"+id;
	}
	//consumes :消费 controller请求中的 contenttype
	@PostMapping(path="consumes/test.json",consumes="application/json")
	public @ResponseBody String consumes1(){
		return "调用了consumes1";
	}
	
	//produces: controller生产的响应中有根据Accpets指定响应类型
	@PostMapping(path="produces/test.json",produces="*/*")
	public @ResponseBody String produces(){
		return "调用了produces";
	}
	
	@PostMapping(path="param/test.json",params="action=save",headers="uname=a")
	public @ResponseBody String saveUser(@RequestHeader HttpHeaders headers,User u){
		log.info(headers.get("uname"));
		log.info(headers.get("Host"));
		return "param and header";
	}
	
	/**
	 * 请求返回
	 * @return
	 */
	@RequestMapping("/index2")//请求地址
	public String index2(){//string 做视图名 ，到templates去搜索
		log.info("index2方法");
		return "index2.html"; 
	}
	
	@RequestMapping("/index3")//请求地址
	@ResponseBody
	public String index3(){//string 做视图名 ，到templates去搜索
		log.info("index2方法");
		return "index.html"; 
	}
	
	@RequestMapping("/index4")//请求地址
	@ResponseBody
	public Map index4(){//string 做视图名 ，到templates去搜索
		log.info("index2方法");
		Map<String,String> map=new HashMap<String,String>();
		map.put("uname", "zy");
		return map; 
	}
	
	@RequestMapping("/index5")//请求地址
	@ResponseBody
	public Student index5(){//string 做视图名 ，到templates去搜索
		log.info("index2方法");
		Student s=new Student();
		s.setSid(2);
		s.setSname("fzb");
		return s; 
	}

	@RequestMapping("/index6")//请求地址
	@ResponseBody
	public ResponseEntity<Student> index6(){//string 做视图名 ，到templates去搜索
		log.info("index2方法");
		Student s=new Student();
		s.setSid(2);
		s.setSname("fzb");
		
		ResponseEntity<Student> re=new ResponseEntity<Student>(s,HttpStatus.OK);
		return re; 
	}
}
