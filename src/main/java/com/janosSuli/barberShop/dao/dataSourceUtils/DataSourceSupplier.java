package com.janosSuli.barberShop.dao.dataSourceUtils;

import com.janosSuli.barberShop.dao.BookedTimeDao;
import com.janosSuli.barberShop.dao.UserDao;
import com.janosSuli.barberShop.dao.dataImplementations.database.BookedTimeDaoDatabase;
import com.janosSuli.barberShop.dao.dataImplementations.database.UserDaoDatabase;
import com.janosSuli.barberShop.dao.dataImplementations.inMemory.BookedTimeDaoInMemory;
import com.janosSuli.barberShop.dao.dataImplementations.inMemory.UserDaoInMemory;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class DataSourceSupplier {

    private final UserDao userDao;
    private final BookedTimeDao bookedTimeDao;

    public DataSourceSupplier(UserDao userDao, BookedTimeDao bookedTimeDao) {

        this.userDao = userDao;
        this.bookedTimeDao = bookedTimeDao;

    }

    public static DataSourceSupplier getInstance(DataSourceTypes daoType) {

        if (daoType == DataSourceTypes.DATABASE) {
            DataSource dataSource = getDataSource();

            return new DataSourceSupplier(new UserDaoDatabase(dataSource),
                    new BookedTimeDaoDatabase(dataSource));
        }
        return new DataSourceSupplier(new UserDaoInMemory(),
                new BookedTimeDaoInMemory());

    }

    private static DataSource getDataSource() {

        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("darkhunter");
        dataSource.setDatabaseName("barberShop");

        return dataSource;

    }

    public UserDao getUserDao() {
        return userDao;
    }

    public BookedTimeDao getBookedTimeDao() {
        return bookedTimeDao;
    }
}
