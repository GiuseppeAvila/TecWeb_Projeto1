package br.edu.insper.mvc.model;

public class Tasks {
	
	private Integer id;
	
	private String title;
	
	private String creator;
	
	private String tag;

	public Integer getId() { return this.id; }
	public void setId(Integer id) {	this.id = id; }
	
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }

	public String getCreator() { return this.creator; }
	public void setCreator(String creator) { this.creator = creator; }
	
	public String getTag() { return this.tag; }
	public void setTag(String tag) { this.tag = tag; }
		
}
