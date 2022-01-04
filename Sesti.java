/* Naucnik se bavi stvaranjem svih mogucih lanaca 
 duzine n sastavljenih od atoma plutonijuma i olova, 
 tako da ni jedan lanac ne moze da izazove atomsku 
 eksploziju. Do eksplozije bi doslo ako bi se u lancu 
 jedan do drugog nasla dva atoma plutonijuma. Koliko 
 "bezbednih" lanaca duzine n moze da stvori naucnik? */

class Sesti{
	static int L(int n) {
		if (n == 1)
			return 2;
		else if (n == 2)
			return 3;
		else
			return L(n-1) + L(n-2);
		} 
	public static void main(String[] args) {
		System.out.print("Unesite duzinu lanca: ");
		int n = Svetovid.in.readInt();
		System.out.print("L(" + n + ") = " + L(n));
	}
}
