package com.comvetlp.bo.siasc.servicesImpl;

import com.comvetlp.bo.siasc.repositories.EstudioRepository;
import com.comvetlp.bo.siasc.services.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */

@Service
@Transactional(readOnly = true)
public class EstudioServicelmpl extends GenericServiceImpl<EstudioRepository> implements EstudioService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EstudioRepository estudioRepository;

    @Override
    public EstudioRepository getRepository() {
        return estudioRepository;
    }

}
