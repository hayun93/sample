package ¡§«œ¿±;

public class ProgTest1 {
	public static int cVar=0;
	String[] iStr= {"0","1","2","3","4","5","6","7","8","9"};
	double iDouble;
	boolean iBool=false;
	char iChar='a';
	
	String getGugudan(int dan) {
		String str="";
		for(int i=1;i<=9;i++) {
			str+=dan+"*"+i+"="+dan*i+"\t";
		}
		return dan+"¥‹:\n"+str;
	}
	
	public static void main(String[] args) {
		ProgTest1 pt = new ProgTest1();
		System.out.println(pt.getGugudan(6));
	}
	
}
