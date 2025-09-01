package it.grupposnai.paymatservices.util;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.apache.log4j.Logger;

public class JSonUtil {

    private static final Logger logger = Logger.getLogger(JSonUtil.class);

    //private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(new Jdk8Module());
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> String serialize(T entity) {
        try {
            return OBJECT_MAPPER.writeValueAsString(entity);
        } catch (Exception e) {
            logger.error("Error serialize object msg: " + e.getMessage());
            return null;
        }
    }
}
