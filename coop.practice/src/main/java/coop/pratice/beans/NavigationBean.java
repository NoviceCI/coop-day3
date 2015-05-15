package coop.pratice.beans;

import java.io.Serializable;

public class NavigationBean implements Serializable {

	
	public String navToProduct(){
		return "products" ;
	}
	
	public String navToProductTypes(){
		return "producttypes";
	}
	
	
}