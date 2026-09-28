package models;

import java.util.Random;

import interfaces.IJugador;
import services.PartidaService;

public class JugadorMaquina implements IJugador {
	private Jugada jugadaElegida;
	private PartidaService partidaService;
	
	public JugadorMaquina(PartidaService ps) {
		this.partidaService = ps;
	}
	
	public Jugada elegirJugada() {
		Random random = new Random();
		this.jugadaElegida = partidaService.intAJugada(random.nextInt(1, 4));
		return this.jugadaElegida;
	}

}
