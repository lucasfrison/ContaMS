package br.com.bantads.contams.rabbitmq;


import java.io.Serializable;

import br.com.bantads.contams.dto.ContaCudDTO;
import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.model.ContaCud;
import br.com.bantads.contams.model.ContaR;

public class ContaTransfer implements Serializable {
    ContaCudDTO contaDto;
    ContaCud contaCud;
    String action;
    String message;

    public ContaTransfer() {
    }

    public ContaTransfer(ContaCud contaDto, String action) {
        this.contaCud = contaDto;
        this.action = action;
    }
    
    public ContaTransfer(ContaCud contaDto, String action, String message) {
        this.contaCud = contaDto;
        this.action = action;
        this.message = message;
    }

    public ContaCudDTO getContaDto() {
        return this.contaDto;
    }

    public void setContaDto(ContaCudDTO contaDto) {
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
    
    public ContaCud getContaCud() {
		return contaCud;
	}
    
    public void setContaCud(ContaCud contaCud) {
		this.contaCud = contaCud;
	}
}