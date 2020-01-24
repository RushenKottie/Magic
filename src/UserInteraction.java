import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserInteraction implements Runnable{
    private int dayOfBirth;
    private int height;

    @Override
    public void run() {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите день своего рождения:");
            dayOfBirth = Integer.parseInt(reader.readLine());
            while (dayOfBirth<1||dayOfBirth>31)
                {
                    System.out.println("Это не смешно. Введите день рождения еще раз:");
                    dayOfBirth = Integer.parseInt(reader.readLine());
                }
            System.out.println("Введите ваш рост в сантиметрах:");
            height = Integer.parseInt(reader.readLine());
            while (height<70 || height>251 )
                {
                    System.out.println("Это не смешно. Введите рост еще раз:");
                    height = Integer.parseInt(reader.readLine());
                }

        } catch (NumberFormatException | IOException e) {
            System.out.println("Перезапустите программу и введите значения в цифровом формате.");
        }
    }

    public int getDayOfBirth(){
        return dayOfBirth;
    }

    public int getHeight(){
        return height;
    }

    public static boolean tryItAgain(){
        char symbol = 0;
        System.out.println("\n"+"Для повторного запуска программы нажмите Enter, для завершения программы любую клавишу + Enter:");
        InputStreamReader r = new InputStreamReader(System.in);
        try{
            symbol = (char) r.read();
        }catch (IOException ignored){}

        return symbol == '\n';
    }
}
