package br.edu.norvana.business;

public class BusinessException extends Exception{

	private static final long serialVersionUID = -4020587482316629377L;

	public BusinessException(String error){
		super(error);
	}
	

}
