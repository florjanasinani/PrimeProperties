package student;

public class Apartament extends Prona {
    private int numriDhomave;
    private int numriTualeteve;
    private int kati;

    // Konstruktori që thërret konstruktorin e klasës bazë me anë të super()
    public Apartament(String idProna, String statusi, String qyteti, String zona, String rruga, double siperfaqe, double cmimi, 
                      boolean kaCertifikate, int numriDhomave, int numriTualeteve, int kati) {
        super(idProna, statusi, qyteti, zona, rruga, siperfaqe, cmimi, kaCertifikate);
        this.numriDhomave = numriDhomave;
        this.numriTualeteve = numriTualeteve;
        this.kati = kati;
    }

    // Getters dhe Setters specifike për Apartamentin
    public int getNumriDhomave() { return numriDhomave; }
    public void setNumriDhomave(int numriDhomave) { this.numriDhomave = numriDhomave; }

    public int getNumriTualeteve() { return numriTualeteve; }
    public void setNumriTualeteve(int numriTualeteve) { this.numriTualeteve = numriTualeteve; }

    public int getKati() { return kati; }
    public void setKati(int kati) { this.kati = kati; }

    // Mbishkrimi i metodës toString() duke përfshirë edhe të dhënat e klasës bazë përmes super.toString()
    @Override
    public String toString() {
        return super.toString() + " | Tipologjia: Apartament (Dhome: " + numriDhomave + ", Tualete: " + numriTualeteve + ", Kati: " + kati + ")";
    }
}