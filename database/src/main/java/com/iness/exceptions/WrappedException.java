package com.iness.exceptions;

public class WrappedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public WrappedException(Exception e) {
		super(e);
	}

}
