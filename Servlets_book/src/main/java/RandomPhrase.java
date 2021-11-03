/*
Класс для простой генерации фраз
 */
public class RandomPhrase {
    public static String[] s  = {"Red", "Orange", "Yellow", "Green", "Blue", "Dark Blue", "Violet" };

    public static String getRandomPhrase(){
        return s[(int)(Math.random()*6)];
    }
}
