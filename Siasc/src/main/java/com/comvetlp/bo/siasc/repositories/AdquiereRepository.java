package com.comvetlp.bo.siasc.repositories;

import com.comvetlp.bo.siasc.model.Adquiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */

public interface AdquiereRepository extends JpaRepository<Adquiere, Long> {

    @Query(" SELECT b" +
            " FROM Adquiere b" +
            " WHERE b.estado  = com.comvetlp.bo.siasc.enums.Estado.H" +
            " AND b.idColegiado.idColegiado  = :idColegiado" +
            " AND b.fechaAlta  between :fechaIni AND :fechaFin" +
            " ORDER BY b.idColegiado.idColegiado ASC")
    List<Adquiere> listCertificadosByIdColegiadoByFecha(
            @Param("idColegiado") Long idColegiado
            , @Param("fechaIni") Date fechaIni
            , @Param("fechaFin") Date fechaFin);
}
