package src.br.com.view;


public class Menu extends javax.swing.JFrame {
    
    public Menu() {
        initComponents();
        setVisible(true);
        setResizable(false);
        setLocation(300, 100);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        cadastro = new javax.swing.JMenu();
        hospede = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SysReserva");

        cadastro.setText("Cadastrar");

        hospede.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        hospede.setText("Hospede");
        hospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarHospede(evt);
            }
        });
        cadastro.add(hospede);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Serviço");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarServico(evt);
            }
        });
        cadastro.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Apartamento");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarApartamento(evt);
            }
        });
        cadastro.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Temporada");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarTemporada(evt);
            }
        });
        cadastro.add(jMenuItem3);

        menuBar.add(cadastro);

        jMenu1.setText("Efetuar");

        jMenuItem5.setText("Reserva");
        jMenu1.add(jMenuItem5);

        jMenuItem4.setText("Hospedagem");
        jMenu1.add(jMenuItem4);

        menuBar.add(jMenu1);

        jMenu2.setText("Encerrar");

        jMenuItem6.setText("Hospedagem");
        jMenu2.add(jMenuItem6);

        menuBar.add(jMenu2);

        jMenu3.setText("Sair");
        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 749, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 493, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarHospede(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarHospede
        new HospedeView();
}//GEN-LAST:event_cadastrarHospede

    private void cadastrarServico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarServico
        new ServicoView();
}//GEN-LAST:event_cadastrarServico

    private void cadastrarApartamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarApartamento
        new ApartamentoView();
}//GEN-LAST:event_cadastrarApartamento

    private void cadastrarTemporada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarTemporada
        new TemporadaView();
    }//GEN-LAST:event_cadastrarTemporada
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cadastro;
    private javax.swing.JMenuItem hospede;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
    
}
