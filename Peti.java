/* Program koji ucitava rastuci niz celih brojeva duzine duz i
 jos jedan broj, i rekurzivnom metodom binarnog pretrazivanja
 pronalazi trazeni broj u nizu i ispisuje njegovu poziciju. Ukoliko
 se trazeni broj ne nalazi u nizu, ispisati odgovarajucu poruku. */
 
class Peti{
	
	static int binSearch(int[] n, int levi, int desni, int broj){
		if(levi>desni)
			return -1;
		else{
			int srednji = (levi + desni) / 2;
			if(n[srednji]==broj)
				return srednji;
			else if(n[srednji]>broj)
				return binSearch(n, levi, srednji-1, broj);
			else
				return binSearch(n, srednji+1, desni, broj);
		}
	}
	
	public static void main(String[] args){
		System.out.print("Unesite broj elemenata u monotono rastucem nizu: ");
		int duz = Svetovid.in.readInt();
		int[] niz = new int[duz];
		for (int i = 0; i < niz.length; i++) {
		do {
		System.out.print("Unesite " + i + ". element niza: ");
		niz[i] = Svetovid.in.readInt();
		} while (!(i == 0 || niz[i-1] < niz[i]));
		}
		System.out.print("Unesite broj koji treba pronaci: ");
		int broj = Svetovid.in.readInt();
		int poz = binSearch(niz, 0, duz-1, broj);
		if (poz == -1) {
		System.out.println("Broj se ne nalazi u nizu");
		}
		else {
		System.out.println("Broj je na poziciji " + poz);
		}
	}
}
