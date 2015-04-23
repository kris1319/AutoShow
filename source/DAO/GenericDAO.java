package DAO;

import java.util.Collection;
import java.util.List;
import java.lang.*;

public interface GenericDAO <T> {
    void insert(T obj);
    void update(T obj);
    void delete(T obj);
    Collection<T> getAll();
}
