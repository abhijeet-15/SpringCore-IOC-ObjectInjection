# Spring IOC Container and Dependency Injection in Java

When using an Object-Oriented Programming (OOP) language like Java, especially for backend development, there are requirements to create multiple objects. Managing the lifecycle of these objects is even more challenging.

Thankfully, we have the Spring IOC Container to our rescue. Spring IOC takes the heavy lifting of creating and managing objects and lets the developers focus more on the business logic (ETA gets lesser :P).

Consider the Spring IOC container as a bucket that has objects created for each of the required classes. All we need to do is to mention the classes whose objects we would need in a config file. Spring IOC container automatically creates and manages the lifecycle of these objects better known as beans. To access any bean, all we need to do is to call the appropriate method.

### Example Usage

**Main.java**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        PaymentService service = context.getBean("paymentService", PaymentService.class);
        service.makePayment();
        service.refundPayment();
    }
}
```
** beans.xml **
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="paymentService" class="com.abhijeetsingh.Stripe"/>
</beans>
```

**Dependency Injection**

A class’s object can depend upon several other class objects/collections/literal. These are the dependencies of the class. Instead of initializing the values of these dependencies by the developer, Spring framework can automatically inject the value to its respective dependency. This is known as dependency injection.

Injecting Literals
Setter injection
Create the property with the setter method. In the beans.xml file, inside the bean tag, add a <property> tag. The name property will be the literal name and the value will be the value that should be given.

```xml
<bean id="student" class="com.abhijeetsingh.Student">
<property name="studentName" value="Abhijeet Singh" />
<property name="studentId" value="1" />
</bean>
```

**Student.java**
```java
package com.abhijeetsingh;

public class Student {
    private long studentId;
    private String studentName;

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return this.studentName;
    }
}
```

**Constructor Injection**

Constructors are used to initialize the values. 
`````<bean>```` with different ```<constructor-arg>``` tags can be used based on the type of constructors 
defined in the corresponding class.

```xml
<bean id="rutu" class="com.abhijeetsingh.Student">
   <constructor-arg name="studentName" value="Ruturaj"/>
   <constructor-arg name="studentId" value="1"/>
</bean>

<bean id="rachin" class="com.abhijeetsingh.Student">
   <constructor-arg name="studentName" value="Rachin"/>
   <constructor-arg name="studentId" value="2"/>
</bean>

<bean id="shardul" class="com.abhijeetsingh.Student">
</bean>
```

**Injecting Object Type**

Consider the below BetterStudent class that depends upon the EnglishCheat class’s method.

```java
package com.abhijeetsingh.betterWay;

public class BetterStudent {
    private EnglishCheat englishCheat;

    public BetterStudent(){};

    public void setEnglishCheat(EnglishCheat englishCheat) {
        this.englishCheat = englishCheat;
    }

    public void cheat() {
        englishCheat.startEnglishCheat();
    }
}

package com.abhijeetsingh.betterWay;

public class EnglishCheat {
    public void startEnglishCheat() {
        System.out.println("English cheat started");
    }
}
```

Now, one way is to manually create and populate the dependency, but of course, we do not want to do it and use Spring’s dependency injection.

In the beans.xml, create a ```<bean>``` for the EnglishCheat and give it an id. Now using ```<property>``` inside the ```<bean>``` of the BetterStudent class, with ```<ref>``` tag, this dependency can be injected. One English cheat ```<bean>``` object can be used as ```<ref>``` across all dependent classes.

```xml
<bean id="englishCheatReference" class="com.abhijeetsingh.betterWay.EnglishCheat" />

<bean id="betterStudent" class="com.abhijeetsingh.betterWay.BetterStudent">
   <property name="englishCheat" ref="englishCheatReference" />
</bean>

<!-- Constructor Injection -->
<bean id="betterStudent" class="com.abhijeetsingh.betterWay.BetterStudent">
   <constructor-arg name="englishCheat" ref="englishCheatReference" />
</bean>
```

