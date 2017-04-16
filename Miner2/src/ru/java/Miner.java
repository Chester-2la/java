package ru.java;

import ru.java.Interface.PlayerMiner;

public class Miner {
	private static boolean finishGame = false;
	private PlayerMiner gamer;

	public void setupGame() {
		gamer = new PlayerConsole();
	}

	public void startGame() {
		while (!finishGame) {
			gamer.playerStep();
		}
	}

	public static void finishGame() {
		finishGame = true;
	}

	public static boolean isFinished() {
		return finishGame;
	}
}
