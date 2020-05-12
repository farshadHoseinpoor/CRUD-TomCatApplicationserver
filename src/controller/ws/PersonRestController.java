package controller.ws;

import common.ExceptionWrapper;
import model.entity.Person;
import model.service.PersonService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Path("/person")
public class PersonRestController {


    @GET
    @Produces("application/json")
    @Path("/save")
    public Object save(@QueryParam("name") String name){
        try{
            Person person=new Person(name);
            PersonService.getInstance().save(person);
            return person;
        }catch (Exception e){
          return ExceptionWrapper.getError(e);
        }
    }
    @GET
    @Produces("application/json")
    @Path("/delete")
    public Object delete(@QueryParam("id") long id){
        try {
            Person person=new Person().setId(id);
            PersonService.getInstance().delete(person);
            return PersonService.getInstance().findAll();
        }catch (Exception e){
            return ExceptionWrapper.getError(e);
        }
    }
    @GET
    @Produces("application/json")
    @Path("/update")
    public Object update(@QueryParam("id") String id,@QueryParam("name") String name){
        try {
            Person person=new Person().setId(Long.parseLong(id)).setName(name);
            PersonService.getInstance().update(person);
            return PersonService.getInstance().findAll();
        }catch (Exception e){
            return ExceptionWrapper.getError(e);
        }
    }
    @GET
    @Produces("application/json")
    @Path("/findOne")
    public Object findOne(@QueryParam("id") String id){
        try{
            Person person=new Person().setId(Long.parseLong(id));
            PersonService.getInstance().findOne(person);
            return person;
        }catch (Exception e){
            return ExceptionWrapper.getError(e);
        }
    }
    @GET
    @Produces("application/json")
    @Path("/findAll")
    public Object findAll(){
        try {
            return  PersonService.getInstance().findAll();
        }catch (Exception e){
            return ExceptionWrapper.getError(e);
        }
    }
}
