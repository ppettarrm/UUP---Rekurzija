/* Napisati program koji za dati ceo broj n, 0 <= n <= 30, ispisuje vrednost
 elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
 f_n = 2f_n-1 - f_n-2 + f_n-3, n >= 3
 f_2 = 2, f_1 = 1, f_0 = 0
 Element f_n izracunati:
 (a) rekurzivno preko definicije,
 (b) rekurzivno pomocu akumulirajuceg parametra,
 (c) iterativno.
 U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
*/

class Osmi{
	
	static final int N_MAX = 30, N_MIN = 0;
	
	static int fDef(int n){
		if (n <= 2)
			return n;
		else
			return 2*fDef(n-1) - fDef(n-2) + fDef(n-3);
	}
	
	static int fRek1(int f2, int f1, int f0, int n){
		if(n==0)
			return f0;
		else
			return fRek1(2*f2-f1+f0, f2, f1, n-1);
	}
	
	static int fRek2(int n){
		return fRek1(2, 1, 0, n);
	}
	
	static int fIter(int n){
		int fn, f0, f1, f2;
		fn = 0;
		f0 = 0;
		f1 = 1;
		f2 = 2;
		
		if(n==0)
			fn = f0;
		else if(n==1)
			fn = f1;
		else if(n==2)
			fn = f2;
		else{
			for(int i = 3; i <= n; i++){
				fn = 2*f2-f1+f0;
				f0 = f1;
				f1 = f2;
				f2 = fn;
			}
		}
		return fn;
	}
	
	public static void main(String[] args){
		int n;
		do{
			n = Svetovid.in.readInt("Unesite n:");
		}while(!(n>=N_MIN && n<=N_MAX));
		
		Svetovid.out.println(fRek2(n));
		Svetovid.out.println(fDef(n));
		Svetovid.out.println(fIter(n));
	}
}
