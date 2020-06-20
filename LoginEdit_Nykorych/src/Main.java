
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		HashMap<Integer, Osoba> PohlM = new HashMap<Integer, Osoba>();
		//HashMap<Integer, HashMap> PohlZ = new HashMap<Integer, HashMap>();
		String jmeno = "",prijmeni = "";
		Osoba OBezJmena = new Osoba(null, null);
		Osoba OJm = new Osoba(jmeno, prijmeni, null, null);
		
		Scanner sc = new Scanner(System.in);
		String VyberP = "";
		
		
		System.out.println("Vitejte! \nVyberte si pohlavi:");
		System.out.println("1 ... Muz");
		System.out.println("2 ... Zena");
		VyberP = sc.nextLine();
		while (!VyberP.matches("[(1|2)]")) {
			System.out.println("Spatny vyber! Vyberte si pohlavi:");
			System.out.println("1 ... Muz");
			System.out.println("2 ... Zena");
			VyberP = sc.nextLine();
		}
		
			String email = null;
			System.out.println("Chces zadat svoje jmeno a prijmeni?");
			System.out.println("1 ... Ano");
			System.out.println("2 ... Ne");
			String Vybern1 = sc.nextLine();
			
			if(Vybern1.matches("[(1|Ano)]")) {
				System.out.println("Zadejte svoje jmeno:");
				jmeno = sc.nextLine();
				OJm.setJmeno(jmeno);
				
				System.out.println("Zadejte svoje prijmeni: ");
				prijmeni = sc.nextLine();
				OJm.setPrijmeni(prijmeni);
				
				System.out.println("Zadali jste to spravne? Jestli ne tak to muzete prepsat.");
				System.out.println(OJm.getJmeno());
				System.out.println(OJm.getPrijmeni());
				
				System.out.println("1 ... Ano");
				System.out.println("2 ... Ne");
				
				String sprav = sc.nextLine();
				
				while(!sprav.matches("[(1|Ano)]")) {
					System.out.println("Zadejte svoje jmeno:");
					jmeno = sc.nextLine();
					OJm.setJmeno(jmeno);
					
					System.out.println("Zadejte svoje prijmeni: ");
					prijmeni = sc.nextLine();
					OJm.setPrijmeni(prijmeni);
					System.out.println("Zadali jste to spravne? Jestli ne tak to muzete prepsat.");
					
					System.out.println(OJm.getJmeno());
					System.out.println(OJm.getPrijmeni());
					
					System.out.println("1 ... Ano");
					System.out.println("2 ... Ne");

					sprav = sc.nextLine();
				}
			}
			
			
			System.out.println("Muzou se zadavat jenom ceske(.cz) nebo mezinarodni(.com) emaily.");
			System.out.println("Zadejte svuj email: ");
			email = sc.nextLine();
			while (!email.matches("[a-zA-z0-9]+@[a-z]+[.](cz|com)")) {
				System.out.println("Spatny email! Prosim zadejte jeste jednou: ");
				System.out.println("Zadejte svuj email: ");
				email = sc.nextLine();
				
			}
			
			if(Vybern1.matches("[(1|Ano)]")) {
				OJm.setEmail(email);
			}else {
				OBezJmena.setEmail(email);
			}
			
			System.out.println("Zadejte svoje heslo (min. 8 míst dlouhé) : ");
			String passw = sc.nextLine();
			while (!passw.matches("[a-zA-Z0-9]{8,}")) {
				System.out.println("Spatne zadani hesla! Zkuste jeste jednou: ");
				passw = sc.nextLine();
			}
			
			if(Vybern1.matches("[(1|Ano)]")) {
				OJm.setPasw(passw);
			}else {
				OBezJmena.setPasw(passw);
			}
			
			if(Vybern1.matches("[(1|Ano)]")) {
				PohlM.put(1, OJm);
				System.out.println(PohlM.get(1));
			}else {
				PohlM.put(1, OBezJmena);
				System.out.println(PohlM.get(1));
			}
			
		System.out.println("Pro prihlaseni zadejte svuj email: ");
		String zemail = sc.next();
		
		String OJem = OJm.getEmail();
		String OBJem = OBezJmena.getEmail();
		
		String OJpa = OJm.getPasw();
		String OBJpa = OBezJmena.getPasw();
		int pocPokusu = 3;
		while(!zemail.equals(OBJem) && !zemail.equals(OJem)) {
			System.out.println("Zadal jsi spatne email, zkus to znovu :");
			zemail = sc.next();
		}
			System.out.println("Zadej password: ");
			String zpass = sc.next();
			while(!zpass.equals(OBJpa) && !zpass.equals(OJpa)&&pocPokusu>0) {
				System.out.println("Zadane heslo je nespravne\nZkuste to znovu");
				zpass = sc.next();
				pocPokusu--;
			}
			if(pocPokusu==0) 
				System.out.println("Zadali jste prilis mnoho krat heslo nespravne");
			else
				System.out.println("Prihlasil ses!");
			
			
		
		
	}

}