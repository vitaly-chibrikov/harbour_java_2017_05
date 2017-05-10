package sapce.harbour.main;

import sapce.harbour.examples.*;

/**
 * mysql> CREATE USER 'tully'@'localhost' IDENTIFIED BY 'tully';
 * mysql> GRANT ALL PRIVILEGES ON * . * TO 'tully'@'localhost';
 * mysql> select user, host from mysql.user;
 * mysql> create database db_example;
 */

public class Main {
    public static void main(String[] args) {
        ConnectionHelper.example();

        ConnectWithStatements.example();
        //PreparedExample.example();
        //TExample.example();
        //DataSetExample.example();
    }
}
