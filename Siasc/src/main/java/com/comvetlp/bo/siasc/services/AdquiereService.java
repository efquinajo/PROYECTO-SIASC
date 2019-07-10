package com.comvetlp.bo.siasc.services;
import com.comvetlp.bo.siasc.repositories.AdquiereRepository;
import java.util.Date;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */


public interface AdquiereService {

    AdquiereRepository getRepository();

    /**
     * Recupera el total de certificados adquiridos
     *
     * @param idColegiado
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    Double getCertificadosByIdColegiadoByFecha(
            Long idColegiado
            , Date fechaIni
            , Date fechaFin);

}
