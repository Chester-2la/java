package ru.java;

import ru.java.Interface.MinerLogic;

/*
 * Логика лёгкого уровня игры
 */
public class LogicFirstLevel implements MinerLogic {
	private final int BOMBSALL = 10;
	private final int FIELDLENGHT = 9;
	private final int FIELDHEIGHT = 9;
	private int unChecked;

	LogicFirstLevel() {
		unChecked = FIELDLENGHT * FIELDHEIGHT - BOMBSALL;
	}

	// Проверяем ход игрока, а также соседние клетки
	public void checkGuess(int[] guess, Cell[][] field) {
		if (guess[2] == 1) {
			if (field[guess[0]][guess[1]].isGuess()) {
				field[guess[0]][guess[1]].unsetGuess();
				field[guess[0]][guess[1]].unsetChecked();
			} else {
				field[guess[0]][guess[1]].setGuess();
			}
		} else if (field[guess[0]][guess[1]].isBomb() && !field[guess[0]][guess[1]].isGuess()) {
			gameOver();
		} else {
			checkNearCell(field, guess[0], guess[1]);
		}

		if (unChecked == 0)
			winGame();
	}

	private void checkNearCell(Cell[][] field, int x, int y) {
		if (!field[x][y].isChecked() && !field[x][y].isGuess() && !field[x][y].isBomb()) {
			field[x][y].setChecked();
			unChecked--;
			if (field[x][y].getBombBeside() == 0) {
				for (int k = -1; k < 2; k++) {
					for (int n = -1; n < 2; n++) {
						try {
							checkNearCell(field, x + k, y + n);
						} catch (ArrayIndexOutOfBoundsException e) {
						}
					}
				}
			}
		}
	}

	public void winGame() {
		Miner.finishGame();
		System.out.println("Вы победили");
	}

	public void gameOver() {
		Miner.finishGame();
		System.out.println("Вы проиграли");
	}

	public int getBombsAll() {
		return BOMBSALL;
	}

	public int getFieldLenghth() {
		return FIELDLENGHT;
	}

	public int getFieldHeight() {
		return FIELDHEIGHT;
	}
}
