package data.controllers;

import java.util.concurrent.atomic.AtomicLong;
import data.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FindUserController {

    private static final String template = "Users ";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/users/find", method=RequestMethod.GET)
    public @ResponseBody ResponseMessage find (
      @RequestParam(value="firstName", required=false) String firstName,
      @RequestParam(value="lastName", required=false) String lastName,
      @RequestParam(value="emailAddress", required=false) String emailAddress
    ) {
        return new ResponseMessage(counter.incrementAndGet(), String.format(template, firstName));
    }

}
