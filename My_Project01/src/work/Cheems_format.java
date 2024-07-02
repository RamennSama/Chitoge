package work;

import java.util.ArrayList;

public interface Cheems_format<T> {
	public int Insert(T t);
	public int Update(T t);
	public int Delete(T t);
	public ArrayList<T> selectAll();
	public T selectById(T t);
	public ArrayList<T> selectByCondition(String Condition);
}
