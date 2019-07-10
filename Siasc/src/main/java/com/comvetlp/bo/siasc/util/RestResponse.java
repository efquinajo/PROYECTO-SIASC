package com.comvetlp.bo.siasc.util;

import lombok.Getter;
import lombok.Setter;

/**
 * La Paz - Bolivia
 * COMVET-LP
 * 16/02/2019 - 9:30 AM
 * Created by: Edson Felix Quiñajo Quiñajo
 */

@Getter
@Setter
public class RestResponse {

    private Integer responseCode;
    private String message;

    public RestResponse(Integer responseCode) {
        super();
        this.responseCode = responseCode;
    }

    public RestResponse(Integer responseCode, String message) {
        super();
        this.responseCode = responseCode;
        this.message = message;
    }
}
