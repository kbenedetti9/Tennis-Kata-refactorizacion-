public class TennisGame3 implements TennisGame {
    
    private transient int puntaje2;
    private transient int puntaje1;
    private transient final String nombreJugador1;
    private transient final String nombreJugador2;

    public TennisGame3(final String nombreJugador1,final String nombreJugador2) {
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
    }

    @Override
    public String getScore() {
        String salida;
        final String[] arregloPuntajes = {"Love", "Fifteen", "Thirty", "Forty","Deuce"};
        if (esMenor() && esDiferenteA(sumarPuntajes(), 6)){
            salida = arregloPuntajes[puntaje1];
            return esIgual(puntaje1, puntaje2)
                    ? salida + "-All"
                    : salida + "-" + arregloPuntajes[puntaje2];
        } else{
            if (esIgual(puntaje1, puntaje2)) {
                return arregloPuntajes[4];
            }
            final int diferencia = Math.abs(puntaje1 - puntaje2);
            salida = puntaje1 > puntaje2 ? nombreJugador1 : nombreJugador2;
            return esIgual(diferencia,1)
                    ? "Advantage " + salida
                    : "Win for " + salida;
        }
    }

    private int sumarPuntajes() {
        return puntaje1 + puntaje2;
    }

    private boolean esMenor() {
        return puntaje1 < 4 && puntaje2 < 4;
    }

    private boolean esIgual(final int puntaje1,final int puntaje2) {
        return puntaje1 == puntaje2;
    }

    private boolean esDiferenteA(final int suma,final int factor) {
        return suma != factor;
    }

    @Override
    public void wonPoint(final String playerName) {
        if ("player1".equalsIgnoreCase(playerName)) {
            this.puntaje1 += 1;
        } else {
            this.puntaje2 += 1;
        }
    }

}
