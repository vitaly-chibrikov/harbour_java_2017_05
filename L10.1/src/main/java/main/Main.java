package main;

import base.DBService;
import base.dataSets.UserDataSet;
import dbService.DBServiceImpl;

import java.util.List;

/**
 * SET GLOBAL time_zone = '+1:00';
 *
 * OR
 *
 *  cd /etc/mysql/
 *  sudo vim my.cnf
 *
 *  add:
 *  [mysqld]
 *  default-time-zone='+00:00'
 *
 *  sudo service mysql restart
 */


public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBServiceImpl();

        String status = dbService.getLocalStatus();
        System.out.println("Status: " + status);

        dbService.save(new UserDataSet("tully"));
        dbService.save(new UserDataSet("sully"));

        UserDataSet dataSet = dbService.read(1);
        System.out.println(dataSet);

        dataSet = dbService.readByName("sully");
        System.out.println(dataSet);

        List<UserDataSet> dataSets = dbService.readAll();
        for (UserDataSet userDataSet : dataSets) {
            System.out.println(userDataSet);
        }

        dbService.shutdown();
    }
}
