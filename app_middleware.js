const express = require('express');
const bodyParser = require('body-parser');
const app = express();

app.use(bodyParser.json());
app.use(/*'/example', */(req, res, next)=>{
    // console.log(req.url, req.method);
    req.orange = 'orange';
    next();
});

app.get('/', (req, res)=>{
    console.log(req.orange);
    res.send('Middleware');
});

app.listen(3000);