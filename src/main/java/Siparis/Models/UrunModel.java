package Siparis.Models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UrunModel {

	@NotNull
	@Size(min = 5, max = 15)
	private String urun;
	@NotNull
	private int fiyat;
	@NotNull
	private String[] icindekiler;

	public UrunModel() {
	    }

	public UrunModel(String urun, int fiyat, String[] icindekiler) {
	        this.urun = urun;
	        this.fiyat = fiyat;
	        this.icindekiler = icindekiler;
	    }

	public String getUrun() {
		return urun;
	}

	public void setUrun(String urun) {
		this.urun = urun;
	}

	public int getFiyat() {
		return fiyat;
	}

	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	public String[] getIcindekiler() {
		return icindekiler;
	}

	public void setIcindekiler(String[] icindekiler) {
		this.icindekiler = icindekiler;
	}
}
