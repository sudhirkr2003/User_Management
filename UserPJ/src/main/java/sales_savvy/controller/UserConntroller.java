package sales_savvy.controller;

import sales_savvy.entity.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sales_savvy.dto.UserRequestDto;
import sales_savvy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserConntroller {
	
	UserService userService;	
	public UserConntroller(UserService userService) {
		super();
		this.userService = userService;
	}


	@PostMapping("/registration")
	public String registration(@RequestBody UserRequestDto user) {
		
		return userService.addUser(user);
	}
	
	@GetMapping("/search/{id}")
	public UserRequestDto search(@PathVariable int id) {
		User user = userService.search(id);
		
		UserRequestDto userDto = new UserRequestDto();
		userDto.setUsername(user.getUsername());
		userDto.setMobile(user.getMobile());
		userDto.setEmail(user.getEmail());
		userDto.setDob(user.getDob());
		userDto.setGender(user.getGender());
		userDto.setAddress(user.getAddress());
		userDto.setDpUrl(user.getDpUrl());
		userDto.setPassword("************");
		return userDto;
		
	}
	
	
	@GetMapping("viewAll")
	public List<UserRequestDto> allUser() {
		List<User> list = userService.getAll();

		List<UserRequestDto> dtoList = new ArrayList<>();

		for(User u : list) {

			UserRequestDto dto = new UserRequestDto(
					u.getUsername(),
					"**************",
					u.getMobile(),
					u.getEmail(),
					u.getDob(),
					u.getGender(),
					u.getAddress(),
					u.getDpUrl()
			);

			dtoList.add(dto);
		}

		return dtoList;
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
