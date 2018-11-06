package jv;

public class Sample {
	public static void main(String[] args) {
		String str = "dfsgdg(dfsdsg)";
		String replaced = str.replaceAll("\\(.*\\)$", "").trim();
		System.out.println("string replaces " + replaced);
	}
}
