package student;

public class Vile extends Prona {
    private int numriKateve;
    private double siperfaqeOborri;

    // Konstruktori që inicializon të dhënat bazë dhe ato specifike të vilës
    public Vile(String idProna, String statusi, String qyteti, String zona, String rruga, double siperfaqe, double cmimi, 
                boolean kaCertifikate, int numriKateve, double siperfaqeOborri) {
        super(idProna, statusi, qyteti, zona, rruga, siperfaqe, cmimi, kaCertifikate);
        this.numriKateve = numriKateve;
        this.siperfaqeOborri = siperfaqeOborri;
    }

    // Getters dhe Setters specifike për Vilën
    public int getNumriKateve() { return numriKateve; }
    public void setNumriKateve(int numriKateve) { this.numriKateve = numriKateve; }

    public double getSiperfaqeOborri() { return siperfaqeOborri; }
    public void setSiperfaqeOborri(double siperfaqeOborri) { this.siperfaqeOborri = siperfaqeOborri; }

    // Mbishkrimi i metodës toString() për Vilën
    @Override
    public String toString() {
        return super.toString() + " | Tipologjia: Vile (Kate: " + numriKateve + ", Oborr: " + siperfaqeOborri + " m²)";
    }
}