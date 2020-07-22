package co.micol.lms.board;

public class TestMath {
	private int n;
	private int m;
	
	public TestMath() {
		
	}
	
	public TestMath(int n, int m) { //생성자 - 클래스 명과 동일한 메소드.
		// TODO Auto-generated constructor stub
		this.n = n;
		this.m = m;
	}
	
	public int sum() {
		
		return n + m;
	}
	
	public int sub() {
		int sub;
		if(n >= m) {
			sub = n - m;
		} else {
			sub = m - n;
		}
		return sub;
	}
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	
	
}
