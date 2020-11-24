/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesys.mpharma.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Faces;

/**
 *
 * @author ErnestDuker
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    /**
     * Creates a new instance of LoginController
     */
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String userPassword;
    public LoginController() {
    }
    
    public void doLogin()
    {
        Faces.redirect("app/dashboard.xhtml");
    }
    
}
