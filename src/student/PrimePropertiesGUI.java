package student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PrimePropertiesGUI extends JFrame {
    // Lista polimorfike per ruajtjen e pronave
    private ArrayList<Prona> listaPronave = new ArrayList<>();

    // Komponentet e GUI-t per Regjistrimin
    private JTextField txtId, txtQyteti, txtZona, txtSiperfaqe, txtCmimi, txtRruga;
    private JComboBox<String> cbStatusi, cbLlojiPrones;
    private JCheckBox chkCertifikate;
    private JTextField txtCmimiTotalAfishim;
    // Fushat dinamike per subklasat
    
    private JTextField txtSpecifike1, txtSpecifike2;
    private JLabel lblSpecifike1, lblSpecifike2;
    private JTextField txtKati;
    private JLabel lblKati;

    // Komponentet e GUI-t per Kerkimin dhe Filtrimin
    private JTextField txtSearch, txtCmimiMin, txtCmimiMax, txtSipMin, txtSipMax;
    private JTextArea txtAreaOutput;

    public PrimePropertiesGUI() {
        try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        setTitle("Sistemi i Menaxhimit te Agjencise Imobiliare - PrimeProperties");
        setSize(850, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. PANELI I REGJISTRIMIT
        JPanel panelRegjistrimi = new JPanel(new GridLayout(13, 2, 5, 5));
        panelRegjistrimi.setBorder(BorderFactory.createTitledBorder("Regjistrimi i Pronave te Reja"));

        panelRegjistrimi.add(new JLabel("Lloji i Prones:"));
        cbLlojiPrones = new JComboBox<>(new String[]{"Apartament", "Vile", "Ambient Biznesi"});
        panelRegjistrimi.add(cbLlojiPrones);

        panelRegjistrimi.add(new JLabel("ID Prona:"));
        txtId = new JTextField();
        panelRegjistrimi.add(txtId);

        panelRegjistrimi.add(new JLabel("Statusi (Qera/Shitje):"));
        cbStatusi = new JComboBox<>(new String[]{"Shitje", "Qera"});
        panelRegjistrimi.add(cbStatusi);

        panelRegjistrimi.add(new JLabel("Qyteti:"));
        txtQyteti = new JTextField();
        panelRegjistrimi.add(txtQyteti);

        panelRegjistrimi.add(new JLabel("Zona:"));
        txtZona = new JTextField();
        panelRegjistrimi.add(txtZona);
        
        panelRegjistrimi.add(new JLabel("Rruga:"));
        txtRruga = new JTextField();
        panelRegjistrimi.add(txtRruga);

        panelRegjistrimi.add(new JLabel("Siperfaqe Neto (m²):"));
        txtSiperfaqe = new JTextField();
        panelRegjistrimi.add(txtSiperfaqe);

        panelRegjistrimi.add(new JLabel("Cmimi (€ / m²):"));
        txtCmimi = new JTextField();
        panelRegjistrimi.add(txtCmimi);
        
        panelRegjistrimi.add(new JLabel("Çmimi Total Llogaritur (€):"));
        txtCmimiTotalAfishim = new JTextField();
        txtCmimiTotalAfishim.setEditable(false); 
        txtCmimiTotalAfishim.setBackground(Color.LIGHT_GRAY);
        panelRegjistrimi.add(txtCmimiTotalAfishim);

        panelRegjistrimi.add(new JLabel("Certifikate Pronesie:"));
        chkCertifikate = new JCheckBox("Po, disponon certifikate");
        panelRegjistrimi.add(chkCertifikate);

        // Fushat qe do te ndryshojne dinamikisht
        lblSpecifike1 = new JLabel("Numri i Dhomave:");
        txtSpecifike1 = new JTextField();
        panelRegjistrimi.add(lblSpecifike1); panelRegjistrimi.add(txtSpecifike1);

        lblSpecifike2 = new JLabel("Numri i Tualeteve:");
        txtSpecifike2 = new JTextField();
        panelRegjistrimi.add(lblSpecifike2); panelRegjistrimi.add(txtSpecifike2);

        lblKati = new JLabel("Kati:");
        txtKati = new JTextField();
        panelRegjistrimi.add(lblKati);
        panelRegjistrimi.add(txtKati);
        
        // 2. PANELI I KERKIMIT DHE FILTRIMIT (Dizajni i rregulluar)
        JPanel panelFiltraKryesor = new JPanel(new BorderLayout(10, 10));
        panelFiltraKryesor.setBorder(BorderFactory.createTitledBorder("Paneli i Kerkimit dhe Filtrimit"));

        // Search bar në pjesën e sipërme
        JPanel panelSearchBar = new JPanel(new BorderLayout(5, 5));
        panelSearchBar.add(new JLabel("Kerko fjalë kyçe (Zona/Qyteti/ID): "), BorderLayout.WEST);
        txtSearch = new JTextField();
        panelSearchBar.add(txtSearch, BorderLayout.CENTER);
        panelFiltraKryesor.add(panelSearchBar, BorderLayout.NORTH);

        // Fushat Min/Max të organizuara si rrjet i pastër që nuk deformohet
        JPanel panelMinMax = new JPanel(new GridLayout(4, 2, 5, 5));
        
        panelMinMax.add(new JLabel("Cmimi Min (€):"));
        txtCmimiMin = new JTextField();
        panelMinMax.add(txtCmimiMin);
        
        panelMinMax.add(new JLabel("Cmimi Max (€):"));
        txtCmimiMax = new JTextField();
        panelMinMax.add(txtCmimiMax);

        panelMinMax.add(new JLabel("Sip. Min (m²):"));
        txtSipMin = new JTextField();
        panelMinMax.add(txtSipMin);

        panelMinMax.add(new JLabel("Sip. Max (m²):"));
        txtSipMax = new JTextField();
        panelMinMax.add(txtSipMax);

        // Kjo parandalon zgjatjen vertikale të fushave të tekstit
        JPanel panelMbajtes = new JPanel(new BorderLayout());
        panelMbajtes.add(panelMinMax, BorderLayout.NORTH); 

        panelFiltraKryesor.add(panelMbajtes, BorderLayout.CENTER);


        // 3. PANELI I BUTONAVE
        JPanel panelButona = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnShto = new JButton("Regjistro Prone");
        JButton btnFiltro = new JButton("Kerko & Filtro");
        JButton btnShfaqTeGjitha = new JButton("Shfaq te Gjitha");
        panelButona.add(btnShto); panelButona.add(btnFiltro); panelButona.add(btnShfaqTeGjitha);


        // 4.OUTPUT  (TEXT AREA)
        txtAreaOutput = new JTextArea();
        txtAreaOutput.setEditable(false);
        txtAreaOutput.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtAreaOutput);
        scrollPane.setPreferredSize(new Dimension(800, 220));


        // PANEL LAYOUT
        // 1. Krijojmë mbajtësin e skedave (Tabs)
        JTabbedPane tabbedPane = new JTabbedPane();

        // 2. Ndërtojmë Tab-in e parë: Regjistrimi
        JPanel tabRegjistrim = new JPanel(new BorderLayout(10, 10));
        tabRegjistrim.add(panelRegjistrimi, BorderLayout.CENTER);

        // Shtohet butoni i regjistrimit në fund të këtij tabi
        JPanel panelShtoButon = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelShtoButon.add(btnShto);
        tabRegjistrim.add(panelShtoButon, BorderLayout.SOUTH);

        // 3. Ndërtojmë Tab-in e dytë: Kërkimi dhe Rezultatet
        JPanel tabKerkim = new JPanel(new BorderLayout(10, 10));
        tabKerkim.add(panelFiltraKryesor, BorderLayout.NORTH);
        tabKerkim.add(scrollPane, BorderLayout.CENTER);

        // Shtojmë butonat e kërkimit dhe shfaqjes në fund të tabit të dytë
        JPanel panelKerkimButona = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelKerkimButona.add(btnFiltro);
        panelKerkimButona.add(btnShfaqTeGjitha);
        tabKerkim.add(panelKerkimButona, BorderLayout.SOUTH);

        // 4. Vendosim emrat e skedave
        tabbedPane.addTab("Regjistrimi i Pronave", tabRegjistrim);
        tabbedPane.addTab("Kërkimi & Lista", tabKerkim);

        // 5. Shtojmë të gjithë strukturën në dritaren kryesore
        add(tabbedPane, BorderLayout.CENTER);


        // LISTENERS (Logjika e butonave)
        cbLlojiPrones.addActionListener(e -> ndryshoFushatSpecifike());
        btnShto.addActionListener(e -> shtoProne());
        btnFiltro.addActionListener(e -> filtroProne());
        btnShfaqTeGjitha.addActionListener(e -> shfaqListen(listaPronave));
    }

    private void ndryshoFushatSpecifike() {
    String lloji = (String) cbLlojiPrones.getSelectedItem();
    if ("Apartament".equals(lloji)) {
        lblSpecifike1.setText("Numri i Dhomave:");
        lblSpecifike2.setText("Numri i Tualeteve:");
        lblKati.setVisible(true);   // Shfaq etiketën e katit
        txtKati.setVisible(true);   // Shfaq kutinë e katit
    } else if ("Vile".equals(lloji)) {
        lblSpecifike1.setText("Numri i Kateve:");
        lblSpecifike2.setText("Sip. Oborrit (m²):");
        lblKati.setVisible(false);  // Fshih etiketën
        txtKati.setVisible(false);  // Fshih kutinë
    } else if ("Ambient Biznesi".equals(lloji)) {
        lblSpecifike1.setText("Lloji i Ambientit:");
        lblSpecifike2.setText("Fasade Xhami (Po/Jo):");
        lblKati.setVisible(false);  // Fshih etiketën
        txtKati.setVisible(false);  // Fshih kutinë
    }
    revalidate(); repaint();
}

    private void shtoProne() {
        try {
            String id = txtId.getText().trim();
            String statusi = (String) cbStatusi.getSelectedItem();
            String qyteti = txtQyteti.getText().trim();
            String zona = txtZona.getText().trim();
            String rruga = txtRruga.getText().trim();
            double sip = Double.parseDouble(txtSiperfaqe.getText().trim());
            double cmimi = Double.parseDouble(txtCmimi.getText().trim());
            txtCmimiTotalAfishim.setText(String.valueOf(sip * cmimi));
            boolean certifikate = chkCertifikate.isSelected();
            String lloji = (String) cbLlojiPrones.getSelectedItem();

            if (id.isEmpty() || qyteti.isEmpty() || zona.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Plotesoni fushat baze!", "Paralajmerim", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if ("Apartament".equals(lloji)) {
            int dhome = Integer.parseInt(txtSpecifike1.getText().trim());
            int tualete = Integer.parseInt(txtSpecifike2.getText().trim());
            int katiReal = Integer.parseInt(txtKati.getText().trim()); 
            listaPronave.add(new Apartament(id, statusi, qyteti, zona, rruga, sip, cmimi, certifikate, dhome, tualete, katiReal));

            } else if ("Vile".equals(lloji)) {
                int kateTotal = Integer.parseInt(txtSpecifike1.getText().trim());
                double sipOborr = Double.parseDouble(txtSpecifike2.getText().trim());
                listaPronave.add(new Vile(id, statusi, qyteti, zona, rruga, sip, cmimi, certifikate, kateTotal, sipOborr));
            } else if ("Ambient Biznesi".equals(lloji)) {
                String llojiAmb = txtSpecifike1.getText().trim();
                boolean fasade = txtSpecifike2.getText().trim().equalsIgnoreCase("po");
                listaPronave.add(new AmbientBiznesi(id, statusi, qyteti, zona, rruga, sip, cmimi, certifikate, llojiAmb, fasade));
            }

            JOptionPane.showMessageDialog(this, "Prona " + id + " u regjistrua me sukses!");
            pastroFushatInput();
            shfaqListen(listaPronave);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Kontrolloni formatin e numrave!", "Gabim", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void filtroProne() {
        String keyword = txtSearch.getText().trim().toLowerCase();
        double cMin = txtCmimiMin.getText().trim().isEmpty() ? 0 : Double.parseDouble(txtCmimiMin.getText().trim());
        double cMax = txtCmimiMax.getText().trim().isEmpty() ? Double.MAX_VALUE : Double.parseDouble(txtCmimiMax.getText().trim());
        double sMin = txtSipMin.getText().trim().isEmpty() ? 0 : Double.parseDouble(txtSipMin.getText().trim());
        double sMax = txtSipMax.getText().trim().isEmpty() ? Double.MAX_VALUE : Double.parseDouble(txtSipMax.getText().trim());

        ArrayList<Prona> listaFiltrurar = new ArrayList<>();
        for (Prona p : listaPronave) {
            boolean matchesKeyword = keyword.isEmpty() || p.getZona().toLowerCase().contains(keyword) || p.getQyteti().toLowerCase().contains(keyword) || p.getIdProna().toLowerCase().contains(keyword);
            boolean matchesCmimi = p.getCmimiTotal() >= cMin && p.getCmimiTotal() <= cMax;
            boolean matchesSip = p.getSiperfaqe() >= sMin && p.getSiperfaqe() <= sMax;
            if (matchesKeyword && matchesCmimi && matchesSip) listaFiltrurar.add(p);
        }
        shfaqListen(listaFiltrurar);
    }

    private void shfaqListen(ArrayList<Prona> lista) {
        txtAreaOutput.setText("");
        if (lista.isEmpty()) {
            txtAreaOutput.setText("Nuk u gjend asnje prone.");
            return;
        }
        txtAreaOutput.append("--------------------- LISTA E PRONAVE (PRIMEPROPERTIES) ---------------------\n");
        for (Prona p : lista) txtAreaOutput.append(p.toString() + "\n");
    }

    private void pastroFushatInput() {
    txtId.setText(""); txtQyteti.setText(""); txtZona.setText(""); txtRruga.setText(""); txtSiperfaqe.setText(""); txtCmimi.setText("");
    txtSpecifike1.setText(""); txtSpecifike2.setText(""); chkCertifikate.setSelected(false);
    txtKati.setText("");txtCmimiTotalAfishim.setText("");
    }
}

