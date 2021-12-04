package com.sankdev.serializing;

import com.sankdev.serializing.SerializeDemo.Person;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

public class SerializeDemoTest {

  @Test
  public void givenPerson_whenSerialize_thenEqualObjects() throws IOException {
    Person person = new Person("Ivan", "Man", 25);
    String tmpFileName = System.getProperty("java.io.tmpdir") + "person.bin";
    Files.deleteIfExists(Paths.get(tmpFileName));

    SerializeDemo demo = new SerializeDemo();

    demo.savePerson(person, tmpFileName);
    Person loadedPerson = demo.loadPerson(tmpFileName);

    // Files.deleteIfExists(Paths.get(tmpFileName));

    Assert.assertEquals("Serialized object and the loaded object are not equal", person,
        loadedPerson);
  }

}
