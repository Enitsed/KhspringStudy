package part06_collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ServiceImp implements Service {
	private List<Integer> list;
	private Map<String, Integer> map;
	private Set<String> set;
	private Properties prop;

	public ServiceImp() {
	}

	public ServiceImp(List<Integer> list) {
		this.list = list;
	}

	public ServiceImp(Map<String, Integer> map) {
		this.map = map;
	}

	public ServiceImp(Set<String> set) {
		this.set = set;
	}

	public ServiceImp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public void prn1() {
		for (int num : list) {
			System.out.println(num);
		}
	}

	@Override
	public void prn2() {
		Set<String> set = map.keySet();
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			Integer value = map.get(key);
			System.out.printf("%s %d \n", key, value);
		}
	}

	@Override
	public void prn3() {
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
	}

	@Override
	public void prn4() {
		Set<Object> set = prop.keySet();
		Iterator<Object> ite = set.iterator();
		while (ite.hasNext()) {
			Object key = ite.next();
			Object value = prop.get(key);
			System.out.printf("%s %s \n", key, value);
		}
	}

} // end class
