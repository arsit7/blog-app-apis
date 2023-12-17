package com.codewithdurgesh.blog.blogappapis.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ResourceNotFOundException extends RuntimeException {

	String resoureceName;
	String filedName;
	long fieldvalue;

	public ResourceNotFOundException(String resoureceName, String filedName, long fieldvalue) {
		super(String.format("%s not found with% s :  %l", resoureceName, filedName, fieldvalue));
		this.resoureceName = resoureceName;
		this.filedName = filedName;
		this.fieldvalue = fieldvalue;
	}

}
