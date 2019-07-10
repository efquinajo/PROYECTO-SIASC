package com.comvetlp.bo.siasc.servicesImpl;

import com.comvetlp.bo.siasc.services.GenericService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */
public abstract class GenericServiceImpl<T extends JpaRepository> implements GenericService {

    protected final Log LOGGER = LogFactory.getLog(getClass());

    public abstract T getRepository();


}