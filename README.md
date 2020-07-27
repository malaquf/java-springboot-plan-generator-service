# Plan Generator Service
This is an example of a Spring Boot microservice for generating repayment plans throughout the lifetime of a loan. 
In this example, it's displayed how to create microservices using SpringBoot and Java, as well as writting unit tests using JUnit5 for it, as well as how to automate the creation of docker images for SpringBoot services using Spotify's Docker file maven plugin.
We can also see in this example, a basic architecture for a stateless simple Microservice (without DB usage for simplification), where distributed logging is used with Spring Sleuth + Zipkins, as well as some design patterns usage like chain of responsability for the request validators object builders.

### Dependencies
* Java 8
* SpringBoot (Sleuth, Zipkin, Web)
* Apache Commons Lang
* Maven
* Docker
* Spotify Docker File Maven Plugin
* Lombok has been used for simplification for removing boiler plate code. Click [here](https://projectlombok.org/setup/overview) for detailed steps on how to install it for your IDE (Eclipse, IntelliJ, etc).

### Setup

```
mvn clean install
docker run -itd -p 8060:8060 fmalaquias/plan-generator-service
```

### Optional 
Zipkin is preconfigured in the project for demo purpose (for possible deployment on cloud env). For using it, just download and start the following image:

```
docker run -itd --name trace -p 9411:9411 openzipkin/zipkin
```

### Usage
After starting the docker container running the plan-generator-service you can submit a request like the following example using curl:

```
curl localhost:8060/generate-plan -X POST -H "Content-Type: application/json" -d '{"loanAmount": 5000,"nominalRate": 5.0,"duration": 24,"startDate": "2018-01-01T00:00:01Z"}'
```

Formatted JSON request:

```json
{
 "loanAmount": "5000",
 "nominalRate": "5.0",
 "duration": 24,
 "startDate": "2018-01-01T00:00:01Z"
}
```

A loan plan for the example above should be equal to:

```json
{
  "borrowerPayments": [
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "5000.00",
          "remainingOutstandingPrincipal": "4801.47",
          "interest": "20.83",
          "principal": "198.53",
          "date": "2018-01-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "4801.47",
          "remainingOutstandingPrincipal": "4602.12",
          "interest": "20.01",
          "principal": "199.35",
          "date": "2018-02-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "4602.12",
          "remainingOutstandingPrincipal": "4401.94",
          "interest": "19.18",
          "principal": "200.18",
          "date": "2018-03-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "4401.94",
          "remainingOutstandingPrincipal": "4200.92",
          "interest": "18.34",
          "principal": "201.02",
          "date": "2018-04-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "4200.92",
          "remainingOutstandingPrincipal": "3999.06",
          "interest": "17.50",
          "principal": "201.86",
          "date": "2018-05-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "3999.06",
          "remainingOutstandingPrincipal": "3796.36",
          "interest": "16.66",
          "principal": "202.70",
          "date": "2018-06-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "3796.36",
          "remainingOutstandingPrincipal": "3592.82",
          "interest": "15.82",
          "principal": "203.54",
          "date": "2018-07-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "3592.82",
          "remainingOutstandingPrincipal": "3388.43",
          "interest": "14.97",
          "principal": "204.39",
          "date": "2018-08-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "3388.43",
          "remainingOutstandingPrincipal": "3183.19",
          "interest": "14.12",
          "principal": "205.24",
          "date": "2018-09-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "3183.19",
          "remainingOutstandingPrincipal": "2977.09",
          "interest": "13.26",
          "principal": "206.10",
          "date": "2018-10-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "2977.09",
          "remainingOutstandingPrincipal": "2770.13",
          "interest": "12.40",
          "principal": "206.96",
          "date": "2018-11-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "2770.13",
          "remainingOutstandingPrincipal": "2562.31",
          "interest": "11.54",
          "principal": "207.82",
          "date": "2018-12-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "2562.31",
          "remainingOutstandingPrincipal": "2353.63",
          "interest": "10.68",
          "principal": "208.68",
          "date": "2019-01-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "2353.63",
          "remainingOutstandingPrincipal": "2144.08",
          "interest": "9.81",
          "principal": "209.55",
          "date": "2019-02-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "2144.08",
          "remainingOutstandingPrincipal": "1933.65",
          "interest": "8.93",
          "principal": "210.43",
          "date": "2019-03-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "1933.65",
          "remainingOutstandingPrincipal": "1722.35",
          "interest": "8.06",
          "principal": "211.30",
          "date": "2019-04-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "1722.35",
          "remainingOutstandingPrincipal": "1510.17",
          "interest": "7.18",
          "principal": "212.18",
          "date": "2019-05-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "1510.17",
          "remainingOutstandingPrincipal": "1297.10",
          "interest": "6.29",
          "principal": "213.07",
          "date": "2019-06-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "1297.10",
          "remainingOutstandingPrincipal": "1083.14",
          "interest": "5.40",
          "principal": "213.96",
          "date": "2019-07-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "1083.14",
          "remainingOutstandingPrincipal": "868.29",
          "interest": "4.51",
          "principal": "214.85",
          "date": "2019-08-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "868.29",
          "remainingOutstandingPrincipal": "652.55",
          "interest": "3.62",
          "principal": "215.74",
          "date": "2019-09-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "652.55",
          "remainingOutstandingPrincipal": "435.91",
          "interest": "2.72",
          "principal": "216.64",
          "date": "2019-10-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.36",
          "initialOutstandingPrincipal": "435.91",
          "remainingOutstandingPrincipal": "218.37",
          "interest": "1.82",
          "principal": "217.54",
          "date": "2019-11-01T00:00:00Z"
      },
      {
          "borrowerPaymentAmount": "219.28",
          "initialOutstandingPrincipal": "218.37",
          "remainingOutstandingPrincipal": "0.00",
          "interest": "0.91",
          "principal": "218.37",
          "date": "2019-12-01T00:00:00Z"
      }
  ]
}
```