package com.shava.faces.stateless.boundary;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.net.InetAddress;

@Named
@ViewScoped
public class PortalUsuario implements Serializable {

    private String userName;

    private  String message;

    private String ip;

    @PostConstruct
    public void init(){
        try {
            InetAddress thisIp = InetAddress.getLocalHost();
            System.out.println("My IP is  " + thisIp.getLocalHost().getHostAddress());
            setIp(thisIp.getLocalHost().getHostAddress());
        } catch (Exception e) {
            System.out.println("exception in up addresss");
            setIp("Error obteniendo ip");
        }
    }

    public String procesar(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,userName,message));
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
