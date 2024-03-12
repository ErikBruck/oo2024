package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ToiduaineController {
    List<String> toiduained = new ArrayList<>();

    // localhost:8080/saa-toiduained ----> []
    @GetMapping("saa-toiduained")
    public List<String> saaToiduained() {
        return toiduained;
    }

    @PostMapping("toiduained/{toiduaine}")
    public List<String> LisaToiduaine(@PathVariable String toiduaine) {
        toiduained.add(toiduaine);
        return toiduained;
    }

    // localhost.8080/tere
    @GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi) {
        return "Tere" + nimi;
    }

    // localhost.8080/tere/korruta/1/3
    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2) {
        return arv1 * arv2;
    }

    @DeleteMapping("toiduained/{index}/{newValue}")
    public List<String> kustutaToiduaine(@PathVariable int index,
                                         PathVariable String newValue) {
        toiduained.set(index, newValue);
        return toiduained;
    }

    @PutMapping("toiduained/{index}/{newValue}")
    public List<String> muudaToiduaine(@PathVariable int index, PathVariable String newValue) {
        toiduained.remove(index);
        return toiduained;
    }
    @GetMapping("toiduained/{index}")
    public String saaYksToiduaine(@PathVariable int index){
        return toiduained.get(index);
    }
}
// 404 - URL ehk api otspunkt on vale
// kõik 4xx - front endi viga
// kõik 5xx - back endi viga
