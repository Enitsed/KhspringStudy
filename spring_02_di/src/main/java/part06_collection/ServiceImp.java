package part06_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ServiceImp {
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

} // end class
