<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<head>
    <meta charset="UTF-8">
</head>
<title>Account Creation Page</title>
<body>
    <form action="" method="post">
        <h1>Create Account:</h1>
        <p>First Name: <input type="text" name="fname"/></p>
        <p>Last Name: <input type="text" name="fname"/></p>
        <p>Phone Number: <input type="text" name="fname"/></p>
        <p>Address: <input type="text" name="fname"/></p>
        <p>City: <input type="text" name="fname"/></p>
        <p>State: <input type="text" name="fname"/></p>
        <p>Country: <input type="text" name="fname"/></p>
        <p>Zip Code: <input type="text" name="fname"/></p>
        <p>Email: <input type="text" name="lname"/></p>
        <p>Password <input type="password" name="password"/></p>
        <input type="submit" value="Submit"/><input type="reset" value="Clear"/>
    </form>
</body> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <!-- <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input[type="text"],
        .form-group input[type="password"],
        .form-group input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-group button {
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        .form-group button:hover {
            background-color: #0056b3;
        }
    </style> -->
    
</head>
<body>

<jsp:include page="header.jsp" flush="true" />

<div class="container" style="margin-left: 50px;">
    <h2>Create New Account</h2>
    <form action="AccountCreationServlet" method="post">
        <div class="form-group">
            <label for="newAccountFirstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" placeholder="Enter your first name" required>
        </div>       
        <div class="form-group">
            <label for="newAccountLastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" placeholder="Enter your last name" required>
        </div>
        <div class="form-group">
            <label for="newAccountEmail">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label for="newAccountPassword">Password:</label>
            <input type="password" id="password" name="password" placeholder="Create a password" required>
        </div>       
         <div class="form-group">
            <label for="newAccountPhone">Phone Number:</label>
            <input type="text" id="phone" name="phone" placeholder="Enter your phone number" required>
        </div>

        <h4>Billing Information</h4>
        <div class="form-group">
            <label for="billingAddress">Address:</label>
            <input type="text" id="address" name="address" placeholder="Enter your billing address" required>
        </div>
        <div class="form-group">
            <label for="billingCity">City:</label>
            <input type="text" id="city" name="city" placeholder="Enter your city" required>
        </div>
        <div class="form-group">
            <label for="billingState">Province/State:</label>
            <input type="text" id="state" name="state" placeholder="Enter your state" required>
        </div>
        <div class="form-group">
            <label for="billingZip">Zip Code:</label>
            <input type="text" id="zipCode" name="zipCode" placeholder="Enter your zip code" required>
        </div>
        <div class="form-group">
            <label for="billingCountry">Country:</label>
            <input type="text" id="country" name="country" placeholder="Enter your country" required>
        </div>

        <h4>Shipping Information</h4>
        <div class="form-group">
            <input type="checkbox" id="sameAsBilling" onclick="toggleShipping(this)">
            <label for="sameAsBilling">Same as billing information</label>
        </div>
        <div id="shippingInfo">
            <div class="form-group">
                <label for="shippingAddress">Address:</label>
                <input type="text" id="shippingAddress" name="shippingAddress" placeholder="Enter your shipping address">
            </div>
            <div class="form-group">
                <label for="shippingCity">City:</label>
                <input type="text" id="shippingCity" name="shippingCity" placeholder="Enter your city">
            </div>
            <div class="form-group">
                <label for="shippingState">Province/State:</label>
                <input type="text" id="shippingState" name="shippingState" placeholder="Enter your province/state">
            </div>
            <div class="form-group">
                <label for="shippingZip">Zip Code:</label>
                <input type="text" id="shippingZip" name="shippingZip" placeholder="Enter your zip code">
            </div>
            <div class="form-group">
                <label for="shippingCountry">Country:</label>
                <input type="text" id="shippingCountry" name="shippingCountry" placeholder="Enter your country">
            </div>
        </div>

        <button type="submit">Create Account</button>
    </form>
</div>

<script>
    function toggleShipping(checkbox) {
        const shippingInfo = document.getElementById('shippingInfo');
        if (checkbox.checked) {
            shippingInfo.style.display = 'none';
        } else {
            shippingInfo.style.display = 'block';
        }
    }
</script>

</body>
</html>
