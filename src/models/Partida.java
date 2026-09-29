package models;

import java.util.Random;
import java.util.Scanner;

import interfaces.IJugador;
import services.PartidaService;

public class Partida {
	private IJugador jugadorAlpha;
	private IJugador jugadorBeta;
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
		IJugador ganador = null;
		
		switch (resultadoAlpha) {
		case GANA:
			ganador = this.jugadorAlpha;
			break;
		case PIERDE:
			ganador = this.jugadorBeta;
		default:
			break;
		}
		return ganador;
	}
	
	public Object[] jugarConRtaMaquina() {
		Jugada jugadaAlpha = this.jugadorAlpha.elegirJugada();
		Jugada jugadaBeta = this.jugadorBeta.elegirJugada();
		System.out.println("Maquina eligio: " + jugadaBeta);

		Resultado resultadoAlpha = partidaService.definirGanador(jugadaAlpha, jugadaBeta);
		IJugador ganador = null;

		
		switch (resultadoAlpha) {
		case GANA:
			ganador = this.jugadorAlpha;
			break;
		case PIERDE:
			ganador = this.jugadorBeta;
		default:
			break;
		}
		
		Object[] toReturn = {ganador, jugadaBeta};
		return toReturn;
	}
	

}


