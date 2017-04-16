package ru.java;

import ru.java.Interface.FieldConstructor;

/*
 * Рисуем игровое поле, в данном случае на консоль
 */
public class FieldConstructConsole implements FieldConstructor {

	public void FieldShow(Cell[][] field) {
		System.out.print(" ");
		for (int z = 0; z < field[0].length; z++) {
			System.out.print("  " + (z + 1) + "  ");
		}
		System.out.println();
		for (int x = 0; x < field.length; x++) {
			System.out.print(x + 1);
			for (int y = 0; y < field[x].length; y++) {

				if (Miner.isFinished() && field[x][y].isBomb())
					bombDraw();
				else if (field[x][y].isGuess())
					guessDraw();
				else if (field[x][y].isChecked() && field[x][y].getBombBeside() > 0)
					System.out.print(" [" + field[x][y].getBombBeside() + "] ");
				else if (field[x][y].isChecked() && field[x][y].getBombBeside() == 0)
					checkedDraw();
				else
					cellDraw();
			}
			System.out.println();
		}
	}

	public void cellDraw() {
		System.out.print(" [◙] ");
	}

	public void guessDraw() {
		System.out.print(" [?] ");
	}

	public void bombDraw() {
		System.out.print(" [*] ");
	}

	public void checkedDraw() {
		System.out.print(" [ ] ");
	}
}
