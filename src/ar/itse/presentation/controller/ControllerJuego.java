/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.itse.presentation.controller;

import ar.itse.presentation.view.ViewJuego;

/**
 *
 * @author PC
 */
public class ControllerJuego {

    static ViewJuego view = new ViewJuego();

    static public void presentar() {
        view.setVisible(true);
    }

    static public void ocultar() {
        view.setVisible(false);
    }

    static public void evnSalir() {

        System.out.println("Final.");
        ocultar();
        System.exit(0);
    }
}
