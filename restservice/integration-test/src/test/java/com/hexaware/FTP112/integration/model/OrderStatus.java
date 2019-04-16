package com.hexaware.FTP112.integration.model;
import com.hexaware.FTP112.integration.util.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
/**
 * Enum to represent the Order status.
 * @author hexaware
 * @version 1.0
 */
public enum OrderStatus {
    /** Pending status. */
    PENDING,
    /** Accepted status. */
    ACCEPTED,
    /** Denied status. */
    DENIED
}
