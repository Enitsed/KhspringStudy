package part02_constructor;

import java.util.Random;

public class ServiceImp implements Service {
	private String name;
	private int age;
	private String dept;
	private Random ran;

	public ServiceImp() {

	} // end constructor

	public ServiceImp(String name) {
		this.name = name;
	}

	public ServiceImp(int age, String dept) {
		this.age = age;
		this.dept = dept;
	}

	public ServiceImp(Random ran) {
		this.ran = ran;
	}

	@Override
	public void prn1() {
		System.out.println("name: " + name);
	}

	@Override
	public void prn2() {
		System.out.printf("%d %s\n", age, dept);
	}

	@Override
	public void prn3() {
		System.out.println("random:" + ran.nextInt());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Random getRan() {
		return ran;
	}

	public void setRan(Random ran) {
		this.ran = ran;
	}

} // end class
