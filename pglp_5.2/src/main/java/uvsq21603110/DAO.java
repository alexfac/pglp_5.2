package uvsq21603110;

import java.sql.Connection;

public interface DAO<T> {

  Connection connect = null;

  public abstract T create(T obj);

  public abstract T find(String id);

  public abstract T update(T obj);

  public abstract void delete(T obj);
}
