package br.com.bantads.contams.rabbitmq;


import java.io.Serializable;

import br.com.bantads.contams.dto.ContaCudDTO;
import br.com.bantads.contams.dto.ContaCudDTO;

public class ContaTransfer implements Serializable {
    ContaCudDTO contaR;
    String action;
    String message;

    public ContaTransfer() {
    }

    public ContaTransfer(ContaCudDTO contaDto, String action) {
        this.contaR = contaDto;
        this.action = action;
    }
    
    public ContaTransfer(ContaCudDTO contaDto, String action, String message) {
        this.contaR = contaDto;
        this.action = action;
        this.message = message;
    }

    public ContaCudDTO getContaDto() {
        return this.contaR;
    }

    public void setContaDto(ContaCudDTO contaDto) {
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
    
    public ContaCudDTO getContaR() {
		return contaR;
	}
    
    public void setContaR(ContaCudDTO ContaR) {
		this.contaR = ContaR;
	}
}