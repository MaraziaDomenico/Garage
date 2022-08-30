package application;

import java.util.Calendar;
import java.util.Date;


public class Bici {
	
	private String nome;
	private int nposto;
	private int DataUno;
	private Date dateOne;
	
	@SuppressWarnings("deprecation")
	public Bici(String nome,int nposto){
		this.nome = nome;
		this.nposto = nposto;
		
		@SuppressWarnings("unused")
      	Date date;
        Calendar calendar;
		 
        calendar = Calendar.getInstance();
        date = calendar.getTime();
		dateOne = calendar.getTime();
		setDataUno(dateOne.getSeconds());
	}
	
	public int getNposto() {
		return nposto;
	}
	
	public void setNposto(int nposto) {
		this.nposto = nposto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDataUno() {
		return DataUno;
	}

	public void setDataUno(int dataUno) {
		DataUno = dataUno;
	}
	
	public Date getDateOne() {
		return dateOne;
	}
	public void setDateOne(Date dateOne) {
		this.dateOne = dateOne;
	}

}
