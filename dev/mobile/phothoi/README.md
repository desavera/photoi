# swagger-android-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-android-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-android-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-android-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.api.PaymentApi;

public class PaymentApiExample {

    public static void main(String[] args) {
        PaymentApi apiInstance = new PaymentApi();
        String apiKey = "apiKey_example"; // String | 
        Long paymentId = 789L; // Long | Payment Request id to delete
        try {
            apiInstance.deletePaymentRequest(apiKey, paymentId);
        } catch (ApiException e) {
            System.err.println("Exception when calling PaymentApi#deletePaymentRequest");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://recruitment.m4u.com.br/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*PaymentApi* | [**deletePaymentRequest**](docs/PaymentApi.md#deletePaymentRequest) | **DELETE** /payment/{paymentId} | Deletes a Payment Request
*PaymentApi* | [**getPaymentRequestById**](docs/PaymentApi.md#getPaymentRequestById) | **GET** /payment/{paymentId} | Find Payment Request by ID
*PaymentApi* | [**submitPaymentRequest**](docs/PaymentApi.md#submitPaymentRequest) | **POST** /payment | Submits a new Payment Request
*PaymentApi* | [**updatePaymentRequest**](docs/PaymentApi.md#updatePaymentRequest) | **PUT** /payment | Update an existing Payment Request
*UserApi* | [**createUser**](docs/UserApi.md#createUser) | **POST** /users | Create user
*UserApi* | [**deleteUser**](docs/UserApi.md#deleteUser) | **DELETE** /users/{username} | Delete user
*UserApi* | [**getUserByName**](docs/UserApi.md#getUserByName) | **GET** /users/{username} | Get user by user name
*UserApi* | [**loginUser**](docs/UserApi.md#loginUser) | **GET** /users/login | Logs user into the system
*UserApi* | [**logoutUser**](docs/UserApi.md#logoutUser) | **GET** /users/logout | Logs out current logged in user session
*UserApi* | [**updateUser**](docs/UserApi.md#updateUser) | **PUT** /users/{username} | Updated user


## Documentation for Models

 - [PaymentRequest](docs/PaymentRequest.md)
 - [Sender](docs/Sender.md)
 - [User](docs/User.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



