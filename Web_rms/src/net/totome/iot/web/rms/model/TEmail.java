package net.totome.iot.web.rms.model;

/**
 * TEmail entity. @author MyEclipse Persistence Tools
 */

public class TEmail implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String securityNumber;
	private Integer status;
	private String sendTime;
	private String desc;

	// Constructors

	/** default constructor */
	public TEmail() {
	}

	/** full constructor */
	public TEmail(String email, String securityNumber, Integer status,
			String sendTime, String desc) {
		this.email = email;
		this.securityNumber = securityNumber;
		this.status = status;
		this.sendTime = sendTime;
		this.desc = desc;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecurityNumber() {
		return this.securityNumber;
	}

	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}