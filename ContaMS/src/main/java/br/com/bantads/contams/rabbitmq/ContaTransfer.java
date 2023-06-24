package br.com.bantads.contams.rabbitmq;


import java.io.Serializable;

import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.model.ContaR;
import br.com.bantads.contams.model.ContaR;

public class ContaTransfer implements Serializable {
    ContaRDTO contaDto;
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

    public ContaRDTO getContaDto() {
        return this.contaDto;
    }

    public void setContaDto(ContaRDTO contaDto) {
        this.contaDto = contaDto;
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