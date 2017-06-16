package com.weixin.ticket.service;

import org.springframework.stereotype.Service;

import com.common.WeiXinContext;
import com.common.utils.HttpClientUtils;
import com.weixin.ticket.domain.Ticket;

@Service
public class TicketService {
    
    public Ticket ticket(){
        String url = WeiXinContext.WX_TICKET_URL;
        url = url.replaceAll("ACCESS_TOKEN", WeiXinContext.getAccessToken().getAccess_token());
        return HttpClientUtils.sendHttpGet(url,Ticket.class);
    }

}
