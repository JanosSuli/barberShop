package com.janosSuli.barberShop.dao.dataSourceUtils;

import com.janosSuli.barberShop.dao.BookedTimeDao;
import com.janosSuli.barberShop.dao.UserDao;

public class DataSourceManager {

    private static final DataSourceTypes dataSourceType = DataSourceTypes.DATABASE;
    private static final DataSourceSupplier dataSourceSupplier = DataSourceSupplier.getInstance(dataSourceType);
    private static final UserDao userDao = dataSourceSupplier.getUserDao();
    private static final BookedTimeDao bookedTimeDao = dataSourceSupplier.getBookedTimeDao();

    public static DataSourceTypes getDataSourceType() {
        return dataSourceType;
    }

    public static DataSourceSupplier getDataSourceSupplier() {
        return dataSourceSupplier;
    }

    public static UserDao getUserDao() {
        return userDao;
    }

    public static BookedTimeDao getBookedTimeDao() {
        return bookedTimeDao;
    }
}
