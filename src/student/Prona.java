package student;

public class Prona {
    private String idProna;
    private String statusi; // "Qera" ose "Shitje"
    private String qyteti;
    private String zona;
    String rruga;
    private double siperfaqe;
    private double cmimi;
    private boolean kaCertifikate;

    // Konstruktori per inicializimin e te dhenave
    public Prona(String idProna, String statusi, String qyteti, String zona, String rruga, double siperfaqe, double cmimi, boolean kaCertifikate) {
        this.idProna = idProna;
        this.statusi = statusi;
        this.qyteti = qyteti;
        this.zona = zona;
        this.rruga = rruga;
        this.siperfaqe = siperfaqe;
        this.cmimi = cmimi;
        this.kaCertifikate = kaCertifikate;
    }
    public double getCmimiTotal() {
    return this.cmimi * this.siperfaqe;
}

    // Metodat Getters dhe Setters
    public String getIdProna() { return idProna; }
    public void setIdProna(String idProna) { this.idProna = idProna; }

    public String getStatusi() { return statusi; }
    public void setStatusi(String statusi) { this.statusi = statusi; }

    public String getQyteti() { return qyteti; }
    public void setQyteti(String qyteti) { this.qyteti = qyteti; }

    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }
    
    public String getRruga() { return rruga; }
    public void setRruga(String rruga) { this.rruga = rruga; }

    public double getSiperfaqe() { return siperfaqe; }
    public void setSiperfaqe(double siperfaqe) { this.siperfaqe = siperfaqe; }

    public double getCmimi() { return cmimi; }
    public void setCmimi(double cmimi) { this.cmimi = cmimi; }

    public boolean isKaCertifikate() { return kaCertifikate; }
    public void setKaCertifikate(boolean kaCertifikate) { this.kaCertifikate = kaCertifikate; }

    // Metoda toString e mbishkruar (Override) per te kthyer informacionin ne forme teksti
    @Override
    public String toString() {
    return "ID: " + idProna + " | Statusi: " + statusi + " | Lokacioni: " + qyteti + " (" + zona + 
           ") + (" + rruga + ")+ | Sip: " + siperfaqe + " m² | Çmimi / m²: " + cmimi + " € | Total: " + getCmimiTotal() + " € | Certifikate: " + (kaCertifikate ? "Po" : "Jo");
    }
}