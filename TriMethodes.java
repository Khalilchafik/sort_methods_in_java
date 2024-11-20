/* 
    *Auteur khalil CHAFIK
*/
import java.util.Random;

public class TriMethodes {
    // Tri par insertion
    public static void triInsertion(Element[] tab) {
        for (int i = 1; i < tab.length; ++i) {
            Element cle = tab[i];
            int j = i - 1;
            while (j >= 0 && tab[j].getCle() > cle.getCle()) {
                tab[j + 1] = tab[j];
                j = j - 1;
            }
            tab[j + 1] = cle;
        }
    }
    
    // tri par dénombrement
    public static void triDenombrement(Element[] tab, int taille) {
        int max = tab[0].getCle();
        for (int i = 0; i < taille; i++) {
            if (tab[i].getCle() > max)
                max = tab[i].getCle();
        }

        Element[] N = new Element[taille];
        int[] occurrences = new int[max + 1];

        for (int i = 0; i <= max; i++)
            occurrences[i] = 0;

        for (int i = 0; i < taille; i++) {
            occurrences[tab[i].getCle()]++;
        }

        for (int i = 1; i <= max; i++)
            occurrences[i] += occurrences[i - 1];

        for (int i = taille - 1; i >= 0; i--) {
            occurrences[tab[i].getCle()]--;
            N[occurrences[tab[i].getCle()]] = tab[i];
        }

        for (int i = 0; i < taille; i++)
            tab[i] = N[i];
    }

    // tri par fusion
    public static void triFusion(Element tab[]) {
        int longueur = tab.length;
        if (longueur > 0)
            triFusion(tab, 0, longueur - 1);
    }

    private static void triFusion(Element tab[], int debut, int fin) {
        if (debut != fin) {
            int milieu = (debut + fin) / 2;
            triFusion(tab, debut, milieu);
            triFusion(tab, milieu + 1, fin);
            fusion(tab, debut, milieu, fin);
        }
    }

    private static void fusion(Element tab[], int debut1, int fin1, int fin2) {
        int debut2 = fin1 + 1;
        //on recopie les éléments du début du tableau
        Element tab1[] = new Element[fin1 - debut1 + 1];
        for (int i = debut1; i <= fin1; i++)
            tab1[i - debut1] = tab[i];

        int compteur1 = debut1;
        int compteur2 = debut2;

        for (int i = debut1; i <= fin2; i++) {
            if (compteur1 == debut2 || (compteur2 <= fin2 && tab1[compteur1 - debut1].getCle() > tab[compteur2].getCle())) {
                tab[i] = tab[compteur2++];
            } else {
                tab[i] = tab1[compteur1++ - debut1];
            }
        }
    }

    // Fonction pour afficher un tableau d'éléments ( pour les petites tailles testées)
    public static void afficherTableau(Element[] tab) {
        for (Element element : tab) {
            System.out.print("[cle: " + element.getCle() + " ,contenu: " + element.getContenu() + " ]");
        }
        System.out.println();
    }

    // Fonction pour générer un tableau d'éléments avec des clés et des valeurs aléatoires
    public static Element[] genererTableauAleatoire(int taille) {
        Element[] tableau = new Element[taille];
        Random rand = new Random();

        for (int i = 0; i < taille; i++) {
            int cle = rand.nextInt(100);
            String valeur = "element" + i;
            tableau[i] = new Element(cle, valeur);
        }

        return tableau;
    }

    public static void main(String[] args) {
        // test sur un tableau de 10 éléments
        Element[] tab = {
       new Element(3, "Trois"),
       new Element(1, "un"),
       new Element(4, "Quatre"),
       new Element(1, "One"),
       new Element(5, "Cinq"),
       new Element(7, "sept"),
       new Element(8, "huit"),
       new Element(0, "zero"),
       new Element(11, "onze"),
       new Element(2, "Deux")
   };
/*
   *  le code pour afficher le tableau trié est mis en commentaire ci dessous
   * System.out.println("Tableau initial : ");
   * afficherTableau(tab);
   * System.out.println("Tableau trié: ");
   *  ici on laisse le choix pour la méthode de test qu'on veut tester
   *  triFusion(tab);
   *  triInsertion(tab);
   * triDenombrement(tableau2,tableau2.length);
   * afficherTableau(tab);
   * création de trois tableaux avec des valeurs aléatoires et des tailles choisies par l'utilisateur
   * on mets les tableaux à 10 éléments et c'est à l'utilisateur de changer les tailles pour faire des tests 
   */
        Element[] tableau1 = genererTableauAleatoire(10);
        Element[] tableau2 = genererTableauAleatoire(10);
        Element[] tableau3 = genererTableauAleatoire(10);
        // test des trois méthodes de tri et le calcul du temps d'éxécution en Millisecondes 
        long debut_insertion = System.currentTimeMillis();
        triInsertion(tableau1);
        long fin_insertion = System.currentTimeMillis();
        System.out.println("Le Temps d'éxécution du tri par insertion : " + (fin_insertion - debut_insertion) + " Ms");
        System.out.println("-----------------------");
        long debut_denombrement = System.currentTimeMillis();
        triDenombrement(tableau2,tableau2.length);
        long fin_denombrement = System.currentTimeMillis();
        System.out.println("Le Temps d'éxécution du tri par dénombrement : " + (fin_denombrement - debut_denombrement) + " Ms");
        System.out.println("-----------------------");
        long debut_fusion = System.currentTimeMillis();
        triFusion(tableau3);
        long fin_fusion = System.currentTimeMillis();
        System.out.println("Le Temps d'éxécution du tri par fusion : " + (fin_fusion - debut_fusion) + " Ms");
 
    }
}
