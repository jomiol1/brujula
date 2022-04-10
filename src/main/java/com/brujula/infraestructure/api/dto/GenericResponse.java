package com.brujula.infraestructure.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponse {
	
    private Integer statusCode;
    private String message;

}
