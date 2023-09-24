package com.example.mock.model;

import jakarta.annotation.ManagedBean;
import lombok.Data;


@Data
@ManagedBean("todo")
public class ToDo {

	private Long id;
	private String title;
	private String description;
	private String category;
	private boolean completed = false;
	
}
