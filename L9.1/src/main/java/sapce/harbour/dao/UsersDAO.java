package sapce.harbour.dao;

import sapce.harbour.handlers.TResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import sapce.harbour.dataSets.UsersDataSet;
import sapce.harbour.executor.TExecutor;

public class UsersDAO {

    private Connection connection;

    public UsersDAO(Connection connection) {
        this.connection = connection;
    }

    public UsersDataSet get(long id) throws SQLException {
        TExecutor exec = new TExecutor(connection);
        return exec.execQuery("select * from users where id=" + id, new TResultHandler<UsersDataSet>() {

            public UsersDataSet handle(ResultSet result) throws SQLException {
                result.next();
                return new UsersDataSet(result.getLong(1), result.getString(2));
            }

        });
    }
}
