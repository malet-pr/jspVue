package com.example.mock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity(name="to_do")
public class ToDo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name="title")
	private String title;
    @Column(name="description_short")
	private String descriptionShort;
    @Column(name="description_long")
	private String descriptionLong;
    @Column(name="category")
	private String category;
    @Column(name="finished")
	private Boolean finished;

}
