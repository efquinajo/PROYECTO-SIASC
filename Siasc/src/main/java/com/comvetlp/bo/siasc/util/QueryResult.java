package com.comvetlp.bo.siasc.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */

@Getter
@Setter
public class QueryResult {

    private int totalRecords;
    private List<Object> list;

}
