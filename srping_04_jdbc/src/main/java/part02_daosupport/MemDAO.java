package part02_daosupport;

import java.util.List;

public interface MemDAO {
	public List<MemDTO> list();

	public void insertMethod(MemDTO dto);

	public void updateMethod(MemDTO dto);

	public void deleteMethod(int num);

	public MemDTO one(int num);

	public int countMethod();
}