package com.comvetlp.bo.siasc.services;
import com.comvetlp.bo.siasc.model.Colegiado;
import com.comvetlp.bo.siasc.repositories.ColegiadoRepository;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */


import java.util.List;

public interface ColegiadoService {

    ColegiadoRepository getRepository();

    /**
     * Metodo que retorna el listado de todos los colegiados
     *
     * @return
     */
    List<Colegiado> listColegiadoAll();
}
