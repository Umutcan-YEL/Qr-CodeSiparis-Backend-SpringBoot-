package Siparis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Siparis.Models.SiparisModel;
import Siparis.Models.UrunModel;
import Siparis.Repositroy.SiparisRepository;

@SpringBootTest
class SpringSiparisBackEndApplicationTests {

	@Autowired
	private SiparisRepository siparisRepository;

	@Test
	void SiparisTest() {
//		Saving
		SiparisModel siparisModel = new SiparisModel();
		UrunModel urunModel = new UrunModel();
		siparisModel.setMasaNo(15);
		String[] icindekiler = { "Seftali", "Kiraz" };
		int fiyat = 15;
		String urunAd = "Bagel";
		urunModel.setUrun(urunAd);
		urunModel.setFiyat(fiyat);
		urunModel.setIcindekiler(icindekiler);
		String[] Ekstralar = { "Mayonez" };
		UrunModel[] urun = new UrunModel[1];
		urun[0] = new UrunModel(urunAd, fiyat, icindekiler);
		siparisModel.setUrun(urun);
		siparisModel.setEkstralar(Ekstralar);
		siparisModel.setNot("Cilek");
		siparisModel.setToplamFiyat(250);
		siparisModel.setSiparisAktifMi(true);
		siparisRepository.save(siparisModel);
//		Terminal
		System.out.println("\nSiparis : \n" + "id: " + siparisModel.getId() + "\nMasa No : " + siparisModel.getMasaNo()
				+ "\nUrun Adi:" + urunAd + "\nFiyat:" + fiyat + "\nIcerik:" + icindekiler[0] + " ve " + icindekiler[1]
				+ "\nEkstra: " + Ekstralar[0] + "\nNot: " + siparisModel.getNot() + "\nToplam Fiyat: "
				+ siparisModel.getToplamFiyat() + "\nSiparis Durumu:" + siparisModel.isSiparisAktifMi());
//		Updating 
		siparisRepository.findById(siparisModel.getId());
		siparisModel.setMasaNo(40);
		String[] updateİcindekiler = { "Update Seftali", "Update Kiraz" };
		int updatefiyat = 30;
		String updateUrunAd = "Update Bagel";
		urunModel.setUrun(updateUrunAd);
		urunModel.setFiyat(updatefiyat);
		urunModel.setIcindekiler(updateİcindekiler);
		String[] updateEkstralar = { "Update Mayonez" };
		UrunModel[] updateUrun = new UrunModel[1];
		urun[0] = new UrunModel(updateUrunAd, updatefiyat, updateİcindekiler);
		siparisModel.setUrun(updateUrun);
		siparisModel.setEkstralar(updateEkstralar);
		siparisModel.setNot("Update Cilek");
		siparisModel.setToplamFiyat(500);
		siparisModel.setSiparisAktifMi(false);
		siparisRepository.save(siparisModel);
//		Updated Terminal
		System.out.println("\nUpdate Siparis : \n" + "id: " + siparisModel.getId() + "\nMasa No : "
				+ siparisModel.getMasaNo() + "\nUrun Adi:" + updateUrunAd + "\nFiyat:" + updatefiyat + "\nIcerik:"
				+ updateİcindekiler[0] + " ve " + updateİcindekiler[1] + "\nEkstra: " + updateEkstralar[0] + "\nNot: "
				+ siparisModel.getNot() + "\nToplam Fiyat: " + siparisModel.getToplamFiyat() + "\nSiparis Durumu:"
				+ siparisModel.isSiparisAktifMi());
//		Deleting
		siparisRepository.deleteById(siparisModel.getId());
	}
}
