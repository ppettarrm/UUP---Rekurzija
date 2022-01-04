/* Program koji ucitava prirodan broj i rekurzivnom metodom ispisuje sve 
cifre unetog broja u obrnutom redosledu.
*/
class Prvi{
	
	static void obrni(int n){
		if(n<10)
			Svetovid.out.print(n + " ");
		else{
			Svetovid.out.print(n%10 + " ");
			obrni(n/10);
		}
	}
	
	public static void main(String[] args){
		int n;
		do{
			n = Svetovid.in.readInt("Unesite prirodan broj: ");
		}while(n<1);
		obrni(n);
	
	}
}
