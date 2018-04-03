package br.com.algartelecom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="champion_cliente")
@Table
public class Champion implements Serializable {
	
	@GeneratedValue
	@Id
	@Column(name="idchampion")
	private int id;
	
	private String nome;
	
	private String lane;
	
	public Champion() {}

	public Champion(String nome, String lane) {
		super();
		this.nome = nome;
		this.lane = lane;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Champion [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", lane=");
		builder.append(lane);
		builder.append("]");
		return builder.toString();
	};
	
	
	
	
}