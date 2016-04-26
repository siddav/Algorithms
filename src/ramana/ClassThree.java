package ramana;

import jv.ClassOne;

public class ClassThree extends ClassOne {	
	public void someM() {		
	   printMessage();		
	}
	public static void main(String[] args) {
		ClassThree f = new ClassThree();
		f.someM();
	}
}

class ClassFour {
	public void someM() {		
		ClassThree t = new ClassThree();		
	}
}
