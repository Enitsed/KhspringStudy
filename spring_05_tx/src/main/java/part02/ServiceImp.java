package part02;

public class ServiceImp implements Service {
	private MemDAO dao;

	public ServiceImp() {

	}

	public void setDao(MemDAO dao) {
		this.dao = dao;
	}

	@Override
	public void insertProcess() {
		dao.insertMethod(new MemDTO(46, "용팔이", 50, "경기"));
		dao.insertMethod(new MemDTO(47, "유대위", 20, "대전"));
	}

}
