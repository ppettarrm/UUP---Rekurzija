/* Napisati program koji ucitava niz celih brojeva i pronalazi
 i ispisuje duzinu najduzeg rastuceg podniza u tom nizu.
 Primer: za niz 2 4 1 6 2 8 1, podniz 2 4 6 8 ima duzinu 4 */

class Sedmi{
	static int nadjiNRP(int[] niz, int index) {
		if (index == 0) {
			return 1;
		}
		else {
			int maxDuzina = 0;
			for (int i = 0; i < index; i++) {
			if (niz[i] < niz[index]) {
			int duzina = nadjiNRP(niz, i);
				if (duzina > maxDuzina) {
				maxDuzina = duzina;
				}
			}
			}
		return maxDuzina + 1;
		}
	 }
	 
	 public static void main(String[] args) {
		System.out.print("Unesite duzinu niza: ");
		int duz = Svetovid.in.readInt();
		int[] niz = new int[duz];
		for(int i = 0; i < niz.length; i++){
			System.out.print("Unesite " + i + ". element niza: ");
			niz[i] = Svetovid.in.readInt();
		}
		int rez = 0;
		for (int i = 0; i < niz.length; i++) {
			int tmp = nadjiNRP(niz, i);
			if (tmp > rez)
				rez = tmp;
		}
		System.out.println("Duzina najduzeg rastuceg podniza je " + rez);
	 }
}


