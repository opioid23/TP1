public class monTP1 {

    public static final String NOM_DU_PROGRAMME = "Programme de gestion des ventes de billets";
    public static final String NOM_DU_THEATRE = "THEATRE L'EXPERT MENTAL";
    public static final String BANIERE = "******************/n GUICHET BILLETTERIE /n******************";
    public static final String OPTION1 = "1. Preparer une nouvelle facture";
    public static final String OPTION2 = "2. Consulter les ventes";
    public static final String OPTION3 = "3. Reinitialiser l'application";
    public static final String OPTION4 = "4. Quitter le programme";

    public static final String PRESENTATION = NOM_DU_THEATRE + "\n" + NOM_DU_PROGRAMME;
    public static final String MENU = BANIERE + "\n" + OPTION1 + "\n" + OPTION2 + "\n" + OPTION3 + "\n" + OPTION4
            + "\n";

    public static final String SECTIONA = "A. Section A";
    public static final int NB_PLACES_SECTIONA = 45;
    public static final double PRIX_PLACE_SECTIONA = 16.79;

    public static final String SECTIONB = "B. Section B";
    public static final int NB_PLACES_SECTIONB = 30;
    public static final double PRIX_PLACE_SECTIONB = 23.52;

    public static final double REDUCTION_5_9 = 0.10;
    public static final double REDUCTION_10_24 = 0.15;
    public static final double REDUCTION_24_ET_PLUS = 0.20;
    public static final double TAUX_TPS = 0.05;
    public static final double TAUX_TVQ = 0.09975;

    public static final String SECTIONC = "C. Section C";
    public static final int NB_PLACES_SECTIONC = 15;
    public static final double PRIX_PLACE_SECTIONC = 30.50;

    public static final String INSTRUCTION_CHOIX_SECTION = "Entrez la section pour les billets achetes (ou T pour terminer) :";
    public static final String INSTRUCTION_CHOIX_NB_BILLETS = "Entrez le nombre de billet(s) pour la section ";
    public static final String INSTRUCTION_0 = " (0 pour terminer) :";

    public static final String SECTION_COMPLETE = "Cette section est complete !";
    public static final String ERREUR_MENU = "Erreur, choix de menu invalide... Recommencez !";
    public static final String ERREUR_SECTION = "Erreur, choix de section invalide... Recommencez !";

    public static final String PAS_ASSEZ_DE_PLACES = "Erreur, il n'y a pas assez de places dans cette section... Recommencez !";
    public static final String ERREUR_NB_BILLETS = "Erreur, le nombre de billets doit etre superieur ou egal a 0... Recommencez !";

    public static final String FACTURE_NB = "FACTURE #";
    public static final String BANIERE_FACTURE = "----------------------------\n" +
            "QTE | SECTION | PRIX\n" +
            "----------------------------";
    public static final String SOUS_BANIERE_FACTURE = "============================";
    public static final String SOUS_TOTAL = "      SOUS-TOTAL  ";
    public static final String RABAIS = "          RABAIS  ";
    public static final String TPS = "             TPS ";
    public static final String TVQ = "             TVQ ";
    public static final String TOTAL = "           TOTAL ";
    public static final String MONNAIE = " $";

    public static final String BANIERE_CONSULTATION_DES_VENTES= "-----------------------\n" + //
            "CONSULTATION DES VENTES\n" + //
            "-----------------------";
    public static final String STATISTIQUE_DES_VENTES= "Statistiques sur les ventes depuis la derniere reinitialisation.";
    public static final String NOMBRE_DE_BILLETS_VENDUS = "NOMBRE DE BILLETS VENDUS :";
    public static final String CONSULTATION_VENTES_SECTIONA = "   - section A : ";
    public static final String CONSULTATION_VENTES_SECTIONB = "   - section B : ";
    public static final String CONSULTATION_VENTES_SECTIONC = "   - section C : ";    
    public static final String TOTAL_DES_VENTES="\nTOTAL DES VENTES : ";
    // public static final String = "";
    public static final String FIN_DE_PROGRAMME = "F I N   N O R M A L E   D U   P R O G R A M M E";

    public static void main(String[] args) {
        int nb_places_a = NB_PLACES_SECTIONA;
        int nb_places_b = NB_PLACES_SECTIONB;
        int nb_places_c = NB_PLACES_SECTIONC;
        char choix;
        char choix_section;
        int nb_billets_total = 0;
        int nb_facture = 1;
        boolean menu_valide = true;
        do {
            System.out.println(PRESENTATION + "\n" + MENU);
            System.out.println("Entrez votre choix :");
            choix = Clavier.lireCharLn();
            switch (choix) {
                case '1':
                    boolean selection_valide = true;
                    do {
                        int nb_billets_demande;
                        // imprimer les sections et le nombre correspondant de places
                        System.out.println("SECTIONS");
                        System.out.println(SECTIONA + " " + "[ " + nb_places_a + " place(s) ]");
                        System.out.println(SECTIONB + " " + "[ " + nb_places_b + " place(s) ]");
                        System.out.println(SECTIONC + " " + "[ " + nb_places_c + " place(s) ]");
                        System.out.println(INSTRUCTION_CHOIX_SECTION);
                        choix_section = Clavier.lireCharLn();
                        choix_section = Character.toUpperCase(choix_section);
                        switch (choix_section) {
                            case 'A':
                                if (nb_places_a == 0) {
                                    System.out.println(SECTION_COMPLETE);
                                    selection_valide = false;
                                    break;
                                }
                                System.out.println(INSTRUCTION_CHOIX_NB_BILLETS + "A" + INSTRUCTION_0);
                                nb_billets_demande = Clavier.lireIntLn();
                                if (nb_billets_demande == 0) {
                                    selection_valide = true;
                                    break;
                                }
                                if (nb_billets_demande < 0) {
                                    System.out.println(ERREUR_NB_BILLETS);
                                    selection_valide = false;
                                    break;
                                }
                                if (nb_billets_demande > nb_places_a) {
                                    System.out.println(PAS_ASSEZ_DE_PLACES);
                                    selection_valide = false;
                                    break;
                                }
                                nb_places_a -= nb_billets_demande;
                                nb_billets_total += nb_billets_demande;
                                selection_valide = false;
                                break;
                            case 'B':
                                if (nb_places_b == 0) {
                                    System.out.println(SECTION_COMPLETE);
                                    selection_valide = false;
                                    break;
                                }
                                System.out.println(INSTRUCTION_CHOIX_NB_BILLETS + "B" + INSTRUCTION_0);
                                nb_billets_demande = Clavier.lireIntLn();
                                if (nb_billets_demande == 0) {
                                    selection_valide = true;
                                    break;
                                }
                                if (nb_billets_demande < 0) {
                                    System.out.println(ERREUR_NB_BILLETS);
                                    selection_valide = false;
                                    break;
                                }
                                if (nb_billets_demande > nb_places_b) {
                                    System.out.println(PAS_ASSEZ_DE_PLACES);
                                    selection_valide = false;
                                    break;
                                }
                                nb_places_b -= nb_billets_demande;
                                nb_billets_total += nb_billets_demande;
                                selection_valide = false;
                                break;
                            case 'C':
                                if (nb_places_c == 0) {
                                    System.out.println(SECTION_COMPLETE);
                                    selection_valide = false;
                                    break;
                                }
                                System.out.println(INSTRUCTION_CHOIX_NB_BILLETS + "C" + INSTRUCTION_0);
                                nb_billets_demande = Clavier.lireIntLn();
                                if (nb_billets_demande == 0) {
                                    selection_valide = true;
                                    break;
                                }
                                if (nb_billets_demande < 0) {
                                    System.out.println(ERREUR_NB_BILLETS);
                                    selection_valide = false;
                                    break;
                                }
                                if (nb_billets_demande > nb_places_a) {
                                    System.out.println(PAS_ASSEZ_DE_PLACES);
                                    selection_valide = false;
                                    break;
                                }
                                nb_places_c -= nb_billets_demande;
                                nb_billets_total += nb_billets_demande;
                                selection_valide = false;
                                break;
                            case 'T':
                                selection_valide = true;
                                menu_valide = false;
                                break;
                            default:
                                System.out.println(ERREUR_SECTION);
                                selection_valide = false;
                                break;
                        }
                    } while (!selection_valide);
                    if (nb_billets_total > 0) {
                        System.out.println(FACTURE_NB + nb_facture++);
                        System.out.println(BANIERE_FACTURE);
                        boolean achat_section_a = (NB_PLACES_SECTIONA > nb_places_a);
                        boolean achat_section_b = (NB_PLACES_SECTIONB > nb_places_b);
                        boolean achat_section_c = (NB_PLACES_SECTIONC > nb_places_c);
                        int QTE;
                        double rabais = 0;
                        double total;
                        if (achat_section_a) {
                            QTE = NB_PLACES_SECTIONA - nb_places_a;
                            //System.out.println(QTE + "      | A     |   " + QTE * PRIX_PLACE_SECTIONA + MONNAIE);
                            System.out.printf("%-6d| %-7s | %9.2f $%n", QTE, "A", QTE * PRIX_PLACE_SECTIONA);
                            nb_billets_total = nb_billets_total + QTE;
                            // System.out.println();
                        }
                        if (achat_section_b) {
                            QTE = NB_PLACES_SECTIONB - nb_places_b;
                            //System.out.println(QTE + "      | B     |   " + QTE * PRIX_PLACE_SECTIONB + MONNAIE);
                            System.out.printf("%-6d| %-7s | %9.2f $%n", QTE, "B", QTE * PRIX_PLACE_SECTIONB);
                            nb_billets_total = nb_billets_total + QTE;
                        }
                        if (achat_section_c) {
                            QTE = NB_PLACES_SECTIONC - nb_places_c;
                            nb_billets_total = nb_billets_total + QTE;
                            //System.out.println(QTE + "      | C     |   " + QTE * PRIX_PLACE_SECTIONC + MONNAIE);
                            System.out.printf("%-6d| %-7s | %9.2f $%n", QTE, "C", QTE * PRIX_PLACE_SECTIONC);
                        }

                        if (nb_billets_total >= 5 && nb_billets_total <= 9)
                            rabais = REDUCTION_5_9;
                        if (nb_billets_total >= 10 && nb_billets_total <= 24)
                            rabais = REDUCTION_10_24;
                        if (nb_billets_total > 24)
                            rabais = REDUCTION_24_ET_PLUS;
                        total = (NB_PLACES_SECTIONA - nb_places_a) * PRIX_PLACE_SECTIONA;
                        total += (NB_PLACES_SECTIONB - nb_places_b) * PRIX_PLACE_SECTIONB;
                        total += (NB_PLACES_SECTIONC - nb_places_c) * PRIX_PLACE_SECTIONC;
                        //arrondire au centieme toutes les valeurs sorties (pas celles utilisées pour les calculs)
                        System.out.println(SOUS_BANIERE_FACTURE);
                        //System.out.println(SOUS_TOTAL + total + MONNAIE);
                        System.out.printf("%16s %15s %9.2f $%n", "", "SOUS-TOTAL", total);
                        //System.out.println(RABAIS + -(total * rabais) + MONNAIE);
                        System.out.printf("%16s %15s %9.2f $%n", "", "RABAIS", -(total * rabais));
                        total -= total * rabais;
                        //System.out.println(TPS + total * TAUX_TPS + MONNAIE);
                        System.out.printf("%16s %15s %9.2f $%n", "", "TPS", total * TAUX_TPS);
                        //System.out.println(TVQ + total * TAUX_TVQ + MONNAIE);
                        System.out.printf("%16s %15s %9.2f $%n", "", "TVQ", total * TAUX_TVQ);
                        total += total * TAUX_TPS + total * TAUX_TVQ;
                        System.out.println();
                        //System.out.println(TOTAL + total + MONNAIE);
                        System.out.printf("%16s %15s %9.2f $%n", "", "TOTAL", total);
                    } else {
                        System.out.println("operation annulee");
                        menu_valide = false;
                    }

                    /* afficher facture si nb billet > 0 */
                    break;
                case '2':
                    double total;
                    System.out.println(BANIERE_CONSULTATION_DES_VENTES);
                    System.out.println(STATISTIQUE_DES_VENTES + nb_billets_total);
                    System.out.println(CONSULTATION_VENTES_SECTIONA +  (NB_PLACES_SECTIONA - nb_places_a));
                    System.out.println(CONSULTATION_VENTES_SECTIONB +  (NB_PLACES_SECTIONB - nb_places_b));
                    System.out.println(CONSULTATION_VENTES_SECTIONC +  (NB_PLACES_SECTIONC - nb_places_c));
                    //arrondire au centieme toutes les valeurs sorties (pas celles utilisées pour les calculs)
                    total = (NB_PLACES_SECTIONA - nb_places_a) * PRIX_PLACE_SECTIONA;
                    total += (NB_PLACES_SECTIONB - nb_places_b) * PRIX_PLACE_SECTIONB;
                    total += (NB_PLACES_SECTIONC - nb_places_c) * PRIX_PLACE_SECTIONC;
                    System.out.println(TOTAL_DES_VENTES + total + MONNAIE);
                    //TODO: appuyer sur entree pour sortir
                    menu_valide = false;
                    break;
                case '3':
                    nb_places_a = NB_PLACES_SECTIONA;
                    nb_places_b = NB_PLACES_SECTIONB;
                    nb_places_c = NB_PLACES_SECTIONC;
                    nb_billets_total = 0;
                    break;
                case '4':
                    menu_valide = true;
                    break;
                default:
                    System.out.println(ERREUR_MENU);
                    menu_valide = false;
                    break;
            }
        } while (!menu_valide);
        System.out.println(FIN_DE_PROGRAMME);

        return;
    }
} // monTP1
