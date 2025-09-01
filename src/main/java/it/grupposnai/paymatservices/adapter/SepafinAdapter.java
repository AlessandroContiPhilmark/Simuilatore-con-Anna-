package it.grupposnai.paymatservices.adapter;

import it.grupposnai.paymatcore.api.request.callback.sepafin.OtpFlowNotifyRequestCore;
import it.grupposnai.paymatservices.services.dto.OtpFlowNotifyRequest;

public class SepafinAdapter {
    public static OtpFlowNotifyRequestCore convert(OtpFlowNotifyRequest request){
        OtpFlowNotifyRequestCore result = new OtpFlowNotifyRequestCore();

        result.setConfirmed(request.getConfirmed());
        result.setCallBackUrl(request.getCallBackUrl());
        result.setAuthorizationCode(request.getAuthorizationCode());
        result.setOtpCode(request.getOtpCode());
        result.setUserName(request.getUserName());
        result.setPhoneNumber(request.getPhoneNumber());
        result.setAppId(request.getAppId());
        result.setTimestamp(request.getTimestamp());
        result.setState(request.getState());
        result.setAuthenticationId(request.getAuthenticationId());
        result.setLat(request.getLat());
        result.setLng(request.getLng());
        result.setMessage(request.getMessage());
        
        return result;
    }
    
}
