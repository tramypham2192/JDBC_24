package model;

import java.time.LocalDate;

public class Product {
	private Long id;
	private String title;
	private String name;
	private String description;
	private LocalDate targetDate;
	private boolean status;
	
	protected Product() {
		
	}
	
	public Product(long id, String title, String name, String description, LocalDate targetDate, boolean status) {
		super();
		this.id= id;
		this.title = title;
		this.description = description;
		this.targetDate = targetDate;
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	}
