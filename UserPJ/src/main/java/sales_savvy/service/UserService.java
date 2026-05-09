package sales_savvy.service;

import java.util.List;

import sales_savvy.dto.UserRequestDto;
//import sales_savvy.entity.User;
import sales_savvy.entity.User;

public interface UserService {

	String addUser(UserRequestDto user);

	User search(int id);

	List<User> getAll();

	String update(int id, User user);

	String delete(int id);

}
