package com.comvetlp.bo.siasc.servicesImpl;


import com.comvetlp.bo.siasc.model.Pago;
import com.comvetlp.bo.siasc.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.comvetlp.bo.siasc.repositories.PagoRepository;
import com.comvetlp.bo.siasc.services.PagoService;


import java.util.Date;
import java.util.List;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */

@Service
@Transactional(readOnly = true)
public class PagoServicelmpl extends GenericServiceImpl<PagoRepository> implements PagoService {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public PagoRepository getRepository() {
        return pagoRepository;
    }

    @Override
    public Double getCuotasByIdColegiadoByFecha(Long idColegiado, Date fechaIni, Date fechaFin) {

        Double totalPago = new Double(0);

        if (fechaIni != null || fechaFin != null) {
            return totalPago;
        }
        if (fechaIni.after(fechaFin)) {
            return totalPago;
        }

        fechaIni = DateUtil.cambiarPrimeraHora(fechaIni);
        fechaFin = DateUtil.cambiarUltimaHora(fechaFin);

        List<Pago> listPago = pagoRepository.listCuotasByIdColegiadoByFecha(idColegiado, fechaIni, fechaFin);

        //Sumando pagos
        for (Pago pago : listPago) {
            totalPago = totalPago + pago.getIdColegiatura().getCuota();
        }

        return totalPago;
    }

    @Override
    public Date getUltimaVigenciaByIdColegiadoByFecha(Long idColegiado, Date fechaIni, Date fechaFin) {

        Date ultimaVigencia=null;

        if (fechaIni != null || fechaFin != null) {
            return ultimaVigencia;
        }
        if (fechaIni.after(fechaFin)) {
            return ultimaVigencia;
        }

        fechaIni = DateUtil.cambiarPrimeraHora(fechaIni);
        fechaFin = DateUtil.cambiarUltimaHora(fechaFin);

        List<Pago> listPago = pagoRepository.listCuotasByIdColegiadoByFecha(idColegiado, fechaIni, fechaFin);

        Date primeraVigencia = DateUtil.fechaMinima();

        //Obteniendo maxima fecha
        for (Pago pago : listPago) {
            ultimaVigencia=pago.getVigencia();
            if(ultimaVigencia.after(primeraVigencia)){
                primeraVigencia=ultimaVigencia;
            }
        }

        return ultimaVigencia;
    }

}
