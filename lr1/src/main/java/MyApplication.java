import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MyApplication {

    private ArrayList<String> randomString = new ArrayList<String>();
    private Integer globalCounter = 0;

    private HashMap<Integer, String> randomHashMap = new HashMap<Integer, String>();

    @RequestMapping("/update-array")
    ResponseEntity<ArrayList<String>> updateArrayList(@RequestParam(required = true, name = "random_string") String s) {
        this.randomString.add(s);
        return ResponseEntity.status(201).body(this.randomString);
    }

    @RequestMapping("/show-array")
    ResponseEntity<ArrayList<String>> showArrayList() {
        return ResponseEntity.status(200).body(this.randomString);
    }

    @RequestMapping("/update-map")
    ResponseEntity<HashMap<Integer, String>> updateHashMap(
            @RequestParam(required = true, name = "random_string") String s) {
        this.randomHashMap.put(globalCounter, s);
        globalCounter++;
        return ResponseEntity.status(201).body(this.randomHashMap);
    }

    @RequestMapping("/show-map")
    ResponseEntity<HashMap<Integer, String>> showHashMap() {
        return ResponseEntity.status(200).body(this.randomHashMap);
    }

    @RequestMapping("/show-all-lenght")
    ResponseEntity<HashMap<String, Integer>> showAllLenght() {
        HashMap<String, Integer> responseData = new HashMap<String, Integer>();
        responseData.put("listCount", randomString.size());
        responseData.put("hashMapCount", randomHashMap.size());
        return ResponseEntity.status(200).body(responseData);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}