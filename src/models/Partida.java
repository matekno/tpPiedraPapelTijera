package models;

import java.util.Random;
import java.util.Scanner;

import interfaces.IJugador;
import services.PartidaService;

public class Partida { 
	private JugadorConsola humano;
	private JugadorMaquina maquina;
	private PartidaService partidaService;
	private IJugador ganador = null;
	
	public Partida() {
		this.partidaService = new PartidaService();
		this.humano = new JugadorConsola(this.partidaService);
		this.maquina = new JugadorMaquina(this.partidaService);
	}
	
	public IJugador jugar() {
		Jugada jugadaHumano = this.humano.elegirJugada();
		Jugada jugadaMaquina = this.maquina.elegirJugada();
		System.out.println("Maquina eligio: " + jugadaMaquina);

		
		Resultado resultadoHumano = partidaService.definirGanador(jugadaHumano, jugadaMaquina);
		Resultado resultadoMaquina = partidaService.definirGanador(jugadaMaquina, jugadaHumano);
	
		switch (resultadoHumano) {
		case GANA:
			this.ganador = this.humano;
			break;
		case PIERDE:
			this.ganador = this.maquina;
		default:
			break;
		}
		return this.ganador;
	}
		
}
