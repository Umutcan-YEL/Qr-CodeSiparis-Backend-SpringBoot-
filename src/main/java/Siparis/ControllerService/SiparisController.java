package Siparis.ControllerService;

import java.beans.JavaBean;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Siparis.Models.SiparisModel;
import Siparis.Models.UrunModel;
import Siparis.Repositroy.SiparisRepository;

@JavaBean
@CrossOrigin(origins = "http://localhost:8085/")
@RequestMapping
@RestController
public class SiparisController {

	@Autowired

	SiparisRepository siparisRepository;
	HttpStatus httpStatus;

	@GetMapping("/SiparisListele")
	public List<SiparisModel> Listele() {
		return siparisRepository.findAll();
	}

	@PostMapping("/SiparisEkle")
	public ResponseEntity<SiparisModel> SiparisKaydet(@RequestBody(required = true) @Valid SiparisModel siparisModel,
			UrunModel urunModel) {
		try {
			SiparisModel _sSchema = siparisRepository.save(new SiparisModel(siparisModel.getMasaNo(),
					siparisModel.getUrun(urunModel.getUrun(), urunModel.getFiyat(), urunModel.getIcindekiler()),
					siparisModel.getEkstralar(), siparisModel.getNot(), siparisModel.getToplamFiyat(),
					siparisModel.isSiparisAktifMi()));
			return new ResponseEntity<>(_sSchema, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/SiparisSil")
	public String silme(@RequestBody(required = true) SiparisModel siparisSchema) {
		siparisRepository.deleteById(siparisSchema.getId());
		return "Başarı ile silindi";
	}

	@PutMapping("/SiparisDüzenle")
	public ResponseEntity<SiparisModel> düzenleme(@RequestBody(required = true) SiparisModel siparisModel,
			UrunModel urunModel) {
		siparisRepository.findById(siparisModel.getId());
		siparisModel.setMasaNo(siparisModel.getMasaNo());
		siparisModel
				.setUrun(siparisModel.getUrun(urunModel.getUrun(), urunModel.getFiyat(), urunModel.getIcindekiler()));
		siparisModel.setEkstralar(siparisModel.getEkstralar());
		siparisModel.setNot(siparisModel.getNot());
		siparisModel.setSiparisAktifMi(siparisModel.isSiparisAktifMi());
		final SiparisModel düzenlenmisSiparis = siparisRepository.save(siparisModel);
		return ResponseEntity.ok(düzenlenmisSiparis);

	}
}