package com.labX.fram.command.impl;

import com.labX.fram.command.Command;
import com.labX.fram.response.Dataset;
import com.labX.fram.request.impl.AnimalSearchRequest;
import com.labX.fram.service.DataService;
import com.labX.fram.service.DataServiceNameResolver;
import com.labX.fram.service.impl.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.labX.fram.service.DataServiceFactory;

@Component
public class SearchCommand implements Command<AnimalSearchRequest, Dataset<?>> {

    @Autowired
    private DataServiceFactory dataServiceFactory;

    public Dataset<?> apply(final AnimalSearchRequest request){
        DataService<SQLQuery, Dataset<?>> dataService =  dataServiceFactory.resolve(DataServiceNameResolver.resolve("animal"));
        return dataService.apply(new SQLQuery());
    }
}
