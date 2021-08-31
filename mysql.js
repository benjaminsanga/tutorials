const mysql = require('mysql');

const con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "1qazxsw2"
});

con.connect((err) => {
  if (err) throw err;
  console.log("Connected!");

  con.query("CREATE DATABASE mydb", (err, result) => {
    if (err) throw err;
    console.log("Database created");
  });

  let sql = "CREATE TABLE customers (name VARCHAR(255), address VARCHAR(255))";
  con.query(sql, (err, result) => {
    if (err) throw err;
    console.log("Table created");
  });

});
