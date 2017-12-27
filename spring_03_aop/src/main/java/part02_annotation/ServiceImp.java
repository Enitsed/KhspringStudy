package part02_annotation;

// 핵심 로직만 구현해 놓은 클래스 - 핵심 관점
public class ServiceImp implements Service {

	@Override
	public void prn1() {
		System.out.println("prn");
	}

	@Override
	public void prn1(int x) {
		System.out.println("x:" + x);
	}

	@Override
	public void prn1(int a, int b) {
		System.out.printf("prn: a=%d, b=%d\n", a, b);
	}

	@Override
	public void prn2() {
		System.out.println("prn2 method");
	}

	@Override
	public String prn3() {
		System.out.println("prn3");
		return "홍길동";
	}

	@Override
	public void prn4() {
		System.out.println("prn4");
		String data = "asd";
		int num = Integer.parseInt(data);
	}

	@Override
	public void prn5() {
		System.out.println("prn5");
	}

}
