package name.max.musiclibrary.dao;

import java.util.List;

public interface DAO<T> {

	void save(T t);

	T getByID(long id);

	List<T> getAll();

}
