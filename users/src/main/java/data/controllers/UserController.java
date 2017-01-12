package data.controllers;

import java.util.concurrent.atomic.AtomicLong;
import data.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/users")
public class UserController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public @ResponseBody ResponseMessage create (
      @RequestParam(value="id", required=true) String id,
      @RequestParam(value="firstName", required=true) String firstName,
      @RequestParam(value="lastName", required=true) String lastName,
      @RequestParam(value="emailAddress", required=true) String emailAddress
    ) {
        final String template = "%s [%s] %s %s (%s)";
        return new ResponseMessage(counter.incrementAndGet(), String.format(template, "Created ", id, firstName, lastName, emailAddress));
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public @ResponseBody ResponseMessage read (
      @RequestParam(value="id", required=false) String id
    ) {
        final String template = "%s [%s] %s %s (%s)";
        return new ResponseMessage(counter.incrementAndGet(), String.format(template, id));
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public @ResponseBody ResponseMessage update (
      @RequestParam(value="id", required=true) String id,
      @RequestParam(value="firstName", required=true) String firstName,
      @RequestParam(value="lastName", required=true) String lastName,
      @RequestParam(value="emailAddress", required=true) String emailAddress
    ) {
        final String template = "%s [%s] %s %s (%s)";
        return new ResponseMessage(counter.incrementAndGet(), String.format(template, "Updated ", id, firstName, lastName, emailAddress));
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public @ResponseBody ResponseMessage delete (
      @RequestParam(value="id", required=true) String id
    ) {
        final String template = "%s [%s]";
        return new ResponseMessage(counter.incrementAndGet(), String.format(template, "Deleted ", id));
    }
}
