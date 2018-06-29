
import javax.swing.JOptionPane;
import java.awt.*;
import java.util.Map;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class MESSENINE extends javax.swing.JFrame {
    String nickname = "";
    Operator operator = new Operator(this);
    private Map<String, String> nicknames = new HashMap<>();
    /**
     * Creates new form MESSENINE
     */
    public MESSENINE() {
        initComponents();
    }

    public void onOpen (String sockName) {
        operator.send(sockName, "nickname", nickname_text.getText());
        jPanel1.scrollRectToVisible(new Rectangle(0, 0x7fffffff, 0, 0));
    }

    public void onClose (String sockName) {
        newChat("System", nicknames.get(sockName)+"離線", jPanel1, 1);
        list.removeElement(nicknames.get(sockName));
        nicknames.remove(sockName);
        jPanel1.scrollRectToVisible(new Rectangle(0, 0x7fffffff, 0, 0));
    }

    public void onMessage (String sockName, String type, String msg) {
        switch (type) {
            case "nickname":
                if (nicknames.containsKey(sockName)) {
                    if (! nicknames.get(sockName).equals(msg)) {
                        newChat("System", nicknames.get(sockName)+"更名為"+msg, jPanel1, 1);
                        list.removeElement(nicknames.get(sockName));
                        list.addElement(msg);
                        nicknames.put(sockName, msg);
                    }
                } else {
                    newChat("System", msg+"加入", jPanel1, 1);
                    list.addElement(msg);
                    nicknames.put(sockName, msg);
                }
                break;

            case "text":
                newChat(nicknames.get(sockName), msg, jPanel1, 0);
                break;

            default:
                newChat(sockName, "("+type+")"+msg, jPanel1, 0);

        }
        jPanel1.scrollRectToVisible(new Rectangle(0, 0x7fffffff, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        nicknamefield = new javax.swing.JTextField();
        getnickname = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        send = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        Yournickname_text = new javax.swing.JLabel();
        nickname_text = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jFrame1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                jFrame1WindowActivated(evt);
            }
        });

        jLabel2.setText("Enter your nickname:");

        getnickname.setText("Enter");
        getnickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getnicknameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(nicknamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getnickname)))
                .addGap(19, 19, 19))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicknamefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getnickname))
                .addGap(51, 51, 51))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Decentralized Chat");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        send.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        send.setText("send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        Yournickname_text.setText("Your nickname:");

        nickname_text.setText("Please input");

        jScrollPane1.setViewportView(jList1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setText("change nickname");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Yournickname_text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nickname_text))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Yournickname_text)
                            .addComponent(nickname_text))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       // jFrame1.setVisible(true);
        String defaultnickname = "";
        while(nickname.equals("")) {
            nickname = (String) JOptionPane.showInputDialog(this, "Please Enter your nickname", "", JOptionPane.QUESTION_MESSAGE, null, null, defaultnickname);
            if (nickname == null) {
                dispose();
                break;
            } else if (nickname.equals("")) {
                String randomnickname[] = new String[]{"Alice", "Bob", "Carol", "Dan", "Erin", "Eve", "Faythe", "Frank", "Grace", "Heidi", "Judy", "Mallory", "Niaj", "Olivia", "Oscar", "Peggy", "Sybil", "Trent", "Victor", "Walter", "Wendy"};
                defaultnickname = randomnickname[(int)(Math.random()*randomnickname.length)];
            }
        }
        nickname_text.setText(nickname);
        jList1.setModel(list);
        list.addElement(nickname);
        operator.launch("0.0.0.0", 9453);
        jTextArea2.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void jFrame1WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jFrame1WindowActivated
        jFrame1.setSize(290, 170);
    }//GEN-LAST:event_jFrame1WindowActivated

    private void getnicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getnicknameActionPerformed

//        nickname = nicknamefield.getText();
//        if(nickname.equals("")){
//        
//        }
//        else{
//            jFrame1.dispose();
//            nickname_text.setText(nickname);
//        }
    }//GEN-LAST:event_getnicknameActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        newChat(nickname_text.getText(), jTextArea2.getText(), jPanel1, 0);
        jPanel1.scrollRectToVisible(new Rectangle(0, 0x7fffffff, 0, 0));
        operator.send("text", jTextArea2.getText());
        jTextArea2.setText("");
        jTextArea2.requestFocusInWindow();
    }//GEN-LAST:event_sendActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // ADD YOUR CHANGE NICK NAME CODE HERE
    }//GEN-LAST:event_jMenuItem1ActionPerformed

 
