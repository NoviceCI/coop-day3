package coop.pratice.beans;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import coop.pratice.domain.User;
import coop.pratice.service.UserService;

@Component
@Scope("session")
public class UserBean implements Serializable {

	@Autowired(required = true)
	private UserService userService;

	public boolean isLogin = false;

	public List<User> users;

	private User user = new User();

	public String doUpdatePage(User user) {
		setUser(user);
		return "doupdatepage";
	}

	public String updateUser() {
		getUserService().updateUser(getUser());
		setUser(new User());
		return "list";
	}

	public void deletUser(User user) {
		getUserService().deleteUser(user);
	}

	public String addUser() {

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

			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("secured/");

				isLogin = true;

				user = userLogin;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL,
							"Fatal! UserName or Passwrod invalid", ""));

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

	public void exportarPDF() throws JRException, IOException {
		Map<String,Object> parametros 	= new  HashMap<String, Object>();
		parametros.put("txtUserio","MidCode");
		
		File jasper = new File(FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("/report.jasper"));
		
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasper.getPath(),parametros,
					new JRBeanCollectionDataSource(this.getUsers()));
	
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.addHeader("Content-disposition","attachment; filename=jsfReporte.pdf");
			ServletOutputStream stream = response.getOutputStream();
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			
			FacesContext.getCurrentInstance().responseComplete();
			
			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().renderResponse();
	}

}
