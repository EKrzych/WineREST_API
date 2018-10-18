package com.codecool.wineREST.exceptions;

import com.codecool.wineREST.entities.Mail;
import com.codecool.wineREST.services.EmailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

/**
 * Exceptions handler for Exceptions thrown in controllers
 */
@ControllerAdvice
public class ExceptionsHandler {

    private static Logger log = LoggerFactory.getLogger(ExceptionsHandler.class);
    @Autowired
    EmailServiceImpl emailService;

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(FkViolationException.class)
    public void handleFkViolationException(FkViolationException e) {
        log.error("Exception raised: " + e.getMessage() + "[Status code: 409]");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public void handleNoSuchElementException(NoSuchElementException e) {
        log.error("Exception raised: " + e.getMessage() + "[Status code: 404]");
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(ServerErrorException.class)
    public void handleServerErrorException(ServerErrorException e) {
        String errorMessage = "Exception raised: " + e.getMessage() + "[Status code: 501]";
        log.error(errorMessage);
        this.emailService.sendSimpleMessage(new Mail("Status 500 came brace yourself", errorMessage,
                "noreplyspring@wp.pl", "noreplyspring@wp.pl"));
    }
}
