package com.gcu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gcu.business.SecurityBusinessService;

/**
 * Global Exception Handler(s). Used as a fallback when an error occurs, and we don't want to expose any information.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Base Exception handler.
     * @param ex Exception
     * @return servererror
     */
	Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);
    @ExceptionHandler({Exception.class})
    public void handleException(Exception ex) {
       logger.error("Uncaught exception: " + ex);
    }
}