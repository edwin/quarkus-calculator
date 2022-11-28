package com.redhat.example.service;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <pre>
 *     com.redhat.example.service.CalculateService
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Nov 2022 15:15
 */
@ApplicationScoped
public class CalculateService {

    private static final Logger LOG = Logger.getLogger(CalculateService.class);

    @Inject
    DatabaseService databaseService;

    public Long calculate(Long value1, String method, Long value2 ) {
        LOG.debug(String.format("Calculating %s %s %s ", value1, method, value2));

        Long result = 0L;
        switch (method) {
            case "addition" :
                result = Math.addExact(value1, value2);
                break;
            case "subtraction" :
                result = Math.subtractExact(value1, value2);
                break;
            case "multiplication" :
                result = Math.multiplyExact(value1, value2);
                break;
            case "division" :
                result = Math.floorDiv(value1, value2);
                break;
            default:
        }

        databaseService.persist( value1, method, value2, result);
        return result;
    }
}
