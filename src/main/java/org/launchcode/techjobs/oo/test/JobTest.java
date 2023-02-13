package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1= new Job();
        Job job2 = new Job();

        assertNotEquals ("the IDs of the two objects are distinct", job1,job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobFields.getName() instanceof String);
        assertTrue(jobFields.getEmployer() instanceof Employer);
        assertTrue(jobFields.getLocation() instanceof  Location);
        assertTrue(jobFields.getLocation() instanceof Location);
        assertTrue(jobFields.getPositionType() instanceof PositionType);
        assertTrue(jobFields.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(jobFields.getName(), "Product tester");
        assertEquals(jobFields.getEmployer().getValue(), "ACME");
        assertEquals(jobFields.getLocation().getValue(), "Desert");
        assertEquals(jobFields.getPositionType().getValue(), "Quality control");
        assertEquals(jobFields.getCoreCompetency().getValue(),"Persistence");
    }

    @Test

    public void testJobsForEquality(){
       Job jobFields1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       Job jobFields2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

       assertFalse(jobFields1.equals(jobFields2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstChar = jobFields.toString().charAt(0);
        char lastChar = jobFields.toString().charAt(jobFields.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
       Job jobFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       String job1 = jobFields.toString();

        assertTrue(job1.contains("ID:"));
        assertTrue(job1.contains("Name:"));
        assertTrue(job1.contains("Employer"));
        assertTrue(job1.contains("Location"));
        assertTrue(job1.contains("Position Type:"));
        assertTrue(job1.contains("Core Competency:"));

        assertEquals(job1 , System.lineSeparator() + "ID: " + jobFields.getId() + System.lineSeparator() + "Name: " + jobFields.getName() + System.lineSeparator() + "Employer: " + jobFields.getEmployer() + System.lineSeparator() + "Location: " + jobFields.getLocation() + System.lineSeparator() + "Position Type: " + jobFields.getPositionType() + System.lineSeparator() + "Core Competency: " + jobFields.getCoreCompetency() + System.lineSeparator());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job();
        String job1 = job.toString();

        assertEquals(job1, System.lineSeparator() + "ID: " + job.getId() + System.lineSeparator() + "Name: " + "Data not available" + System.lineSeparator() + "Employer: " + "Data not available" + System.lineSeparator() + "Location: " + "Data not available" + System.lineSeparator() + "Position Type: " + "Data not available" + System.lineSeparator() +"Core Competency: " + "Data not available" + System.lineSeparator());
    }


}
