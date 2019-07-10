package com.comvetlp.bo.siasc.bean;

import com.comvetlp.bo.siasc.model.Colegiado;
import com.comvetlp.bo.siasc.repositories.ColegiadoRepository;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * MC4
 * La Paz - Bolivia
 * EDV - JBPM
 * 10/06/2018 - 3:44 PM
 * Created by: equinajo
 */

@Component
@Scope("view")
@Getter
@Setter
public class IntegrantesBean{

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrantesBean.class);

    //Constructor del Bean
    @PostConstruct
    public void init(){
        System.out.println("iniciando init bean");
        cargar();
    }

    // Metodo para listar la recepcion de correspondencia externa
    public void cargar() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
