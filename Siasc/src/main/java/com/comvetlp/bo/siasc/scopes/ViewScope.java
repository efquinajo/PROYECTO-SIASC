package com.comvetlp.bo.siasc.scopes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * MC4
 * La Paz - Bolivia
 * EDV - JBPM
 * 19/06/2017 - 3:44 PM
 * Created by: aticona
 *
 * Clase que implementa el ViewScope para no tener conflictos con los beans de jsf
 */
public class ViewScope implements Scope {

    @Override
    @SuppressWarnings("rawtypes")
    public Object get(String name, ObjectFactory objectFactory) {
        if (FacesContext.getCurrentInstance().getViewRoot() != null) {
            Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

            if (viewMap.containsKey(name)) {
                Object bean = viewMap.get(name);
                // restore a transient autowired beans after re-serialization bean
                WebApplicationContext webAppContext = ContextLoader.getCurrentWebApplicationContext();
                AutowireCapableBeanFactory autowireFactory = webAppContext.getAutowireCapableBeanFactory();
                if (webAppContext.containsBean(name)) {
                    // Reconfigure restored bean instance.
                    autowireFactory.autowireBean(bean);
                }
                // end restore
                return bean;
            } else {
                Object object = objectFactory.getObject();
                viewMap.put(name, object);
                return object;
            }
        } else {
            return null;
        }
    }

    @Override
    public Object remove(String name) {

        return FacesContext.getCurrentInstance().getViewRoot().getViewMap()
                .remove(name);
    }

    public String getConversationId() {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }

    public Object resolveContextualObject(String key) {
        return null;
    }

    public void clearBean() {
        FacesContext.getCurrentInstance()
                .getViewRoot().getViewMap().clear();
    }
}