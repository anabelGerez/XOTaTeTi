/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ar.itse.presentation.view;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class ViewJuego extends javax.swing.JFrame {

    int xMouse, yMouse;

    public static int count;

    /**
     * Creates new form ViewJuego
     */
    public ViewJuego() {
        initComponents();
    }

    int v1, v2, v3, v4, v5, v6, v7, v8, v9;
    boolean done = false;
    boolean fin = false;

    void reset() {

        v1 = 0;
        v2 = 0;
        v3 = 0;
        v4 = 0;
        v5 = 0;
        v6 = 0;
        v7 = 0;
        v8 = 0;
        v9 = 0;

        //Dejar un button como ya habilitado
        btnCasilla1.setText("");
        btnCasilla1.setEnabled(true);

        btnCasilla2.setText("");
        btnCasilla2.setEnabled(true);

        btnCasilla3.setText("");
        btnCasilla3.setEnabled(true);

        btnCasilla4.setText("");
        btnCasilla4.setEnabled(true);

        btnCasilla5.setText("");
        btnCasilla5.setEnabled(true);

        btnCasilla6.setText("");
        btnCasilla6.setEnabled(true);

        btnCasilla7.setText("");
        btnCasilla7.setEnabled(true);

        btnCasilla8.setText("");
        btnCasilla8.setEnabled(true);

        btnCasilla9.setText("");
        btnCasilla9.setEnabled(true);

        done = false;
        fin = false;
    }

    void Marcar(int player, int poss) {
        switch (player) {
            case 1:
                switch (poss) {
                    case 1:
                        v1 = 1;
                        btnCasilla1.setText("X");
                        btnCasilla1.setEnabled(false);
                        break;

                    case 2:
                        v2 = 1;
                        btnCasilla2.setText("X");
                        btnCasilla2.setEnabled(false);
                        break;
                    case 3:
                        v3 = 1;
                        btnCasilla3.setText("X");
                        btnCasilla3.setEnabled(false);
                        break;
                    case 4:
                        v4 = 1;
                        btnCasilla4.setText("X");
                        btnCasilla4.setEnabled(false);
                        break;
                    case 5:
                        v5 = 1;
                        btnCasilla5.setText("X");
                        btnCasilla5.setEnabled(false);
                        break;
                    case 6:
                        v6 = 1;
                        btnCasilla6.setText("X");
                        btnCasilla6.setEnabled(false);
                        break;
                    case 7:
                        v7 = 1;
                        btnCasilla7.setText("X");
                        btnCasilla7.setEnabled(false);
                        break;
                    case 8:
                        v8 = 1;
                        btnCasilla8.setText("X");
                        btnCasilla8.setEnabled(false);
                        break;
                    case 9:
                        v9 = 1;
                        btnCasilla9.setText("X");
                        btnCasilla9.setEnabled(false);
                        break;
                }
                break;
            case 2:
                switch (poss) {
                    case 1:
                        v1 = 2;
                        btnCasilla1.setText("O");
                        btnCasilla1.setEnabled(false);
                        break;
                    case 2:
                        v2 = 2;
                        btnCasilla2.setText("O");
                        btnCasilla2.setEnabled(false);
                        break;
                    case 3:
                        v3 = 2;
                        btnCasilla3.setText("O");
                        btnCasilla3.setEnabled(false);
                        break;
                    case 4:
                        v4 = 2;
                        btnCasilla4.setText("O");
                        btnCasilla4.setEnabled(false);
                        break;
                    case 5:
                        v5 = 2;
                        btnCasilla5.setText("O");
                        btnCasilla5.setEnabled(false);
                        break;
                    case 6:
                        v6 = 2;
                        btnCasilla6.setText("O");
                        btnCasilla6.setEnabled(false);
                        break;
                    case 7:
                        v7 = 2;
                        btnCasilla7.setText("O");
                        btnCasilla7.setEnabled(false);
                        break;
                    case 8:
                        v8 = 2;
                        btnCasilla8.setText("O");
                        btnCasilla8.setEnabled(false);
                        break;
                    case 9:
                        v9 = 2;
                        btnCasilla9.setText("O");
                        btnCasilla9.setEnabled(false);
                        break;
                }
                break;
        }
    }

    void Computadora() {
        done = false;
        fin = false;

        boolean gano = winner(2);

        if (gano) {
            JOptionPane.showMessageDialog(null, "Ganaste!! :(", "Ta-Te-TI!", JOptionPane.PLAIN_MESSAGE);
            reset();
            fin = true;
            return;
        }
        if (!done && !fin) {
            System.out.println("Tratando de ganar");
            ganar();

            bloqueo();

            centro();

            allBloqueo();
        }
        if (!done && !fin && v3 == 0) {
            Marcar(1, 3);
            done = true;
        }

        if (done && !fin) {
            gano = winner(1);
            if (gano) {
                JOptionPane.showMessageDialog(null, "¡Perdiste!", "Ta-Te-TI! ", JOptionPane.PLAIN_MESSAGE);
                reset();
                fin = true;
            }
        }

        if (v1 != 0 && v2 != 0 && v3 != 0 && v4 != 0 && v5 != 0 && v6 != 0 && v7 != 0 && v8 != 0 && v9 != 0) {
            JOptionPane.showMessageDialog(null, "Nunca podras ganarme!!", "Juego", JOptionPane.PLAIN_MESSAGE);
            reset();
        }
    }

    boolean winner(int player) {
        boolean gano = false;
        switch (player) {
            case 1:
                if (v1 == 1 && v2 == 1 && v3 == 1) {
                    gano = true;
                }
                if (v4 == 1 && v5 == 1 && v6 == 1) {
                    gano = true;
                }
                if (v7 == 1 && v8 == 1 && v9 == 1) {
                    gano = true;
                }
                if (v1 == 1 && v4 == 1 && v7 == 1) {
                    gano = true;
                }
                if (v2 == 1 && v5 == 1 && v8 == 1) {
                    gano = true;
                }
                if (v3 == 1 && v6 == 1 && v9 == 1) {
                    gano = true;
                }
                if (v1 == 1 && v5 == 1 && v9 == 1) {
                    gano = true;
                }
                if (v3 == 1 && v5 == 1 && v7 == 1) {
                    gano = true;
                }
                break;

            case 2:
                if (v1 == 2 && v2 == 2 && v3 == 2) {
                    gano = true;
                }
                if (v4 == 2 && v5 == 2 && v6 == 2) {
                    gano = true;
                }
                if (v7 == 2 && v8 == 2 && v9 == 2) {
                    gano = true;
                }
                if (v1 == 2 && v4 == 2 && v7 == 2) {
                    gano = true;
                }
                if (v2 == 2 && v5 == 2 && v8 == 2) {
                    gano = true;
                }
                if (v3 == 2 && v6 == 2 && v9 == 2) {
                    gano = true;
                }
                if (v1 == 2 && v5 == 2 && v9 == 2) {
                    gano = true;
                }
                if (v3 == 2 && v5 == 2 && v7 == 2) {
                    gano = true;
                }
                break;

        }
        return gano;
    }

    void bloqueo() {
        //primera fila horizontal
        if (v1 == 2 && v2 == 2 && v3 == 0 && !done) {
            Marcar(1, 3);
            done = true;
        }
        if (v1 == 2 && v2 == 0 && v3 == 2 && !done) {
            Marcar(1, 2);
            done = true;

        }
        if (v1 == 0 && v2 == 2 && v3 == 2 && !done) {
            Marcar(1, 1);
            done = true;
        }

        //segunda fila horizontal
        if (v4 == 2 && v5 == 2 && v6 == 0 && !done) {
            Marcar(1, 6);
            done = true;
        }
        if (v4 == 2 && v5 == 0 && v6 == 2 && !done) {
            Marcar(1, 5);
            done = true;
        }
        if (v4 == 0 && v5 == 2 && v6 == 2 && !done) {
            Marcar(1, 4);
            done = true;
        }

        //tercera fila horizontal
        if (v7 == 2 && v8 == 2 && v9 == 0 && !done) {
            Marcar(1, 9);
            done = true;
        }
        if (v7 == 2 && v8 == 0 && v9 == 2 && !done) {
            Marcar(1, 8);
            done = true;
        }
        if (v7 == 0 && v8 == 2 && v9 == 2 && !done) {
            Marcar(1, 7);
            done = true;
        }

        //primera vertical
        if (v1 == 2 && v4 == 2 && v7 == 0 && !done) {
            Marcar(1, 7);
            done = true;
        }
        if (v1 == 2 && v4 == 0 && v7 == 2 && !done) {
            Marcar(1, 4);
            done = true;
        }
        if (v1 == 0 && v4 == 2 && v7 == 2 && !done) {
            Marcar(1, 1);
            done = true;
        }

        //segunda vertical
        if (v2 == 2 && v5 == 2 && v8 == 0 && !done) {
            Marcar(1, 8);
            done = true;
        }
        if (v2 == 2 && v5 == 0 && v8 == 2 && !done) {
            Marcar(1, 5);
            done = true;
        }
        if (v2 == 0 && v5 == 2 && v8 == 2 && !done) {
            Marcar(1, 2);
            done = true;
        }

        //tercera vertical
        if (v3 == 2 && v6 == 2 && v9 == 0 && !done) {
            Marcar(1, 9);
            done = true;
        }
        if (v3 == 2 && v6 == 0 && v9 == 2 && !done) {
            Marcar(1, 6);
            done = true;
        }
        if (v3 == 0 && v6 == 2 && v9 == 2 && !done) {
            Marcar(1, 3);
            done = true;
        }

        //primera diagonal
        if (v1 == 2 && v5 == 2 && v9 == 0 && !done) {
            Marcar(1, 9);
            done = true;
        }
        if (v1 == 2 && v5 == 0 && v9 == 2 && !done) {
            Marcar(1, 5);
            done = true;
        }
        if (v1 == 0 && v5 == 2 && v9 == 2 && !done) {
            Marcar(1, 1);
            done = true;
        }

        //segunda diagonal
        if (v3 == 2 && v5 == 2 && v7 == 0 && !done) {
            Marcar(1, 7);
            done = true;
        }
        if (v3 == 2 && v5 == 0 && v7 == 2 && !done) {
            Marcar(1, 5);
            done = true;
        }
        if (v3 == 0 && v5 == 2 && v7 == 2 && !done) {
            Marcar(1, 3);
            done = true;

        }

    }

    void ganar() {

        if (v1 == 1 && v2 == 1 && v3 == 0 && !done) {
            Marcar(1, 3);

            done = true;
        }
        if (v1 == 1 && v2 == 0 && v3 == 1 && !done) {
            Marcar(1, 2);
            done = true;

        }
        if (v1 == 0 && v2 == 1 && v3 == 1 && !done) {
            Marcar(1, 1);
            done = true;
        }

        //segunda fila horizontal
        if (v4 == 1 && v5 == 1 && v6 == 0 && !done) {
            Marcar(1, 6);
            done = true;
        }
        if (v4 == 1 && v5 == 0 && v6 == 1 && !done) {
            Marcar(1, 5);
            done = true;
        }
        if (v4 == 0 && v5 == 1 && v6 == 1 && !done) {
            Marcar(1, 4);
            done = true;
        }

        //tercera fila horizontal
        if (v7 == 1 && v8 == 1 && v9 == 0 && !done) {
            Marcar(1, 9);
            done = true;
        }
        if (v7 == 1 && v8 == 0 && v9 == 1 && !done) {
            Marcar(1, 8);
            done = true;
        }
        if (v7 == 0 && v8 == 1 && v9 == 1 && !done) {
            Marcar(1, 7);
            done = true;
        }

        //primera vertical
        if (v1 == 1 && v4 == 1 && v7 == 0 && !done) {
            Marcar(1, 7);
            done = true;
        }
        if (v1 == 1 && v4 == 0 && v7 == 1 && !done) {
            Marcar(1, 4);
            done = true;
        }
        if (v1 == 0 && v4 == 1 && v7 == 1 && !done) {
            Marcar(1, 1);
            done = true;
        }
        //segunda vertical
        if (v2 == 1 && v5 == 1 && v8 == 0 && !done) {
            Marcar(1, 8);
            done = true;
        }
        if (v2 == 1 && v5 == 0 && v8 == 1 && !done) {
            Marcar(1, 5);
            done = true;
        }
        if (v2 == 0 && v5 == 1 && v8 == 1 && !done) {
            Marcar(1, 2);
            done = true;
        }
        //tercera vertical
        if (v3 == 1 && v6 == 1 && v9 == 0 && !done) {
            Marcar(1, 9);
            done = true;
        }
        if (v3 == 1 && v6 == 0 && v9 == 1 && !done) {
            Marcar(1, 6);
            done = true;
        }
        if (v3 == 0 && v6 == 1 && v9 == 1 && !done) {
            Marcar(1, 3);

            done = true;
        }
        //primera diagonal
        if (v1 == 1 && v5 == 1 && v9 == 0 && !done) {
            Marcar(1, 9);
            done = true;
        }
        if (v1 == 1 && v5 == 0 && v9 == 1 && !done) {
            Marcar(1, 5);
            done = true;
        }
        if (v1 == 0 && v5 == 1 && v9 == 1 && !done) {
            Marcar(1, 1);
            done = true;
        }
        //segunda diagonal
        if (v3 == 1 && v5 == 1 && v7 == 0 && !done) {
            Marcar(1, 7);
            done = true;
        }
        if (v3 == 1 && v5 == 0 && v7 == 1 && !done) {
            Marcar(1, 5);
            done = true;
        }
        if (v3 == 0 && v5 == 1 && v7 == 1 && !done) {
            Marcar(1, 3);

            done = true;
        }
    }

    void centro() {

        if (v5 == 0 && !done) {
            Marcar(1, 5);
            done = true;
        }

    }

    void recorrer() {
        if (v1 == 0 && !done) {
            Marcar(1, 1);
            done = true;
        }
        if (v2 == 0 && !done) {
            Marcar(1, 2);
            done = true;

        }
        if (v3 == 0 && !done) {
            Marcar(1, 3);
            done = true;

        }
        if (v4 == 0 && !done) {
            Marcar(1, 4);
            done = true;
        }
        if (v5 == 0 && !done) {
            Marcar(1, 5);
            done = true;
        }
        if (v6 == 0 && !done) {
            Marcar(1, 6);
            done = true;
        }
        if (v7 == 0 && !done) {
            Marcar(1, 7);
            done = true;
        }
        if (v8 == 0 && !done) {
            Marcar(1, 8);
            done = true;
        }
        if (v9 == 0 && !done) {
            Marcar(1, 9);
            done = true;
        }
    }

    void allBloqueo() {
        if (v4 == 2 && v5 == 1 && v9 == 2 && v7 == 0 && !done) {
            Marcar(1, 7);
            done = true;
        }
        if (v1 == 2 && v5 == 1 && v9 == 2 && v8 == 0 && !done) {
            Marcar(1, 8);
            done = true;
        }
        if (v3 == 2 && v5 == 1 && v7 == 2 && v4 == 0 && !done) {
            Marcar(1, 4);
            done = true;
        }
        if (v3 == 2 && v5 == 1 && v8 == 2 && v6 == 0 && !done) {
            Marcar(1, 6);
            done = true;
        }
        if (v1 == 2 && v5 == 1 && v8 == 2 && v7 == 0 && !done) {
            Marcar(1, 7);
            done = true;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCasilla1 = new javax.swing.JButton();
        btnCasilla2 = new javax.swing.JButton();
        btnCasilla3 = new javax.swing.JButton();
        btnCasilla4 = new javax.swing.JButton();
        btnCasilla5 = new javax.swing.JButton();
        btnCasilla6 = new javax.swing.JButton();
        btnCasilla7 = new javax.swing.JButton();
        btnCasilla8 = new javax.swing.JButton();
        btnCasilla9 = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(677, 464));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblSalir.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        lblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir.setText("X");
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblSalir.setPreferredSize(new java.awt.Dimension(40, 40));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 640, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 40));

        jPanel2.setBackground(new java.awt.Color(175, 170, 217));

        btnCasilla1.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        btnCasilla1.setBorder(null);
        btnCasilla1.setBorderPainted(false);
        btnCasilla1.setDefaultCapable(false);
        btnCasilla1.setFocusPainted(false);
        btnCasilla1.setOpaque(true);
        btnCasilla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasilla1ActionPerformed(evt);
            }
        });

        btnCasilla2.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        btnCasilla2.setBorder(null);
        btnCasilla2.setBorderPainted(false);
        btnCasilla2.setDefaultCapable(false);
        btnCasilla2.setFocusPainted(false);
        btnCasilla2.setOpaque(true);
        btnCasilla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasilla2ActionPerformed(evt);
            }
        });

        btnCasilla3.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        btnCasilla3.setBorder(null);
        btnCasilla3.setBorderPainted(false);
        btnCasilla3.setDefaultCapable(false);
        btnCasilla3.setFocusPainted(false);
        btnCasilla3.setOpaque(true);
        btnCasilla3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasilla3ActionPerformed(evt);
            }
        });

        btnCasilla4.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        btnCasilla4.setBorder(null);
        btnCasilla4.setBorderPainted(false);
        btnCasilla4.setDefaultCapable(false);
        btnCasilla4.setFocusPainted(false);
        btnCasilla4.setOpaque(true);
        btnCasilla4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasilla4ActionPerformed(evt);
            }
        });

        btnCasilla5.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        btnCasilla5.setBorder(null);
        btnCasilla5.setBorderPainted(false);
        btnCasilla5.setDefaultCapable(false);
        btnCasilla5.setFocusPainted(false);
        btnCasilla5.setOpaque(true);
        btnCasilla5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasilla5ActionPerformed(evt);
            }
        });

        btnCasilla6.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        btnCasilla6.setBorder(null);
        btnCasilla6.setBorderPainted(false);
        btnCasilla6.setDefaultCapable(false);
        btnCasilla6.setFocusPainted(false);
        btnCasilla6.setOpaque(true);
        btnCasilla6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasilla6ActionPerformed(evt);
            }
        });

        btnCasilla7.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        btnCasilla7.setBorder(null);
        btnCasilla7.setBorderPainted(false);
        btnCasilla7.setDefaultCapable(false);
        btnCasilla7.setFocusPainted(false);
        btnCasilla7.setOpaque(true);
        btnCasilla7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasilla7ActionPerformed(evt);
            }
        });

        btnCasilla8.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        btnCasilla8.setBorder(null);
        btnCasilla8.setBorderPainted(false);
        btnCasilla8.setDefaultCapable(false);
        btnCasilla8.setFocusPainted(false);
        btnCasilla8.setOpaque(true);
        btnCasilla8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasilla8ActionPerformed(evt);
            }
        });

        btnCasilla9.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        btnCasilla9.setBorder(null);
        btnCasilla9.setBorderPainted(false);
        btnCasilla9.setDefaultCapable(false);
        btnCasilla9.setFocusPainted(false);
        btnCasilla9.setOpaque(true);
        btnCasilla9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasilla9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCasilla1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasilla4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasilla7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCasilla2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnCasilla3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCasilla8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnCasilla9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCasilla5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnCasilla6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCasilla1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasilla3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasilla2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCasilla5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasilla6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasilla4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCasilla9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasilla8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasilla7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 230, 230));

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/itse/design/view/VistaTaTeTi.png.png"))); // NOI18N
        lblBackground.setAutoscrolls(true);
        lblBackground.setMaximumSize(new java.awt.Dimension(570, 464));
        lblBackground.setMinimumSize(new java.awt.Dimension(450, 319));
        lblBackground.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 680, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//Header
    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblSalirMouseClicked

    private void lblSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseEntered
        jPanel3.setBackground(Color.red);
        lblSalir.setForeground(Color.white);
    }//GEN-LAST:event_lblSalirMouseEntered

    private void lblSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseExited
        jPanel3.setBackground(Color.white);
        lblSalir.setForeground(Color.black);
    }//GEN-LAST:event_lblSalirMouseExited

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

