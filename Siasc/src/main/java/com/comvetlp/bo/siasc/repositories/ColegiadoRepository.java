package com.comvetlp.bo.siasc.repositories;

import com.comvetlp.bo.siasc.enums.Estado;
import com.comvetlp.bo.siasc.model.Colegiado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */

public interface ColegiadoRepository extends JpaRepository<Colegiado, Long> {

    @Query(" SELECT b" +
            " FROM Colegiado b" +
            " WHERE b.estado  = com.comvetlp.bo.siasc.enums.Estado.H"+
            " AND b.idColegiado  = :idColegiado"+
            " ORDER BY b.paterno ASC")
    Colegiado findColegiadoByIdColegiado(
            @Param("idColegiado") Long idColegiado);

    @Query(" SELECT b" +
            " FROM Colegiado b" +
            " WHERE b.estado  = :estado"+
            " ORDER BY b.paterno ASC")
    List<Colegiado> listColegiadoByEstado(
            @Param("estado") Estado estado);

}
