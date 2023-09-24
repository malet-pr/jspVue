package com.example.mock.model;


import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class ToDo {

    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID id;
	private String title;
	private String description;
	private String category;
	private boolean completed = false;
	
}
