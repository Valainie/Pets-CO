package DAO.user.model;

import bean.PBean;

import java.sql.SQLException;
import java.util.Collection;

public interface DAO {
    public void doSave(PBean product) throws SQLException;

    public boolean doDelete(int code) throws SQLException;

    public PBean doRetrieveByKey(int code) throws SQLException;

    public Collection<PBean> doRetrieveAll(String codice) throws SQLException;


    public  Collection<PBean> doRetrieveByResearch (String ric) throws SQLException;




}

