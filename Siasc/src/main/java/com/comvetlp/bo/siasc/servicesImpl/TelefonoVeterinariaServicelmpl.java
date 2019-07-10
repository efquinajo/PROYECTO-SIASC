package com.comvetlp.bo.siasc.servicesImpl;

import com.comvetlp.bo.siasc.repositories.TelefonoVeterinariaRepository;
import com.comvetlp.bo.siasc.services.TelefonoVeterinariaService;
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
public class TelefonoVeterinariaServicelmpl extends GenericServiceImpl<TelefonoVeterinariaRepository> implements TelefonoVeterinariaService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private TelefonoVeterinariaRepository telefonoVeterinariaRepository;

    @Override
    public TelefonoVeterinariaRepository getRepository() {
        return telefonoVeterinariaRepository;
    }

}
