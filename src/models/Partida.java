package models;

import java.util.Random;
import java.util.Scanner;

import services.PartidaService;

public class Partida {

	public static void main(String[] args) {
		PartidaService partidaService = new PartidaService();
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		
		// Usuario ingresa su jugada
		System.out.println("1: Piedra");
		System.out.println("2: Papel");
		System.out.println("3: Tijera");
		System.out.print("Ingresa la opcion deseada: ");

		Jugada jugadaUsuario = partidaService.intAJugada(scanner.nextInt());

		// Maquina elige su jugada
		Jugada jugadaMaquina = partidaService.intAJugada(random.nextInt(1, 4));
		System.out.println("Maquina eligio: " + jugadaMaquina);
		
		// Resolver ganador
		Resultado resultadoHumano = partidaService.definirGanador(jugadaUsuario, jugadaMaquina);
		Resultado resultadoMaquina = partidaService.definirGanador(jugadaMaquina, jugadaUsuario);
		
		System.out.println("Humano: " + resultadoHumano);
		System.out.println("Maquina: " + resultadoMaquina);
	}
	
}
