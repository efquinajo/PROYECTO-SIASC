package com.comvetlp.bo.siasc.servicesImpl;

import com.comvetlp.bo.siasc.model.Colegiado;
import com.comvetlp.bo.siasc.repositories.ColegiadoRepository;
import com.comvetlp.bo.siasc.services.ColegiadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */

@Service
@Transactional(readOnly = true)
public class ColegiadoServicelmpl extends GenericServiceImpl<ColegiadoRepository> implements ColegiadoService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ColegiadoRepository colegiadoRepository;

    @Override
    public ColegiadoRepository getRepository() {
        return colegiadoRepository;
    }

    @Override
    public List<Colegiado> listColegiadoAll() {
        return null;
    }

}
