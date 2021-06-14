# jpa-learning-101



Spring jpa


Java persistence api

What problem solve JPA – 
Relational databases
No sql – big databases

Java OOP – relational database – normalization
OOP – encapsulation, inheritance, interfaces and polymorphism

Establish mapping from object to table

Object is fields
Table have columns

Many to many

Java object
Employee has list of tasks
Task has list of employes

Db
Create tamble of employee_tasks

Another example – multiple classes are mapped to a single table and vice-versa
Class employee
Class fulltimeemployee extends employee – salary integer
Class parttimeemployee extends employee – hourly wage float

Db
One table – employee  has hourly_wage, employ_type and salary


Object realational impedance mismatch – 

Design objects is different from how design tables

 To solve – JDBC(java database connectivity)(statement, prepared statement, resultset), SPRING JDBC, myBatis – write queries with paramters
 Set values to parameters, those values set in the beans
Use sql statement

Spring jdbc – provide jdbc template – use sql statement and parameter , less code.
RowMapper – use mapper implemented
-	Top layer of jdbc
myBatis – its map object to query – simple xml or anottation based
sql with different sintax

jdbc, spring jdbc and my batis – based on query
problem is when your tables relationship changes, you need to change all queries
-	Queries 100 lines – good database understand
-	Complex queries – difficult to maintain

JPA – provide mapping, this class to this tables, entities relationship
Entiymanager

-	Query to database - 
criteriaApi 
JPQL

Use annotation 
Mapping field to columns

           Relationship
           @ManyToMany


You can inheritance to map class and inhreritanced classes to 1 table


JPA is a interface and specification – have annotations, attributes - definitions
Hibernate implement JPA – hibernate read , save entitites.
Hibernate – orm frameworks

Tomcat – spring boot embedded

JPA always need default constructor(constructor without arguments) in the entity(bean) class 

             @Entity
             public class User {

                 @Id
                 @GeneratedValue
                 private long id;


                 private String name;

                 private String role;


                 protected User() {

                 }


entity for persisted to a database


          // repository is something that interact with the database
          @Repository
          @Transactional
          public class UserDAOService {

              // to save data in db
              @PersistenceContext
              private EntityManager entityManager; 

              public long insert(User user) {
                  // open Transaction
                  entityManager.persist(user);
                  // cloase transaction
                  return user.getId();
              }
          }





             @Component
             public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

                 @Autowired
                 private UserDAOService userDAOService;

                 private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

                 @Override
                 public void run(String... args) throws Exception {
                     // TODO Auto-generated method stub
                     User user = new User("jack","admin");
                     long insert = userDAOService.insert(user);
                     log.info("New User is created : " + user);
                 }

             }
             
In memory database – h2 

Spring boot auto configuration create the datasource

// spring data JPA - just define the intefaces, define repository interfaces

          @Component
          public interface UserRepository extends JpaRepository<User, Long> {

          }


