package com.redhat.example.service;

import com.redhat.example.entity.Calculator;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

/**
 * <pre>
 *     com.redhat.example.service.DatabaseService
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 28 Nov 2022 15:17
 */
@ApplicationScoped
@Transactional
public class DatabaseService {
    private static final Logger LOG = Logger.getLogger(DatabaseService.class);

    public void persist(Long value1, String method, Long value2, Long total ) {
        LOG.debug(String.format("saving to DB value1 = %s, method %s, value2 = %s ", value1, method, value2));
        Calculator.persist(new Calculator(value1, method, value2, total));
    }

    public List<Calculator> getResult() {
        LOG.debug(String.format("getting all table result"));
        return Calculator.findAll(Sort.by("id", Sort.Direction.Descending))
                .page(Page.ofSize(5))
                .list();
    }
}
