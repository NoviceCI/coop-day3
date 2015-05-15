package coop.pratice.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import coop.pratice.domain.User;
import coop.pratice.service.UserService;

@Component
@Scope("session")
public class UserBean implements Serializable {


	@Autowired(required=true)
	private UserService userService;

	public boolean isLogin = false;
	
	public List<User> users  ;

	private User user = new User();
	
	
	
	public String doUpdatePage(User user){
		setUser(user);
		return "doupdatepage";
	}
	
	public String updateUser(){
		getUserService().updateUser(getUser());
		setUser(new User());
		return "list";
	}
	
	public void deletUser(User user){
		getUserService().deleteUser(user);
	}
	
	public String addUser(){
		
		getUserService().addUser(user);
		setUser(new User());
		return "list";
	}
	
	public List<User> getUsers() {
		return getUserService().getUsers();
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void login() {
		
		
		

		User userLogin = getUserService().login(user);

		if (userLogin.getId() != -1) {

		} else {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal! UserName or Passwrod invalid",
							""));

		}

	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
