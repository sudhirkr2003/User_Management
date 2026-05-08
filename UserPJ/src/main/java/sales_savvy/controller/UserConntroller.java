package sales_savvy.controller;

import sales_savvy.entity.User;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sales_savvy.dto.UserControllerDto;
import sales_savvy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserConntroller {
	
	UserService userService;	
	public UserConntroller(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/registration")
	public String registration(@RequestBody UserControllerDto user) {
		
		return userService.addUser(user);
	}
	
	@GetMapping("/search/{id}")
	public User search(@PathVariable int id) {
		return userService.search(id);
	}
	
	
	@GetMapping("viewAll")
	public List<User> allUser() {
		return userService.getAll();
	}
	
	@PatchMapping("/update/{id}")
	public String update(@PathVariable int id, @RequestBody User user) {
		return userService.update(id, user);
	}
	
	@DeleteMapping("/delete")
	public String delete(@PathVariable int id) {
		return userService.delete(id);
	}
	
}
