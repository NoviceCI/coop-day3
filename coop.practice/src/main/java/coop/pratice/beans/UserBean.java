package coop.pratice.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import coop.pratice.domain.User;
import coop.pratice.service.UserService;

@Component
@Scope("session")
public class UserBean implements Serializable {

	
}
