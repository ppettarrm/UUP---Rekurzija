/* Napisati program koji ucitva dva pozitivna cela broja
 i rekurzivnom metodom izracunava njihov najveci zajednicki
 delitelj.
*/

class Treci{
	
	static int nzd(int prvi, int drugi){
		if(prvi==drugi)
			return prvi;
		else if(prvi>drugi)
			return nzd(prvi-drugi, drugi);
		else 
			return nzd(prvi, drugi-prvi);
	}
	
	public static void main(String[] args){
		int n, m;
		do{
			n = Svetovid.in.readInt("Unesite prirodan broj: ");
		}while(n<1);
		do{
			m = Svetovid.in.readInt("Unesite prirodan broj: ");
		}while(m<1);
		
		System.out.println(nzd(n,m));
	}
}
