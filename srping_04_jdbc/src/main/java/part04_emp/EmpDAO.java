package part04_emp;

import java.util.List;

public interface EmpDAO {
	public List<EmpDTO> list();

	public void insertMethod(EmpDTO dto);

	public void updateMethod(EmpDTO dto);

	public void deleteMethod(int num);

	public EmpDTO one(int num);

	public int countMethod();
}