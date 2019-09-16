package cn.kgc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.kgc.mapper.UserMapper;
import cn.kgc.mapper.impl.MapperImpl;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kgc.entity.User;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	private SqlSession session = new MapperImpl().Factory();
	private UserMapper mapper = session.getMapper(UserMapper.class);
	private ModelAndView modelAndView = new ModelAndView("UserList");

	public UserMapper getMapper() {
		return mapper;
	}

	public HelloController() throws IOException {
	}

	private void update(User user) {
		User tmp= mapper.get(user.getId());
		tmp.setName(user.getName());
		tmp.setAddr(user.getAddr());
		mapper.update(tmp);
		session.commit();
	}

	private User get(int id) {
		User user= mapper.get(id);
		return user;
	}

	private void delete(int id) {
		mapper.delete(id);
		session.commit();
	}

	private void add(User user) {
		mapper.add(user);
		session.commit();
	}

	private List<User> listAll() {
		List<User> users = mapper.list();
		return users;
	}

	@RequestMapping("/test")//表示用户请求/world就能到该方法
	public String hello( ) {
		System.out.println("hello controller");
		
		return "UserList";///WEB-INF/jsp/UserList.jsp
	}

	@RequestMapping("/Users")
	public ModelAndView UsersList() {
		//调用service获取到数据，如何将数据传到页面
		List<User> users = listAll();
		modelAndView.addObject("users",users);
		return modelAndView;///WEB-INF/jsp/UserList.jsp
	}


	@RequestMapping("/addUser")
	public ModelAndView addUser(User user) {
		add(user);
		List<User> users = listAll();
		modelAndView.addObject("users",users);
		return modelAndView;///WEB-INF/jsp/UserList.jsp
	}
	
	@RequestMapping("/User/{id}")
	public ModelAndView selectById(@PathVariable Integer id) {
		User user = get(id);
		modelAndView.setViewName("User");
		modelAndView.addObject("user",user);
		return modelAndView;///WEB-INF/jsp/UserList.jsp
	}
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteById(@PathVariable Integer id) {
		delete(id);
		List<User> users = listAll();
		modelAndView.setViewName("UserList");
		modelAndView.addObject("users",users);
		return modelAndView;///WEB-INF/jsp/UserList.jsp
	}
	@RequestMapping("/updataUser")
	public ModelAndView updataUser(User user) {
		update(user);
		List<User> users = listAll();
		modelAndView.addObject("users",users);
		return modelAndView;///WEB-INF/jsp/UserList.jsp
	}
	@RequestMapping("/updata")
	public ModelAndView updataPage(User user) {
		ModelAndView modelAndView2 = new ModelAndView("updata");
		modelAndView2.addObject("user",user);
		return modelAndView2;///WEB-INF/jsp/UserList.jsp
	}
}
