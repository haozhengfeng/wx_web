package com.back.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.back.token.domain.AccessToken;
import com.back.token.service.TokenService;
import com.common.WeiXinContext;
import com.common.utils.LoggerUtils;
import com.weixin.ticket.domain.Ticket;
import com.weixin.ticket.service.TicketService;
/**
 * 更新access_token ticket等
 * @author haozhengfeng
 *
 */
@Service
public class RefreshService {

	@Autowired
	TokenService tokenService;
	
	@Autowired
	TicketService ticketService;
	
	@Scheduled(fixedRate = 1000 * 7000)
    public void refreshAll(){
		AccessToken token = tokenService.token();
		WeiXinContext.setAccessToken(token);
		Ticket ticket = ticketService.ticket();
    	WeiXinContext.setJsapi_ticket(ticket);
    	
    	LoggerUtils.debug(RefreshService.class, "refresh_access_token:"+token.getAccess_token());
    	LoggerUtils.debug(RefreshService.class, "refresh_ticket:"+ticket.getTicket());
    }
	
}
