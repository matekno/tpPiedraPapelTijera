package models;

import java.util.Scanner;

import interfaces.IJugador;
import services.PartidaService;

public class JugadorHumano implements IJugador {

	private Jugada jugadaElegida;
	private PartidaService partidaService;
	
	public JugadorHumano(PartidaService ps) {
		this.partidaService = ps;
	}
	
	public Jugada elegirJugada() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("1: Piedra");
			System.out.println("2: Papel");
			System.out.println("3: Tijera");
			System.out.print("Ingresa la opcion deseada: ");

			this.jugadaElegida = partidaService.intAJugada(scanner.nextInt());
		}
		return jugadaElegida;

	}

}
