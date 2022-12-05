SPECIFICATION:
This is a sample GRAPHQL representaion of an ecommerce application with few features included.
Custom Validations has been added and this application has been tested.

REQUIREMENTS:
1. JDK 17
2. Maven 3.6.3

VALIDATIONS ADDED:
1. Minimum and maximum priceModifier according to paymentMethod
2. Valid paymentMethod
3. Points according to paymentMethod
4. Allowed courier according to paymentMethod
5. AdditionalItems validation as per requirements
6. AdditionalItems depending on paymentMethod

STEPS TO TEST
1. Right click [src/main/java/com/classes/myecommerce/MyecommerceApplication.java]
2. Click on [Run 'MyecommerApp...main()']

OPERATIONS

* INSERT:
1. Go to [http://localhost:8080/graphiql?path=/graphql] 
2. On the left side, paste the query below:

REQUEST [Note: Those with "*" are required fields]
```
mutation {
  insertPaymentRecord(
    paymentRequest:
    {
      *customerId: "0002",
      *price: 900.00, 
      priceModifier: 0.9699, 
      dateTime: "2022-09-01 12:59:59", 
      *paymentMethod:"JCB",
      additionalItem: {
        last_4: "1234",
        checkNo: "5678",
        bankName: "BPI",
        acctNo: "1010101022",
        courier: "SAGAWA"
        }
    }) {
    finalPrice
    points
  } 
}
```

RESPONSE
```
{
  "data": {
    "insertPaymentRecord": {
      "finalPrice": 872.91,
      "points": 45
    }
  }
}
```

* SEARCH:

1. Go to [http://localhost:8080/graphiql?path=/graphql] 
2. On the left side, paste the query below:

REQUEST [Note: Those with "*" are required fields]
```
query {
  findByDate(
    searchRequest:
    {
      *startDateTime:"2022-08-01 12:59:59",
      *endDateTime:"2022-09-01 12:59:59"
    }) {
    datetime
    sales
    points
  } 
}
```

RESPONSE
```
{
  "data": {
    "findByDate": [
      {
        "datetime": "2022-09-01T12:59:59",
        "sales": "900.00",
        "points": "45.00"
      }
    ]
  }
}
```

NOTES:
1. The dateTime fields format is [yyyy-MM-dd HH:mm:ss] [ex. 2022-08-01 12:59:59]
2. This is for presentation purposes only. The database data refreshes every server restart.
3. To see if database is being updated, please go to [http://localhost:8080/h2-console]
4. username: sa, password: password
