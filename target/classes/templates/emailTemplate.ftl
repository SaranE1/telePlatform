<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Doctor Prescription</title>
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
  }

  .container {
    width: 90%;
    margin: 20px auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }

  h1, h2 {
    text-align: center;
  }

  .prescription-info {
    margin-top: 20px;
  }

  .prescription-info p {
    margin: 10px 0;
  }

  .medicine-list {
    margin-top: 20px;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
  }

  th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }

  th {
    background-color: #f2f2f2;
  }

  @media screen and (max-width: 600px) {
    .container {
      width: 100%;
      margin: 10px auto;
      padding: 10px;
      border: 2px;
      border-color: black;
    }
  }
</style>
</head>
<body>

<div class="container">
  <h1>Doctor Prescription Report</h1>
  
  <div class="prescription-info">
    <h2>Patient Information</h2>
    <p><strong>Name:</strong> ${patientName} </p>
    <p><strong>Age:</strong> ${patientAge} </p>
    <p><strong>Gender:</strong> ${gender} </p>
  </div>
  
  <div class="medicine-list">
    <h2>Medicine List</h2>
    <table>
      <thead>
        <tr>
          <th>Medicine</th>
          <th>Dosage</th>
          <th>Frequency</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td> ${medicineName1} </td>
          <td> ${dosage1} </td>
          <td> ${dayNight1} </td>
        </tr>
      </tbody>
       <tbody>
        <tr>
          <td> ${medicineName2} </td>
          <td> ${dosage2} </td>
          <td> ${dayNight2} </td>
        </tr>
      </tbody>
    </table>
  </div>
</div>

</body>
</html>
