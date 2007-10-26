package src.br.com.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import src.br.com.model.Entidade;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import src.br.com.controller.EntidadeController;

abstract class FrameModel extends javax.swing.JFrame {
    private List<Entidade> entidades;
    private DefaultTableModel model; 
    protected Entidade entidade;
    private Class entidadeClass;
    private EntidadeController controller;
    
    public FrameModel() {
      try {
        controller = new EntidadeController();  
        model = new DefaultTableModel();
        String nomeClasse = this.getClass().getSimpleName();
        nomeClasse = "src.br.com.model."+ nomeClasse.substring(0, nomeClasse.length() - 4);
        entidadeClass = Class.forName(nomeClasse);
        init();
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(FrameModel.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
        
    private void init(){
        initComponents();
        model.addColumn("Listagem");
        setModel();
        tableEntidade.setModel(model);
        tableEntidade.addMouseListener(new MouseTableHandler());
        // Propriedades do frame.
        setVisible(true);
        setResizable(false);
        setLocation(370, 200);
    }
    
    private void setModel(){
        entidades = controller.list(this.entidadeClass);
        model.setNumRows(entidades.size());
        int row = 0;
        for(Entidade ent: entidades){
          model.setValueAt(ent.getNome(), row, 0);
          row++;
        }
    }
    
    protected void setEnabledComponent(boolean b){
      int count = this.getContentPane().getComponentCount();
      for(int i=0; i < count; i++){
        Component component = this.getContentPane().getComponent(i);
        if((component instanceof JTextField) ||
           (component instanceof JComboBox)||
           (component instanceof JButton)||
           (component instanceof JCheckBox)||
           (component instanceof JRadioButton))
          component.setEnabled(b);    
        }
    }
    
    protected void setField(){};
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableEntidade = new javax.swing.JTable();
        btnInserir = new javax.swing.JToggleButton();
        btnDeletar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tableEntidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableEntidade);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteModel(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salveModel(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(btnInserir)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnDeletar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnSalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 172, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSalvar)
                    .add(btnDeletar)
                    .add(btnInserir)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearField(){
      int count = this.getContentPane().getComponentCount();
      for(int i=0; i < count; i++){
        Component component = this.getContentPane().getComponent(i);
        if(component instanceof JTextField){
          JTextField txt = (JTextField) component;   
          txt.setText("");
        }
      }
    }
    
    private void insert(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert
        try {
            entidade = (Entidade) entidadeClass.newInstance();
            String[] row = {""};
            model.addRow(row);
            // Habilita os objetos do formuário.
            setEnabledComponent(true);
            // Limpa os campos.
            clearField();
        } catch (InstantiationException ex) {
            Logger.getLogger(FrameModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_insert

    private void deleteModel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteModel
        controller.delete(entidade);
        setField();
        JOptionPane.showMessageDialog(null, "Registro deletado com sucesso!", "Deletar", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_deleteModel

    protected void beforeSave(){}
    
    private void salveModel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salveModel
        beforeSave();
        controller.save(entidade);
        // Exibe o registro no grid.
        setModel();
       JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);
}//GEN-LAST:event_salveModel

    class MouseTableHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent me){
            setEnabledComponent(true);
            entidade = entidades.get(tableEntidade.getSelectedRow());
            setField();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JToggleButton btnInserir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEntidade;
    // End of variables declaration//GEN-END:variables
    
}
