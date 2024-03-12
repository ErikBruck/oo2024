package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToiduaineEntityController {
    List<String> toiduained = new ArrayList<>();
    // localhost:8080/api/toiduained ----> []
    @GetMapping("saa-toiduained")
    public List<String> saaToiduained() {
        return toiduained;
    }

    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<String> LisaToiduaine(
            @PathVariable String nimi,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
            ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik)
        toiduained.add(toiduaine.toString());
        return toiduained;
    }


    @PutMapping ("toiduained")
    public List<String> muudaToiduaine(
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik)
        toiduained.add(toiduaine.toString());
        return toiduained;
    }
    // localhost.8080/tere/korruta/1/3
    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2) {
        return arv1 * arv2;
    }

    @DeleteMapping("toiduained/{index}")
    public List<String> kustutaToiduaine(@PathVariable int index) {
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
