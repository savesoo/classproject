package com.firstcoding.fisrtapp.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public class ConnectionUtil {

    // POOL : 데이터베이스 연결정보를 가지고 설정값에 따라 Connection 객체를 생성해서 가지고 관리함
    // pool은 한 개만 만들어놓고 사용
    private HikariDataSource ds; // 소멸이 아니라 이쪽으로 반환만 해주는 것

    // 싱글톤 처리
    private static ConnectionUtil instance = new ConnectionUtil();

    private ConnectionUtil(){

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Class.forName과 동일
        config.setJdbcUrl("jdbc:mysql://localhost:3306/project");
        config.setUsername("scott");
        config.setPassword("test1111*");
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);

        /*
        config.addDataSourceProperty("useServerPrepStmts", true);
        config.addDataSourceProperty("useLocalSessionState", true);
        config.addDataSourceProperty("rewriteBatchedStatements", true);
        config.addDataSourceProperty("cacheResultSetMetadata", true);
        config.addDataSourceProperty("cacheServerConfiguration", true);
        config.addDataSourceProperty("elideSetAutoCommits", true);
        config.addDataSourceProperty("maintainTimeStats", false);
        */

        ds = new HikariDataSource(config);

    }

    // 인스턴스 반환 메소드
    public static ConnectionUtil getInstance(){
        return instance;
    }

    public Connection getConnection() throws Exception{
        return ds.getConnection();
    }
}
