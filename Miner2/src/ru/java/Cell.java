package ru.java;

public class Cell {
	private boolean bomb;
	private boolean guess;
	private boolean checked;
	private int bombBeside;

	Cell() {
		this.bomb = false;
		this.guess = false;
		this.checked = false;
		this.bombBeside = 0;
	}

	public void setBomb() {
		this.bomb = true;
	}

	public boolean isBomb() {
		return this.bomb;
	}

	public void setBombBeside() {
		this.bombBeside++;
	}

	public int getBombBeside() {
		return this.bombBeside;
	}

	public boolean isGuess() {
		return this.guess;
	}

	public void setGuess() {
		this.guess = true;
	}

	public void unsetGuess() {
		this.guess = false;
	}

	public boolean isChecked() {
		return this.checked;
	}

	public void setChecked() {
		this.checked = true;
	}

	public void unsetChecked() {
		this.checked = false;
	}
}