//Botones    
    private void btnCasilla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasilla1ActionPerformed
        Marcar(2, 1);
        Computadora();
    }//GEN-LAST:event_btnCasilla1ActionPerformed

    private void btnCasilla2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasilla2ActionPerformed
        Marcar(2, 2);
        Computadora();
    }//GEN-LAST:event_btnCasilla2ActionPerformed

    private void btnCasilla3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasilla3ActionPerformed
        Marcar(2, 3);
        Computadora();
    }//GEN-LAST:event_btnCasilla3ActionPerformed

    private void btnCasilla4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasilla4ActionPerformed
        Marcar(2, 4);
        Computadora();
    }//GEN-LAST:event_btnCasilla4ActionPerformed

    private void btnCasilla5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasilla5ActionPerformed
        Marcar(2, 5);
        Computadora();
    }//GEN-LAST:event_btnCasilla5ActionPerformed

    private void btnCasilla6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasilla6ActionPerformed
        Marcar(2, 6);
        Computadora();
    }//GEN-LAST:event_btnCasilla6ActionPerformed

    private void btnCasilla7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasilla7ActionPerformed
        Marcar(2, 7);
        Computadora();
    }//GEN-LAST:event_btnCasilla7ActionPerformed

    private void btnCasilla8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasilla8ActionPerformed
        Marcar(2, 8);
        Computadora();
    }//GEN-LAST:event_btnCasilla8ActionPerformed

    private void btnCasilla9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasilla9ActionPerformed
        Marcar(2, 9);
        Computadora();
    }//GEN-LAST:event_btnCasilla9ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCasilla1;
    private javax.swing.JButton btnCasilla2;
    private javax.swing.JButton btnCasilla3;
    private javax.swing.JButton btnCasilla4;
    private javax.swing.JButton btnCasilla5;
    private javax.swing.JButton btnCasilla6;
    private javax.swing.JButton btnCasilla7;
    private javax.swing.JButton btnCasilla8;
    private javax.swing.JButton btnCasilla9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblSalir;
    // End of variables declaration//GEN-END:variables
}
