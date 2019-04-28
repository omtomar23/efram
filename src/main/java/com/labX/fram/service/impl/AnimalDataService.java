package com.labX.fram.service.impl;

import com.labX.fram.datasource.JDBCDataSource;
import com.labX.fram.response.JsonDataset;
import com.labX.fram.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalDataService implements DataService<SQLQuery, JsonDataset> {

    @Autowired
    private JDBCDataSource dataSource;

    public JsonDataset apply(final SQLQuery query){
        return new JsonDataset(dataSource.get(query));
    }
}
