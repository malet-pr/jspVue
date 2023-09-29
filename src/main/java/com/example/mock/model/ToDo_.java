package com.example.mock.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ToDo.class)
public abstract class ToDo_ {

	public static volatile SingularAttribute<ToDo, Long> id;
	public static volatile SingularAttribute<ToDo, String>  title;
	public static volatile SingularAttribute<ToDo, String>  descriptionShort;
	public static volatile SingularAttribute<ToDo, String>  descriptionLong;
	public static volatile SingularAttribute<ToDo, String>  category;
	public static volatile SingularAttribute<ToDo, Boolean>  completed;
	
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String DESCRIPTION_SHORT = "descriptionShort";
	public static final String DESCRIPTION_LONG = "descriptionLong";
	public static final String CATEGORY = "category";
	public static final String COMPLETED = "completed";
	
}
