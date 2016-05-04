package footballRest;

import java.util.ArrayList;

/**
 *
 * @author Vita
 */

public interface FieldList {
	public int getCount();
	public void setCount(int count);
	public ArrayList<Field> getFieldList();
	public void setList(ArrayList<Field> fieldList);
    public void add(Field field);
}