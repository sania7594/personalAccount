<html>
<head><title> FreeMarker Spring MVC Hello World</title>

    <style>
        body, input {
            font-family: Calibri, Arial;
            margin: 0px;
            padding: 0px;
        }
        #header h2 {
            color: white;
            background-color: #3275A8;
            height: 50px;
            padding: 5px 0 0 5px;
            font-size: 20px;
        }

        .datatable {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:400px;max-width:100%;font-family:Calibri}
        .datatable th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertical-align:middle;color:#444444}
        .datatable tr {border:1px solid #888}
        .datatable tr.odd {background-color:#eee}
        .datatable td {padding:2px;border:1px solid #888}
        #content { padding: 5px; margin: 5px; text-align: center}

        fieldset { width: 300px; padding: 5px; margin-bottom: 0px; }
        legend { font-weight: bold; }
    </style>
<body>

<table class="datatable">
<tr>
    <th>FirstName</th>  <th>LastName</th>
    <th>Email</th>  <th>Phone</th>
    <th>Birthday</th>  <th>Login</th>
    <th>Password</th>
</tr>
<#list model["repositorys"] as repository>
    <tr>
        <td>${repository.firstName}</td> <td>${repository.lastName}</td>
        <td>${repository.email}</td> <td>${repository.phone}</td>
        <td>${repository.birthday}</td> <td>${repository.login}</td>
        <td>${repository.password}</td>
    </tr>
</#list>
</table>

</body>

