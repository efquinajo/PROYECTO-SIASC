package com.comvetlp.bo.siasc.services;
import com.comvetlp.bo.siasc.repositories.PagoRepository;
import java.util.Date;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */


public interface PagoService {

    PagoRepository getRepository();

    /**
     * Retorna el total de cuotas
     *
     * @param idColegiado
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    Double getCuotasByIdColegiadoByFecha(Long idColegiado, Date fechaIni, Date fechaFin);

    /**
     * Retorna la vigencia del ultimo pago
     *
     * @param idColegiado
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    Date getUltimaVigenciaByIdColegiadoByFecha(Long idColegiado, Date fechaIni, Date fechaFin);

}
