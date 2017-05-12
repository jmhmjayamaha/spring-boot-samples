package lk.harshana.controller;

import lk.harshana.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by cmdhmjayamaha on 5/12/17.
 */
@Controller
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="greeting", method = RequestMethod.GET)
    public @ResponseBody Greeting getGreeting(@RequestParam(value="name" , defaultValue = "harshana", required = false) String name) {
        return new Greeting((int) counter.incrementAndGet(),"hello" + name);
    }

}
