package com.example.mock.dto;

import java.io.Serializable;
import java.util.List;
import com.example.mock.model.ToDo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UpdateDTO implements Serializable {

	private static final long serialVersionUID = 6405856713473321274L;
	@Builder.Default
	private boolean success = false;
	private String message;
	private List<ToDo> todos;

}
