package models;

import java.util.Random;
import java.util.Scanner;

import interfaces.IJugador;
import services.PartidaService;

public class Partida {
	private IJugador jugadorAlpha;
	private IJugador jugadorBeta;
	private IJugador ganador = null;
	private PartidaService partidaService;

	public Partida(IJugador jugadorAlpha, IJugador jugadorBeta, PartidaService partidaService) {
		this.jugadorAlpha = jugadorAlpha;
		this.jugadorBeta = jugadorBeta;
		this.partidaService = partidaService;
	}

	public IJugador jugar() {
		Jugada jugadaAlpha = this.jugadorAlpha.elegirJugada();
		Jugada jugadaBeta = this.jugadorBeta.elegirJugada();
		System.out.println("Maquina eligio: " + jugadaBeta);

		Resultado resultadoAlpha = partidaService.definirGanador(jugadaAlpha, jugadaBeta);

		switch (resultadoAlpha) {
		case GANA:
			this.ganador = this.jugadorAlpha;
			break;
		case PIERDE:
			this.ganador = this.jugadorBeta;
		default:
			break;
		}
		return this.ganador;
	}

}
