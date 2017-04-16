package ru.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ru.java.Interface.FieldConstructor;
import ru.java.Interface.MinerLogic;
import ru.java.Interface.PlayerMiner;

/*
 * Инициализация игрока. В данном случае, для игры в консоле
 */
public class PlayerConsole implements PlayerMiner {
	private BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
	private int[] guess = new int[3];
	private MinerLogic logic;
	private Cell[][] field;
	private FieldConstructor constructorField;

	PlayerConsole() {
		logic = new LogicFirstLevel();
		Field field = new Field(logic);
		this.field = field.getField();
		constructorField = new FieldConstructConsole();
	}

	// Ход игрока
	public void playerStep() {
		boolean error = true;
		while (error) {
			try {
				System.out.println("Выберите строку  от 1 до " + logic.getFieldHeight());
				guess[0] = Integer.parseInt(s.readLine())-1;

				System.out.println("Выберите столбец от 1 до " + logic.getFieldLenghth());
				guess[1] = Integer.parseInt(s.readLine())-1;

				System.out.println("Бомба в данной ячейке?(1 - ДА)");
				guess[2] = Integer.parseInt(s.readLine());

				logic.checkGuess(guess, field);
				error = false;

			} catch (Exception e) {
				System.out.println("Неверно введены данные. Повторите ввод");
			}
		}
		constructorField.FieldShow(field);
	}

}
