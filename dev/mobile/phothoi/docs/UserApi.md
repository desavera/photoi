# UserApi

All URIs are relative to *http://recruitment.m4u.com.br/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UserApi.md#createUser) | **POST** /users | Create user
[**deleteUser**](UserApi.md#deleteUser) | **DELETE** /users/{username} | Delete user
[**getUserByName**](UserApi.md#getUserByName) | **GET** /users/{username} | Get user by user name
[**loginUser**](UserApi.md#loginUser) | **GET** /users/login | Logs user into the system
[**logoutUser**](UserApi.md#logoutUser) | **GET** /users/logout | Logs out current logged in user session
[**updateUser**](UserApi.md#updateUser) | **PUT** /users/{username} | Updated user


<a name="createUser"></a>
# **createUser**
> createUser(body)

Create user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import io.swagger.client.api.UserApi;

UserApi apiInstance = new UserApi();
User body = new User(); // User | Created user object
try {
    apiInstance.createUser(body);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**User**](User.md)| Created user object | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="deleteUser"></a>
# **deleteUser**
> deleteUser(username)

Delete user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import io.swagger.client.api.UserApi;

UserApi apiInstance = new UserApi();
String username = "username_example"; // String | The name that needs to be deleted
try {
    apiInstance.deleteUser(username);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The name that needs to be deleted |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="getUserByName"></a>
# **getUserByName**
> User getUserByName(username)

Get user by user name



### Example
```java
// Import classes:
//import io.swagger.client.api.UserApi;

UserApi apiInstance = new UserApi();
String username = "username_example"; // String | The name that needs to be fetched. Use user1 for testing.
try {
    User result = apiInstance.getUserByName(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getUserByName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The name that needs to be fetched. Use user1 for testing. |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="loginUser"></a>
# **loginUser**
> String loginUser(username, password)

Logs user into the system



### Example
```java
// Import classes:
//import io.swagger.client.api.UserApi;

UserApi apiInstance = new UserApi();
String username = "username_example"; // String | The user name for login
String password = "password_example"; // String | The password for login in clear text
try {
    String result = apiInstance.loginUser(username, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#loginUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| The user name for login | [optional]
 **password** | **String**| The password for login in clear text | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="logoutUser"></a>
# **logoutUser**
> logoutUser()

Logs out current logged in user session



### Example
```java
// Import classes:
//import io.swagger.client.api.UserApi;

UserApi apiInstance = new UserApi();
try {
    apiInstance.logoutUser();
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#logoutUser");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

<a name="updateUser"></a>
# **updateUser**
> updateUser(username, body)

Updated user

This can only be done by the logged in user.

### Example
```java
// Import classes:
//import io.swagger.client.api.UserApi;

UserApi apiInstance = new UserApi();
String username = "username_example"; // String | name that need to be deleted
User body = new User(); // User | Updated user object
try {
    apiInstance.updateUser(username, body);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#updateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| name that need to be deleted |
 **body** | [**User**](User.md)| Updated user object | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

