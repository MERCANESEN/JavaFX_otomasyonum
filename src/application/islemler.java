package application;

import java.sql.Date;




public class islemler {
	
	islemler(){
	}
	
	islemler(String eposta, String islemAciklama,double islemTutar, Date islemTarih){
		this.eposta = eposta;
		this.islemAciklama=islemAciklama;
		this.islemTutar=islemTutar;
		this.islemTarih=islemTarih;
		
		
	}
	
	private String eposta;
	private String islemAciklama;
	private double islemTutar;
	private Date islemTarih;
	


	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	

	public String getIslemAciklama() {
		return islemAciklama;
	}
	public void setIslemAciklama(String islemAciklama) {
		this.islemAciklama = islemAciklama;
	}
	public double getIslemTutar() {
		return islemTutar;
	}
	public void setIslemTutar(double islemTutar) {
		this.islemTutar = islemTutar;
	}
	public Date getIslemTarih() {
		return islemTarih;
	}
	public void setIslemTarih(Date islemTarih) {
		this.islemTarih = islemTarih;
	}

}
