package gui;

import interfaces.IJugador;
import models.Jugada;

public class JugadorGUI implements IJugador {
	private Jugada jugada;

	@Override
	public Jugada elegirJugada() {
		return this.jugada;
	}

	public void setJugada(Jugada jugada) {
		this.jugada = jugada;
	}

}
