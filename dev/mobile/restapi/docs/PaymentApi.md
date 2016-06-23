# PaymentApi

All URIs are relative to *http://recruitment.m4u.com.br/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletePaymentRequest**](PaymentApi.md#deletePaymentRequest) | **DELETE** /payment/{paymentId} | Deletes a Payment Request
[**getPaymentRequestById**](PaymentApi.md#getPaymentRequestById) | **GET** /payment/{paymentId} | Find Payment Request by ID
[**submitPaymentRequest**](PaymentApi.md#submitPaymentRequest) | **POST** /payment | Submits a new Payment Request
[**updatePaymentRequest**](PaymentApi.md#updatePaymentRequest) | **PUT** /payment | Update an existing Payment Request


<a name="deletePaymentRequest"></a>
# **deletePaymentRequest**
> deletePaymentRequest(apiKey, paymentId)

Deletes a Payment Request



### Example
```java
// Import classes:
//import io.swagger.client.api.PaymentApi;

PaymentApi apiInstance = new PaymentApi();
String apiKey = "apiKey_example"; // String | 
Long paymentId = 789L; // Long | Payment Request id to delete
try {
    apiInstance.deletePaymentRequest(apiKey, paymentId);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentApi#deletePaymentRequest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**|  |
 **paymentId** | **Long**| Payment Request id to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getPaymentRequestById"></a>
# **getPaymentRequestById**
> PaymentRequest getPaymentRequestById(paymentId)

Find Payment Request by ID

Returns a Payment Request when ID &lt; 10.  ID &gt; 10 or nonintegers will simulate API error conditions

### Example
```java
// Import classes:
//import io.swagger.client.api.PaymentApi;

PaymentApi apiInstance = new PaymentApi();
Long paymentId = 789L; // Long | ID of PaymentRequest that needs to be fetched
try {
    PaymentRequest result = apiInstance.getPaymentRequestById(paymentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentApi#getPaymentRequestById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentId** | **Long**| ID of PaymentRequest that needs to be fetched |

### Return type

[**PaymentRequest**](PaymentRequest.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="submitPaymentRequest"></a>
# **submitPaymentRequest**
> submitPaymentRequest(body)

Submits a new Payment Request



### Example
```java
// Import classes:
//import io.swagger.client.api.PaymentApi;

PaymentApi apiInstance = new PaymentApi();
PaymentRequest body = new PaymentRequest(); // PaymentRequest | Payment Request
try {
    apiInstance.submitPaymentRequest(body);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentApi#submitPaymentRequest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PaymentRequest**](PaymentRequest.md)| Payment Request | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updatePaymentRequest"></a>
# **updatePaymentRequest**
> updatePaymentRequest(body)

Update an existing Payment Request



### Example
```java
// Import classes:
//import io.swagger.client.api.PaymentApi;

PaymentApi apiInstance = new PaymentApi();
PaymentRequest body = new PaymentRequest(); // PaymentRequest | Payment Request object that needs to be added to the store
try {
    apiInstance.updatePaymentRequest(body);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentApi#updatePaymentRequest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PaymentRequest**](PaymentRequest.md)| Payment Request object that needs to be added to the store |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

