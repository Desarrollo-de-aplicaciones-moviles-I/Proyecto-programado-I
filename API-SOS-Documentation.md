# API SOS Documentation

## Base URL
```
https://api-sos-bort.onrender.com
```

---

## **Endpoints**

## USERS 
### 1. **Create User**
**Endpoint:**
```
POST /user
```

**Description:**  
Creates a new user.

**Request Example:**
```json
{
  "Username": "Pepe",
  "Email": "pepe@gmail.com",
  "Password": "123",
  "PhoneNumber": "22335588"
}
```

**Response Example:**
```json
{
    "data": {
        "Username": "Pepe",
        "Email": "pepe@gmail.com",
        "Password": "123",
        "PhoneNumber": "22335588"
    },
    "responseCode": 200,
    "message": "User created successfully."
}
```

---

### 2. **Get By Username**
**Endpoint:**
```
GET /user/username/:username
```

**Description:**  
Identifies a user based on username.

**Response Example:**
```json
{
    "data": [
        {
            "Username": "Earvin",
            "Email": "earvin@gmail.com",
            "Password": "123",
            "PhoneNumber": "22335588"
        }
    ],
    "responseCode": 200,
    "message": "Action executed successfully."
}
```

---

### 3. **Get By Email**
**Endpoint:**
```
GET /user/email/:email
```

**Description:**  
Identifies a user based on email.

**Response Example:**
```json
{
    "data": [
        {
            "Username": "Laura",
            "Email": "laura@gmail.com",
            "Password": "111",
            "PhoneNumber": "87743845"
        }
    ],
    "responseCode": 200,
    "message": "Action executed successfully."
}
```

---

### 4. **Login**
**Endpoint:**
```
POST /user/login
```

**Description:**  
Authenticates a user based on username and password.

**Request Example:**
```json
{
  "username": "Laura",
  "password": "111"
}
```

**Response Example:**
```json
{
    "data": {
        "Username": "Laura",
        "Email": "laura@gmail.com",
        "Password": "111",
        "PhoneNumber": "87743845"
    },
    "responseCode": 200,
    "message": "Login successful."
}
```

---

### 5. **LogOut**
**Endpoint:**
```
POST /user/logout
```

**Description:**  
Log out a user.

**Request Example:**
```json
{
  "username": "Laura"
}
```

**Response Example:**
```json
{
    "data": "Laura",
    "responseCode": 200,
    "message": "Logout successful."
}
```

---

### 6. **Update Password**
**Endpoint:**
```
PUT /user/:username/password
```

**Description:**  
Updates a user password.

**Request Example:**
```json
{
  "newPassword": "111"
}
```

**Response Example:**
```json
{
    "data": {
        "Username": "Laura",
        "Email": "laura@gmail.com",
        "Password": "111",
        "PhoneNumber": "87743845"
    },
    "responseCode": 200,
    "message": "Password updated successfully."
}
```
---

### 6. **Update Phone**
**Endpoint:**
```
PUT /user/:username/phone
```

**Description:**  
Updates a user number phone.

**Request Example:**
```json
{
  "newPhone": "87743845"
}
```

**Response Example:**
```json
{
    "data": {
        "Username": "Laura",
        "Email": "laura@gmail.com",
        "Password": "111",
        "PhoneNumber": "87743845"
    },
    "responseCode": 200,
    "message": "Phone updated successfully."
}
```

## CONTACTS 
### 1. **Create Contact**
**Endpoint:**
```
POST /contact
```

**Description:**  
Creates a new contact.

**Request Example:**
```json
{
  "Name": "Pau",
  "PhoneNumber": "11447722",
  "NameUser": "Laura"
}
```

**Response Example:**
```json
{
    "data": {
        "Name": "Pau",
        "PhoneNumber": "11447722",
        "NameUser": "Laura"
    },
    "responseCode": 200,
    "message": "Contact created successfully."
}
```

---

### 2. **Get Contact By User**
**Endpoint:**
```
GET /contact/user/:username
```

**Description:**  
Lists the user contacts.

