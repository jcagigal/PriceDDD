# ProductPrices
A simple example showing how to create a spring service with some tests

Architecture:
The solution uses an onion-like/ddd style approach

There are 3 main packages (sometimes each one may include an "input/services" and an "output/repositories" part if applicable):
-domain (contains the "model" part of the application with some business logic. Please note that although It includes a Service part, It's more or less "independent" of other dependencies like a particular implementation of DB or rest API and some people think use cases should be keep here.
-application (this part handles the "input" received by the application, e.g. receives the rest requests and handles them through a controller)
-infrastructure (this part handles mostly the "internal" interactions with other systems like databases and other systems. In this case it's dedicated to database access. The mappings could be handled by solutions like mapstruct or manually)

Code: pretty straightforward, cleaned up a little with Sonar, formatted with Eclipse built in style.

a property "napptilus.prices.mode" is set to "standalone" when running standalone. Feel free to change application properties:
server.port=8080
server.servlet.context-path=/prices
to the configuration that suits your server.

Testing:
there are a few unitary tests that provide decent coverage of:
-Service
-Controller
-Repository

And the ice on the cake are the "Integration Tests" located on PriceControllerIT.java. It includes a pack of tests that validate all the application, however please remember to fire up the application server.

Requirements:
The application has been developed with Eclipse-STS 4 and requires JavaSE-17 although will probably work fine with earlier releases. It also uses Maven, JUnit5 and h2 memory database.

Some extra help:
If you tried to use some client like postman point to localhost:8080/price/1/35455/2020-06-14-00.00.01 and remember to set Content-Type as application/json in the headers part.
