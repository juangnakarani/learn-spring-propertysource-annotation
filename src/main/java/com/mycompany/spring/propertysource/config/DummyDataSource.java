/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.propertysource.config;

/**
 *
 * @author juang
 */
public class DummyDataSource {
    private String userName;
    private String password;

    public DummyDataSource(String userName, String password) {
        this.userName = userName;
        this.password = password;
        System.out.println("dummy data source berhasil dibuat...");
        System.out.println("user name: " + userName);
        System.out.println("password :" + password);
    }
    
}
