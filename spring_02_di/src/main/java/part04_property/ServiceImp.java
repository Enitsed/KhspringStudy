package part04_property;

import java.util.Random;

public class ServiceImp implements Service {
	private String name;
	private Random ran;

	public ServiceImp() {

	}

	public ServiceImp(String name) {
		this.name = name;
	}

	public ServiceImp(Random ran) {
		this.ran = ran;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Random getRan() {
		return ran;
	}

	public void setRan(Random ran) {
		this.ran = ran;
	}

	@Override
	public void prn1() {
		System.out.println("name:" + name);
	}

	@Override
	public void prn2() {
		System.out.println("ran:" + ran.nextInt());
	}

}
