package DAO;

import bean.Bean;

import java.sql.SQLException;
import java.util.Collection;

public interface DAO {
    void doSave(Bean bean) throws SQLException;

    Bean doDelete(String code) throws SQLException;
    Bean doRetrieveByKey(Object codice) throws SQLException;

    Collection<Bean> doRetrieveAll(String codice) throws SQLException;


    Collection<Bean> doRetrieveByResearch (String ric) throws SQLException;




}

