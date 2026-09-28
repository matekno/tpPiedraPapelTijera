package models;

import interfaces.IJugador;

public class Main {

	public static void main(String[] args) {

		Partida partida = new Partida();
		IJugador ganador = partida.jugar();

		if (ganador == null) {
			System.out.println("Empate");
		} else if (ganador instanceof JugadorConsola) {
			System.out.println("Gana humano");
		} else {
			System.out.println("Gana maquina");
		}
	}

}
