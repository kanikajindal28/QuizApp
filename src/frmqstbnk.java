
import buslogic.*;
import buslogic.clscatprp;
import buslogic.clsqst;
import buslogic.clsqstprp;
import java.awt.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csgroup
 */
public class frmqstbnk extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmqstbnk
     */
    ArrayList<Integer> arr;
    public frmqstbnk() {
        initComponents();
        DefaultTableColumnModel cmod=(DefaultTableColumnModel)
                jTable1.getColumnModel();
        TableColumn col=cmod.getColumn(0);
        col.setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
               JLabel lbl=new JLabel();
                lbl.setIcon((ImageIcon)o);
                lbl.setSize(100, 100);
                return lbl;
            }
        });
        col.setWidth(150);
        jTable1.setRowHeight(100);
        
        clscat obj=new clscat();
        List<clscatprp> k=obj.dspcat();
        DefaultComboBoxModel mod=new DefaultComboBoxModel();
        arr=new ArrayList<Integer>();
        for(clscatprp p:k)
        {
            mod.addElement(p.getCatnam());
            arr.add(p.getCatcod());
        }
        cmbcat.setModel(mod);
        cmbcat.setSelectedIndex(0);
        cmblvl.setSelectedIndex(0);
        loaddata();
    }
    
    public void loaddata()
    {
         DefaultTableModel mod=(DefaultTableModel)(jTable1.getModel());
        mod.setRowCount(0);
        clsqst obj=new clsqst();
        try {
            List<clsqstprp> k=obj.dspqst(arr.get
                (cmbcat.getSelectedIndex()),
                    cmblvl.getSelectedItem().toString().substring(0,1).toString());
            for(clsqstprp p:k)
            {
                Object[] rowdata=new Object[2];
               rowdata[1]=p.getQstdsc();
               ImageIcon icn;
  if(p.getQstimg()!="")
icn=new ImageIcon(getClass().getResource("qstpics/"+p.getQstimg()));
 else
icn=new ImageIcon(getClass().getResource("qstpics/nopic.jpg"));
               rowdata[0]=icn;
               mod.addRow(rowdata);
            }
            jTable1.setModel(mod);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmqstbnk.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbcat = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmblvl = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setTitle("Question Bank");

        jLabel1.setText("Select Category");

        cmbcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcatActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Level");

        cmblvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginer", "Intermediate", "Expert" }));
        cmblvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmblvlActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "Question Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbcat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmblvl, 0, 207, Short.MAX_VALUE))
                        .addGap(176, 176, 176))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmblvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcatActionPerformed
        // TODO add your handling code here:
        loaddata();
    }//GEN-LAST:event_cmbcatActionPerformed

    private void cmblvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmblvlActionPerformed
        // TODO add your handling code here:
        loaddata();
    }//GEN-LAST:event_cmblvlActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbcat;
    private javax.swing.JComboBox<String> cmblvl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
