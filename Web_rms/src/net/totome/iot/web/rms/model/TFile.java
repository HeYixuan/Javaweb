package net.totome.iot.web.rms.model;

/**
 * Tfile entity. @author MyEclipse Persistence Tools
 */

public class TFile implements java.io.Serializable {

	// Fields

	private Integer id;
	private String fileName;
	private Integer size;
	private String type;
	private String url;
	private String description;
	private String cdate;

	// Constructors

	/** default constructor */
	public TFile() {
	}

	/** full constructor */
	public TFile(String fileName, Integer size, String type, String url,
			String description, String cdate) {
		this.fileName = fileName;
		this.size = size;
		this.type = type;
		this.url = url;
		this.description = description;
		this.cdate = cdate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

}