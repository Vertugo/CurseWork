package sample.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alex on 02.12.2016.
 */
public interface TResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
