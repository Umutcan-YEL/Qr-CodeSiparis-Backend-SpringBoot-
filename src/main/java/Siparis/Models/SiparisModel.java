package Siparis.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Siparisler")
public class SiparisModel {

	@Id
	private String id;
	@NotNull
	@Min(value = 1)
	@Max(value = 30)
	@Field("MasaNo")
	private int masaNo;
	@JsonProperty("urun")
	private UrunModel[] urun;
	@NotNull
	@Field("Ekstralar")
	private String[] ekstralar;
	@NotNull
	@Size(min = 1, max = 40)
	@Field("Not")
	private String not;
	@Field("ToplamFiyat")
	@NotNull
	@Min(value = 1)
	private int toplamFiyat;
	@Field("SiparisAktifMi")
	@NotNull
	private boolean siparisAktifMi;

	public SiparisModel() {

	}

	public SiparisModel(int masaNo, UrunModel[] urun, String[] ekstralar, String not, int toplamFiyat,
			boolean siparisAktifMi) {
		this.masaNo = masaNo;
		this.urun = urun;
		this.ekstralar = ekstralar;
		this.not = not;
		this.toplamFiyat = toplamFiyat;
		this.siparisAktifMi = siparisAktifMi;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMasaNo() {
		return masaNo;
	}

	public void setMasaNo(int masaNo) {
		this.masaNo = masaNo;
	}

	public String[] getEkstralar() {
		return ekstralar;
	}

	public void setEkstralar(String[] ekstralar) {
		this.ekstralar = ekstralar;
	}

	public String getNot() {
		return not;
	}

	public void setNot(String not) {
		this.not = not;
	}

	public int getToplamFiyat() {
		return toplamFiyat;
	}

	public void setToplamFiyat(int toplamFiyat) {
		this.toplamFiyat = toplamFiyat;
	}

	public boolean isSiparisAktifMi() {
		return siparisAktifMi;
	}

	public void setSiparisAktifMi(boolean siparisAktifMi) {
		this.siparisAktifMi = siparisAktifMi;
	}

	public UrunModel[] getUrun(String string, int i, String[] strings) {
		return urun;
	}

	public void setUrun(UrunModel[] urun) {
		this.urun = urun;
	}

}
