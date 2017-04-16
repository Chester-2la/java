package ru.java.Interface;

import ru.java.Cell;

public interface MinerLogic {
	void checkGuess(int[] guess, Cell[][] field);
	void winGame();
	void gameOver();
	int getBombsAll();
	int getFieldLenghth();
	int getFieldHeight();
}
