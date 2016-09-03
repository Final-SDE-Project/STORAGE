package ehealth.controller_storage.ws;


import ehealth.controller_db.ws.*;
import org.glassfish.jersey.client.ClientConfig;

import javax.jws.WebService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@WebService(endpointInterface = "ehealth.controller_storage.ws.ServiceStorage", serviceName="StorageService")
public class ServiceStorageImpl implements ServiceStorage
{
    public static DataBaseService dataBaseService = new DataBaseService();
    public static ServiceDB serviceDB = dataBaseService.getServiceDBImplPort();

    //Method #1
    @Override
    public List<Person> readPersonList()
    {
        List<Person> personList = new ArrayList<Person>();
        try
        {
            personList = serviceDB.readPersonList();
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return personList;
    }

    //Method #2
    @Override
    public Person readPerson(Long person_id)
    {
        Person person = new Person();
        try
        {
            person = serviceDB.readPerson(person_id);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return person;
    }

    //Method #3
    @Override
    public void updatePerson(Person person)
    {
        try
        {
            serviceDB.updatePerson(person);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
    }

    //Method #4
    @Override
    public Person createPerson(Person person)
    {
        try
        {
            person = serviceDB.createPerson(person);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return person;
    }

    //Method #5
    @Override
    public void deletePerson(Person person)
    {
        try
        {
            serviceDB.deletePerson(person);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
    }

    //Method #6
    @Override
    public List<HealthMeasureHistory> readPersonHistory(Long idPerson, String measureType)
    {
        List<HealthMeasureHistory> healthMeasureHistories = new ArrayList<HealthMeasureHistory>();
        try
        {
            healthMeasureHistories = serviceDB.readPersonHistory(idPerson, measureType);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return healthMeasureHistories;
    }

    //Method #7
    @Override
    public List<String> readMeasureTypes()
    {
        List<String> measureTypes = new ArrayList<String>();
        try
        {
            measureTypes = serviceDB.readMeasureTypes();
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return measureTypes;
    }

    //Method #8
    @Override
    public HealthMeasureHistory readPersonMeasure(Long idPerson, String measureType, Long mid)
    {
        HealthMeasureHistory healthMeasureHistory = new HealthMeasureHistory();
        try
        {
            healthMeasureHistory = serviceDB.readPersonMeasure(idPerson, measureType, mid);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return healthMeasureHistory;
    }

    //Method #9
    @Override
    public HealthMeasureHistory savePersonMeasure(Long id, HealthMeasureHistory healthMeasureHistory)
    {
        HealthMeasureHistory tmpHealthMeasureHistory = new HealthMeasureHistory();
        try
        {
            tmpHealthMeasureHistory = serviceDB.savePersonMeasure(id, healthMeasureHistory);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return tmpHealthMeasureHistory;
    }

    //Method #10
    @Override
    public HealthMeasureHistory updatePersonMeasure(Long id, HealthMeasureHistory healthMeasureHistory)
    {
        HealthMeasureHistory tmpHealthMeasureHistory = new HealthMeasureHistory();
        try
        {
            tmpHealthMeasureHistory = serviceDB.updatePersonMeasure(id, healthMeasureHistory);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return tmpHealthMeasureHistory;
    }

    //Method #11
    @Override
    public MeasureDefinition readMeasureType(String measureType)
    {
        MeasureDefinition measureDefinition = new MeasureDefinition();
        try
        {
            measureDefinition = serviceDB.readMeasureType(measureType);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return measureDefinition;
    }

    //Method #12
    @Override
    public Goal updateGoal(Goal goal)
    {
        Goal tmpGoal = new Goal();
        try
        {
            tmpGoal = serviceDB.updateGoal(goal);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return tmpGoal;
    }

    //Method #13
    @Override
    public List<Goal> readGoalList(Long id)
    {
        List<Goal> goals = new ArrayList<Goal>();
        try
        {
            goals = serviceDB.readGoalList(id);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return goals;
    }

    //Method #14
    @Override
    public List<Goal> readLatestGoalList(Long id)
    {
        List<Goal> goals = new ArrayList<Goal>();
        try
        {
            goals = serviceDB.readLatestGoalList(id);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return goals;
    }

    //Method #15
    @Override
    public Goal saveGoal(Goal goal)
    {
        try
        {
            goal = serviceDB.saveGoal(goal);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return goal;
    }

    //Method EXTRA
    @Override
    public List<HealthMeasureHistory> readMeasureHistoriesByDate(Long idPerson, String measureType, Date before, Date after)
    {
        List<HealthMeasureHistory> healthMeasureHistories = new ArrayList<HealthMeasureHistory>();
        try
        {
            GregorianCalendar beforeDate = new GregorianCalendar();
            beforeDate.setTime(before);
            XMLGregorianCalendar beforeDateXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(beforeDate);
            GregorianCalendar afterDate = new GregorianCalendar();
            afterDate.setTime(after);
            XMLGregorianCalendar afterDateXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(afterDate);

            healthMeasureHistories = serviceDB.readMeasureHistoriesByDate(idPerson, measureType, beforeDateXML, afterDateXML);
        }catch (Exception e)
        {
            System.out.println(e.getCause());
        }
        return healthMeasureHistories;
    }

    @Override
    public String readBmi(double weight, double height)
    {
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);

        WebTarget service = client.target(UriBuilder.fromUri("https://sde-external.herokuapp.com/external/").build());
        Response response;

        response = service.path("bmi").queryParam("weight",weight).queryParam("height",height).request().get();

        String output = response.readEntity(String.class);

        return output;
    }

    @Override
    public String readQuote()
    {
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);

        WebTarget service = client.target(UriBuilder.fromUri("https://sde-external.herokuapp.com/external/").build());
        Response response;

        response = service.path("quote").request().get();

        String output = response.readEntity(String.class);

        return output;
    }
}
