package student;

public class AmbientBiznesi extends Prona {
    private String llojiAmbientit; // P.sh. "Zyre", "Dyqan", "Magazine"
    private boolean kaFasadeXhami;

    // Konstruktori për inicializimin e të dhënave bazë dhe atyre të biznesit
    public AmbientBiznesi(String idProna, String statusi, String qyteti, String zona, String rruga, double siperfaqe, double cmimi, 
                          boolean kaCertifikate, String llojiAmbientit, boolean kaFasadeXhami) {
        super(idProna, statusi, qyteti, zona, rruga, siperfaqe, cmimi, kaCertifikate);
        this.llojiAmbientit = llojiAmbientit;
        this.kaFasadeXhami = kaFasadeXhami;
    }

    // Getters dhe Setters
    public String getLlojiAmbientit() { return llojiAmbientit; }
    public void setLlojiAmbientit(String llojiAmbientit) { this.llojiAmbientit = llojiAmbientit; }

    public boolean isKaFasadeXhami() { return kaFasadeXhami; }
    public void setKaFasadeXhami(boolean kaFasadeXhami) { this.kaFasadeXhami = kaFasadeXhami; }

    // Mbishkrimi i metodës toString() për Ambientin e Biznesit
    @Override
    public String toString() {
        return super.toString() + " | Tipologjia: Ambient Biznesi (" + llojiAmbientit + " | Fasade Xhami: " + (kaFasadeXhami ? "Po" : "Jo") + ")";
    }
}