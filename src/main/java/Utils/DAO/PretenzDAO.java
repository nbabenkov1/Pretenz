package Utils.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

/**
 * Created by N.Babenkov on 25.04.2018.
 **/
@Component
public class PretenzDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PretenzDAO(@Qualifier(value = "pretenzJdbc") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void clearTable(String tableName){
        jdbcTemplate.update("DELETE FROM "+tableName);
    }

    public synchronized void makeTransaction(String statement){
        jdbcTemplate.update(statement);
    }

    public void processSelectResult(String selectStatement, ResultSetExtractor<?> resultSetExtractor){
        jdbcTemplate.query(selectStatement, resultSetExtractor);
    }

    public void callProcedure(String procedureName){
        jdbcTemplate.update("CALL  "+ procedureName+"()");
    }
}
