package com.comvetlp.bo.siasc.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * MC4
 * La Paz - Bolivia
 * EDV - JBPM
 * 19/06/2017 - 3:44 PM
 * Created by: yrevollo
 */
//@ManagedBean
//@SessionScoped
public class SysMessage implements Serializable {

    private static final long serialVersionUID = -991119312959037129L;

    public static void error(String title, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg));
    }

    public static void error(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", msg));

    }

    public static void error(String componentId, String title, String msg) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg));
    }

    public static void info(String componentId, String msg) {
        FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));

    }

    public static void info(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", msg));
    }

    public static void warn(String title, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title, msg));

    }

    public static void warn(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", msg));

    }

    public static void fatal(String title, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, title, msg));

    }

    public static void fatal(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "FATAL", msg));

    }

    public static void addMessage(FacesMessage facesMessage) {
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);

    }
}
