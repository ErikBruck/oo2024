package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MatkajaController {

    @Autowired
    MatkajaRepository matkajaRepository;

    @GetMapping("matkajad")
    public List<Matkaja> getMatkajad() {
        return matkajaRepository.findAll();
    }
    @PostMapping("matkajad")
    public List<Matkaja> postMatkaja(@RequestBody Matkaja matkaja) {
        matkajaRepository.save(matkaja);
        return matkajaRepository.findAll();
    }
    @DeleteMapping("matkajad/{id}")
    public List<Matkaja> deleteMatkaja(@PathVariable Long id) {
        matkajaRepository.deleteById(id);
        return matkajaRepository.findAll();
    }
}
