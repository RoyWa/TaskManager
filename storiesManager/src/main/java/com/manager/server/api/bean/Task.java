package com.manager.server.api.bean;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

public class Task implements Serializable {
    private static final long serialVersionUID = -9130603850117689481L;
    private String number;
    private String short_description;
    
    public Task() {} // needed for JAXB
    
    public Task(String number, String short_description) {
        this.number = number;
        this.short_description = short_description;
    }

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the short_description
	 */
	public String getShort_description() {
		return short_description;
	}

	/**
	 * @param short_description the short_description to set
	 */
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
    

}