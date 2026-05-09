package sales_savvy.service;

import sales_savvy.entity.User;

import java.util.List;

import org.springframework.stereotype.Service;

import sales_savvy.dto.UserRequestDto;
import sales_savvy.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService
{
	
	UserRepository userRepo;
	public UserServiceImplementation(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@Override
	public String addUser(UserRequestDto user) {
		if(userRepo.findByUsername(user.getUsername()).orElse(null) != null) {
			return "Username is already Exist, Plaese use rdiffrent username";
		}
		
		if(userRepo.findByEmail(user.getEmail()).orElse(null) != null) {
			return "Email is already in use, Plaese use rdiffrent Email";
		}
		User u = new User();
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setAddress(user.getAddress());
		u.setDob(user.getDob());
		u.setDpUrl(user.getDpUrl());
		u.setEmail(user.getEmail());
		u.setGender(user.getGender());
		u.setMobile(user.getMobile());
		
		userRepo.save(u);
		return "User Registered Successfully.";
		
	}

	@Override
	public User search(int id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public String update(int id, User user) {
		User temp = userRepo.findById(id).orElse(null);
		if(temp!=null) {
			userRepo.save(user);
			return "User Updated Successfully";
		}
		return "Wrong User ID";
	}

	@Override
	public String delete(int id) {
		User temp = userRepo.findById(id).orElse(null);
		if(temp!=null) {
			userRepo.deleteById(id);
			return "User Deleted Successfully";
		}
		return "Wrong User ID";
	}
	
	
	
}
