package com.iness.dao;

public class DAOException extends RuntimeException {
	 public DAOException(String str, Throwable throwable) {
        super(str, throwable);
    }

    public DAOException(Throwable throwable) {
        super(throwable);
    }

    public DAOException(String str) {
        super(str);
    }

    public DAOException() {
        super();
    }
}
