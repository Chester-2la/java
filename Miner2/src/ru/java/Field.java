package ru.java;

import ru.java.Interface.MinerLogic;

/*
 * Создание игрового поля
 */
public class Field {
	private Cell[][] field;

	Field(MinerLogic logic) {
		field = new Cell[logic.getFieldHeight()][logic.getFieldLenghth()];
		createField();
		setMines(logic);
	}

	public void createField() {
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[x].length; y++) {
				field[x][y] = new Cell();
			}
		}
	}

	// Расстановка мин, а также подсчет соседних мин в каждой ячейке поля
	public void setMines(MinerLogic logic) {
		int i = 0, x, y;
		while (i < logic.getBombsAll()) {
			y = (int) (Math.random() * logic.getFieldLenghth());
			x = (int) (Math.random() * logic.getFieldHeight());
			if (!field[x][y].isBomb()) {
				for (int k = -1; k < 2; k++) {
					for (int n = -1; n < 2; n++) {
						try {
							field[x + k][y + n].setBombBeside();
						} catch (ArrayIndexOutOfBoundsException e) {
						}
					}
				}
				field[x][y].setBomb();
				i++;
			}
		}
	}

	public Cell[][] getField() {
		return field;
	}
}
