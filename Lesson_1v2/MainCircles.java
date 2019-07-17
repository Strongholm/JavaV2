/**
 * Домашняя работа к уроку 1 "Java 2"
 *
 * @author Андрей Семенюк
 * @version 17.07.2019
 */

/*
	Полностью разобраться с кодом
	Прочитать методичку к следующему уроку
	Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
	 * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
	 ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
*/

import javax.swing.*;
import java.awt.*;

public class MainCircles extends JFrame{

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    MainCircles() {
        Background gameCanvas = new Background(this);
        add(gameCanvas);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Circles");
        setVisible(true);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }
}