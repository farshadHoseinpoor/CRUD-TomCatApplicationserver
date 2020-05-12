package common;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;

/**
 ** factory design pattern
 */
public class JDBC {
    private static BasicDataSource FARSHAD_DATA_SOURCE = new BasicDataSource();
    private static BasicDataSource ALI_DATA_SOURCE = new BasicDataSource();
    public static final int FARSHAD = 1;

    static {
        FARSHAD_DATA_SOURCE.setUsername("farshad");
        FARSHAD_DATA_SOURCE.setPassword("myjava123");
        FARSHAD_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        FARSHAD_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        FARSHAD_DATA_SOURCE.setMaxTotal(50);
        ALI_DATA_SOURCE.setUsername("ali");
        ALI_DATA_SOURCE.setPassword("ali1372");
        ALI_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1524:xe");
        ALI_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ALI_DATA_SOURCE.setMaxTotal(40);
    }

    public static Connection getConnection(int dataSourceName) throws Exception {
        switch (dataSourceName) {
            case FARSHAD:
                return FARSHAD_DATA_SOURCE.getConnection();
            default:
                return ALI_DATA_SOURCE.getConnection();
        }
    }
}
