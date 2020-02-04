package com.example.demo99;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.jdbc.pool.ConnectionPool;
import org.apache.tomcat.jdbc.pool.JdbcInterceptor;
import org.apache.tomcat.jdbc.pool.PooledConnection;

import java.sql.SQLException;

public class SampleInterceptor extends JdbcInterceptor {
    private static final Log log = LogFactory.getLog(SampleInterceptor.class);
    protected PooledConnection connection = null;
    protected ConnectionPool pool = null;
    @Override
    public void reset(ConnectionPool connectionPool, PooledConnection pooledConnection) {
        // 何もしない
    }

    public void disconnected(ConnectionPool parent, PooledConnection con, boolean finalizing) {
        log.warn("Connection is disconnected.");
        log.warn("pool connecction size[" + parent.getSize() + "] MinIdle [" + parent.getPoolProperties().getMinIdle() + "]");
        super.disconnected(parent, con, finalizing);
    }
}
