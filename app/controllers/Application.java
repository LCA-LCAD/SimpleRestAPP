package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Person;
import play.*;
import play.api.libs.json.JsPath;
import play.api.libs.json.Json;
import play.api.mvc.AnyContentAsJson;
import play.data.Form;
import play.mvc.*;
import play.mvc.Result;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result listPersons(){
        String json = String.valueOf(play.libs.Json.toJson(Person.finder.all()));
        return ok(json);
    }

    public static Result addPerson() {
        JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String name = json.findPath("name").asText();
            Integer age = json.findPath("age").asInt();
            if(name == null) {
                return badRequest("Missing parameter [name]");
            } else {
                Person person = new Person(name,age);
                person.save();
                return ok();
            }
        }
    }

}
