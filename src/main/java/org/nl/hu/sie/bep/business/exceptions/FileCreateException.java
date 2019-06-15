package org.nl.hu.sie.bep.business.exceptions;

public class FileCreateException extends Exception {

    public FileCreateException(String msg, Throwable e){
        super(msg, e);
    }
}