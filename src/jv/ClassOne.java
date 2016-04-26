package jv;

public class ClassOne {
	protected void printMessage() {
		System.out.println(this.getClass().getCanonicalName() + " msg");
	}
}
