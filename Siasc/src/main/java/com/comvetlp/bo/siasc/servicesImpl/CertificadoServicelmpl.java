package com.comvetlp.bo.siasc.servicesImpl;

import com.comvetlp.bo.siasc.repositories.CertificadoRepository;
import com.comvetlp.bo.siasc.services.CertificadoService;
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
public class CertificadoServicelmpl extends GenericServiceImpl<CertificadoRepository> implements CertificadoService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CertificadoRepository certificadoRepository;

    @Override
    public CertificadoRepository getRepository() {
        return certificadoRepository;
    }

}
