package br.com.bantads.contams.rabbitmq;


import java.io.Serializable;

import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.model.ContaR;
import br.com.bantads.contams.model.ContaR;

public class ContaTransfer implements Serializable {
    ContaR contaR;
    String action;
    String message;

    public ContaTransfer() {
    }

    public ContaTransfer(ContaR contaDto, String action) {
        this.contaR = contaDto;
        this.action = action;
    }
    
    public ContaTransfer(ContaR contaDto, String action, String message) {
        this.contaR = contaDto;
        this.action = action;
        this.message = message;
    }

    public ContaR getContaDto() {
        return this.contaR;
    }

    public void setContaDto(ContaR contaDto) {
        this.contaR = contaDto;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public ContaR getContaR() {
		return contaR;
	}
    
    public void setContaR(ContaR ContaR) {
		this.contaR = ContaR;
	}
}