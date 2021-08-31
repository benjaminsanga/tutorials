const http = require('http');
const fs = require('fs');
http.createServer((req, res)=>{
    const readStream = fs.createReadStream('./static/example.jpeg'); // example.json | index.html
    res.writeHead(200, {'Content-type': 'image/jpeg'}); // application/json | text/html
    readStream.pipe(res);
}).listen(3000);
