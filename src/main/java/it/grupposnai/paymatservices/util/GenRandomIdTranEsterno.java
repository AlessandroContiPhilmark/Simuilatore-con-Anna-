package it.grupposnai.paymatservices.util;
import java.util.Random;
public class GenRandomIdTranEsterno {

    // Indici richiesti
    private static final int[] INDICI = {
            1, 4, 5, 18, 19, 21, 25, 57, 58, 111, 126, 127, 137, 220
    };

    // Alfabeto base62 (solo alfanumerico)
    private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        Random random = new Random();

        // Mappa per associare ogni indice al suo codice generato
        for (int idx : INDICI) {
            String code = generateRandomCode(random, 14);
            System.out.println("Indice " + idx + " -> " + code);
        }
    }

    /**
     * Genera un codice alfanumerico random di lunghezza specificata.
     */
    private static String generateRandomCode(Random random, int length) {
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // Seleziona un carattere random dall'alfabeto BASE62
            char randomChar = BASE62[random.nextInt(BASE62.length)];
            code.append(randomChar);
        }
        return code.toString();
    }
}
