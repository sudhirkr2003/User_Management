package sales_savvy.service;

import java.util.List;

import sales_savvy.dto.UserControllerDto;
//import sales_savvy.entity.User;
import sales_savvy.entity.User;

public interface UserService {

	String addUser(UserControllerDto user);

	User search(int id);

	List<User> getAll();

	String update(int id, User user);

	String delete(int id);

}