int Vertical_Offset = 7;
boolean newChat(String name, String text, javax.swing.JPanel targetPanel, int mode){
    // 物件--------------------------------------------------------
    javax.swing.JPanel jPanel_tmp;
    javax.swing.JLabel jLabel_name;
    javax.swing.JTextArea jTextArea_text;
    javax.swing.JLabel jLabel_text;
    jPanel_tmp = new javax.swing.JPanel();
    jLabel_name = new javax.swing.JLabel();
    jTextArea_text = new javax.swing.JTextArea();
    jLabel_text = new javax.swing.JLabel();

    // 變數--------------------------------------------------------
    // 字串處理
    String Font_Name = "微軟正黑體"; //DialogInput
    int Font_Size    = 18;
    Font TEXT_FONT   = new Font(Font_Name, 0, Font_Size);  
    FontMetrics fm   = Toolkit.getDefaultToolkit().getFontMetrics(TEXT_FONT);
    int Font_Height  = fm.getHeight();
    // 名字
    int Name_Width   = fm.stringWidth(name);
    // System.out.println("NameWidth: " + Name_Width);
    // jPanel 高
    int Panel_padding = 30;
    int Panel_margin  = Panel_padding + 14;


    // 行數--------------------------------------------------------
    int text_rows = 1;
    for(int i = 0; i<text.length(); i++)
        if(text.charAt(i)=='\n')text_rows+=1;

    // 行寬--------------------------------------------------------
    String[] split_line = text.split("\n", -1);
    int maxWidth = 11;
    for (int line = 0; line<split_line.length; line++)
        maxWidth = Math.max(maxWidth, fm.stringWidth(split_line[line])) + 11;
    // System.out.println("MaxWidth: " + maxWidth);

    // 設定--------------------------------------------------------
    jLabel_name.setFont(new java.awt.Font(Font_Name, 0, Font_Size));
    jLabel_name.setText(name);

    jTextArea_text.setFont(new java.awt.Font(Font_Name, 0, Font_Size));
    jTextArea_text.setText(text);

    jLabel_text.setFont(new java.awt.Font(Font_Name, 0, Font_Size));
    jLabel_text.setText(text);


    int jPanel_Width = (maxWidth<=Name_Width?Name_Width:maxWidth) + 14;
    jPanel_tmp.setPreferredSize(new java.awt.Dimension(jPanel_Width, (text_rows + 1) * Font_Height + Panel_padding));  // Panel 寬&高

    javax.swing.GroupLayout jPanel_tmpLayout = new javax.swing.GroupLayout(jPanel_tmp);
    jPanel_tmp.setLayout(jPanel_tmpLayout);
    javax.swing.GroupLayout targetPanelLayout = new javax.swing.GroupLayout(targetPanel);

    switch(mode){
        default:
        case 0: // Normal block
            jPanel_tmp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            jLabel_name.setForeground(new java.awt.Color(0, 0, 0));
            jPanel_tmpLayout.setHorizontalGroup(
                jPanel_tmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_tmpLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel_tmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel_name)
                        .addComponent(jTextArea_text, javax.swing.GroupLayout.PREFERRED_SIZE, maxWidth, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(80, Short.MAX_VALUE))
            );
            jPanel_tmpLayout.setVerticalGroup(
                jPanel_tmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_tmpLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextArea_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE))
            );
            break;
        case 1: // System block
            jLabel_name.setForeground(new java.awt.Color(255, 0, 0));
            jPanel_tmpLayout.setHorizontalGroup(
                jPanel_tmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_tmpLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel_tmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel_name)
                        .addComponent(jLabel_text, javax.swing.GroupLayout.PREFERRED_SIZE, maxWidth, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(80, Short.MAX_VALUE))
            );
            jPanel_tmpLayout.setVerticalGroup(
                jPanel_tmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_tmpLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE))
            );
            break;
    }
    targetPanelLayout.setHorizontalGroup(
        targetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(targetPanelLayout.createSequentialGroup()
            .addGap(7)  // Left Padding = 7
            .addComponent(jPanel_tmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(0, Short.MAX_VALUE))
    );
    targetPanelLayout.setVerticalGroup(
        targetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(targetPanelLayout.createSequentialGroup()
            .addGap(Vertical_Offset)
            .addComponent(jPanel_tmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(0, Short.MAX_VALUE))
    );
    targetPanel.setLayout(targetPanelLayout);

    Vertical_Offset += (text_rows + 1) * Font_Height + Panel_margin;
    return true;
}

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MESSENINE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MESSENINE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MESSENINE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MESSENINE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MESSENINE().setVisible(true);
            }
        });
    }
    DefaultListModel list = new DefaultListModel();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Yournickname_text;
    private javax.swing.JButton getnickname;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel nickname_text;
    private javax.swing.JTextField nicknamefield;
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables
}
