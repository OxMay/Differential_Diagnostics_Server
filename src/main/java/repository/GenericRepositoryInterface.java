package repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface GenericRepositoryInterface<T> {
    Boolean addObject(T emp) throws SQLException;
    Boolean removeObject(T emp);
    Boolean editObject(Object emp);
    T getObject(Map<String,Object> map);
    T getObject(String columnName, Object columnValue);
    List<T> getAllObjects();
    List<T> getObjects(Map<String,Object> map);
}
