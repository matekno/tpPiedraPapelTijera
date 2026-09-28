package services;

import models.Jugada;
import models.Resultado;

public class PartidaService {

	public Jugada intAJugada(int n) {
		// 1: piedra
		// 2: papel
		// 3: tijera
		Jugada toReturn;
		switch (n) {
		case 1:
			toReturn = Jugada.PIEDRA;
			break;
		case 2:
			toReturn = Jugada.PAPEL;
			break;
		case 3:
			toReturn = Jugada.TIJERA;
			break;
		default:
			throw new IllegalArgumentException("No se ingreso una opcion valida del menu");
		}
		return toReturn;
	}

	public Resultado definirGanador(Jugada jugadaA, Jugada jugadaB) {
		Resultado r;
		if (jugadaA == jugadaB) {
			r = Resultado.EMPATA;
		} else if ((jugadaA == Jugada.PIEDRA && jugadaB == Jugada.TIJERA)
				|| (jugadaA == Jugada.PAPEL && jugadaB == Jugada.PIEDRA)
				|| (jugadaA == Jugada.TIJERA && jugadaB == Jugada.PAPEL)) {
			r = Resultado.GANA;
		} else {
			r = Resultado.PIERDE;
		}
		return r;
	}

}
