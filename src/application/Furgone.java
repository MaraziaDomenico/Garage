package application;

import java.util.Calendar;
import java.util.Date;

public class Furgone {
	
	private String targa;
	private int nposto;
	private Date dateOne;
	private int DataUno;
	
	@SuppressWarnings("deprecation")
	public Furgone(String targa, int nposto) {
		this.targa= targa;
		this.nposto=nposto;
		
		@SuppressWarnings("unused")
		Date date;
	    Calendar calendar;
	    
		calendar = Calendar.getInstance();
	    date = calendar.getTime();
	    dateOne = calendar.getTime();
	    DataUno = dateOne.getSeconds();
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	public int getNposto() {
		return nposto;
	}
	public void setNposto(int nposto) {
		this.nposto = nposto;
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
