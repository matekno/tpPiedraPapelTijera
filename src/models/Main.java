package models;

import interfaces.IJugador;
import services.PartidaService;

public class Main {

	public static void main(String[] args) {
		PartidaService partidaService = new PartidaService();
		IJugador humano = new JugadorConsola(partidaService);
		IJugador maquina = new JugadorMaquina(partidaService);

		Partida partida = new Partida(humano, maquina, partidaService);
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
