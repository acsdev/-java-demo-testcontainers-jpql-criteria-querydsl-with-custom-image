package eti.query.demonstration.util;

public class DataDomain<D> {

    private D data;

    private String sql;

    public DataDomain(D data, String sql) {
        this.data = data;
        this.sql = sql;
    }

    public D getData() {
        return data;
    }

    public String getSql() {
        return sql;
    }
}
