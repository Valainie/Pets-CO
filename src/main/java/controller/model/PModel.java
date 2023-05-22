package controller.model;

import bean.PBean;

import java.sql.SQLException;
import java.util.Collection;

public interface PModel {
    public void doSave(PBean product) throws SQLException;

    public boolean doDelete(int code) throws SQLException;

    public PBean doRetrieveByKey(int code) throws SQLException;

    public Collection<PBean> doRetrieveAll(String order) throws SQLException;
}

