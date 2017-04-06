package com.cfm.tiri.services.mapservices;

import com.cfm.tiri.jpa.JPAObject;

import java.util.*;

/**
 * Created by jt on 11/14/15.
 */
public abstract class AbstractMapService  {
    protected Map<Integer, JPAObject> domainMap;

    public AbstractMapService() {
        domainMap = new HashMap<>();
    }

    public List<JPAObject> listAll() {
        return new ArrayList<>(domainMap.values());
    }

    public JPAObject getById(Integer id) {
        return domainMap.get(id);
    }

    public JPAObject saveOrUpdate(JPAObject domainObject) {
        if (domainObject != null){

            if (domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);

            return domainObject;
        } else {
            throw new RuntimeException("Object Can't be null");
        }
    }

    public void delete(Integer id) {
        domainMap.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(domainMap.keySet()) + 1;
    }

}