**Response Example:**
```json
{
    "data": [
        {
            "Name": "Rocio",
            "PhoneNumber": "55224499",
            "NameUser": "Laura"
        },
        {
            "Name": "Irvin",
            "PhoneNumber": "55224499",
            "NameUser": "Laura"
        },
        {
            "Name": "Pau",
            "PhoneNumber": "11447722",
            "NameUser": "Laura"
        }
    ],
    "responseCode": 200,
    "message": "Action executed successfully."
}
```

---

### 3. **Get Contact By Name**
**Endpoint:**
```
GET /contact/name/:contactName
```

**Description:**  
Identifies a contact based on name.

**Response Example:**
```json
{
    "data": [
        {
            "Name": "Irvin",
            "PhoneNumber": "55224499",
            "NameUser": "Laura"
        }
    ],
    "responseCode": 200,
    "message": "Action executed successfully."
}
```

---

### 4. **Get Contact By Phone Number**
**Endpoint:**
```
GET /contact/phone/:phoneNumber
```

**Description:**  
Identifies a contact based on phone number.

**Response Example:**
```json
{
    "data": [
        {
            "Name": "Rocio",
            "PhoneNumber": "55224499",
            "NameUser": "Laura"
        },
        {
            "Name": "Irvin",
            "PhoneNumber": "55224499",
            "NameUser": "Laura"
        }
    ],
    "responseCode": 200,
    "message": "Action executed successfully."
}
```

---

### 5. **Update Contact Phone**
**Endpoint:**
```
PUT /contact
```

**Description:**  
Updates a contact phone number.

**Request Example:**
```json
{
    "Name": "Vanessa",
    "PhoneNumber": "55224455",
    "NameUser": "Ever"
}

```

**Response Example:**
```json
{
    "data": {
        "Name": "Vanessa",
        "PhoneNumber": "55224455",
        "NameUser": "Ever"
    },
    "responseCode": 200,
    "message": "Contact updated successfully."
}
```

---

### 6. **Delete Contact**
**Endpoint:**
```
DELETE /contact/:name
```

**Description:**  
Deletes a contact based on their name.

**Response Example:**
```json
{
    "data": {
        "Name": "Pau",
        "PhoneNumber": "11447722",
        "NameUser": "Laura"
    },
    "responseCode": 200,
    "message": "Contact removed successfully."
}
```

## ALERTS 
### 1. **Create Alert**
**Endpoint:**
```
POST /alerts
```

**Description:**  
Creates a new alert.

**Request Example:**
```json
{
  "DateAlert": "2025-12-13T09:10:00",
  "Message": "Necesito ayuda urgentemente",
  "Latitude": 1,
  "Longitude": 1,
  "IdUser": "Laura"
}
```

**Response Example:**
```json
{
    "data": {
        "DateAlert": "2025-12-13T09:10:00",
        "Message": "Necesito ayuda urgentemente",
        "Latitude": 1,
        "Longitude": 1,
        "IdUser": "Laura",
        "IdAlert": 733922
    },
    "responseCode": 200,
    "message": "Alert added successfully."
}
```

---

### 2. **Get Alerts By User**
**Endpoint:**
```
GET /alerts/user/:userId
```

**Description:**  
Lists the user alerts.

**Response Example:**
```json
{
    "data": [
        {
            "IdAlert": 100001,
            "DateAlert": "2025-12-02T14:30:00",
            "Message": "Necesito ayuda urgente",
            "Latitude": 1,
            "Longitude": 1,
            "IdUser": "Laura"
        },
        {
            "DateAlert": "2025-12-02T14:30:00",
            "Message": "Necesito ayuda urgente",
            "Latitude": 1,
            "Longitude": 1,
            "IdUser": "Laura",
            "IdAlert": 437184
        },
        {
            "DateAlert": "2025-12-13T09:10:00",
            "Message": "Necesito ayuda urgentemente",
            "Latitude": 1,
            "Longitude": 1,
            "IdUser": "Laura",
            "IdAlert": 733922
        }
    ],
    "responseCode": 200,
    "message": "Action executed successfully."
}
```
