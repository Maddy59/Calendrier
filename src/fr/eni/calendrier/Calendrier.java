package fr.eni.calendrier;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Calendrier {

	private static void afficherMois(int année, int mois) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.clear();
		calendar.set(année, mois, 01);
		// imprime l'entête
		System.out
				.println("* "
						+ calendar.getDisplayName(Calendar.MONTH,
								Calendar.LONG_FORMAT, Locale.FRANCE)
						+ " " + année + " *");
		int premierJourDeLaSemaine = calendar.get(Calendar.DAY_OF_WEEK);
		int nombreDeJourMois = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weekdayIndex = 0;

		// imprime le tableau calendaire
		System.out.println("Di  Lu  Ma  Me  Je  Ve  Sa");
		for (int day = 1; day < premierJourDeLaSemaine; day++) {
			System.out.print("    ");
			weekdayIndex++;
		}
		for (int day = 1; day < nombreDeJourMois; day++) {
			System.out.printf("%1$2d", day);
			weekdayIndex++;
			if (weekdayIndex == 7) {
				weekdayIndex = 0;
				System.out.println();
			} else {
				System.out.print("  ");
			}
		}
		System.out.println();
	}
	public static void menu() {
		System.out.println(" Bonjour, quel calendrier voulez-vous obtenir?");
		System.out.println("***********************************************");
		System.out.println("Pour consulter le mois précédent, entrez : 1 ");
		System.out.println("Pour consulter le mois suivant, entrez : 2 ");
		System.out.println(
				"Pour consulter le mois et l'année de votre choix, entrez : 3 ");
		System.out.println("Pour sortir de l'exercice, entrez : 4 ");
	}

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		int choixUtilisateur;
		do {
			afficherMois(calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH));
			menu();
			Scanner scanner = new Scanner(System.in);
			choixUtilisateur = scanner.nextInt();
			switch (choixUtilisateur) {
				case 1 :
					calendar.add(GregorianCalendar.MONTH, -1);
					break;
				case 2 :
					calendar.add(GregorianCalendar.MONTH, +1);
					break;
				case 3 :
					System.out.println("Quelle année ?");
					int choixAnnee = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Quel mois ?");
					int choixMois = scanner.nextInt();
					scanner.nextLine();
					calendar.set(choixAnnee, choixMois - 1, 1);
					break;
				case 4 :
					System.exit(0);
					break;
				default :
					System.err.println("Choix non valide");
					break;
			}
		} while (choixUtilisateur != 4);
	}
}
