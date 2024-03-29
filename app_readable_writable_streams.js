// import { createReadStream, createWriteStream } from 'fs';
const fs = require('fs');
const zlib = require('zlib');
// const gzip = zlib.createGzip();
const gunzip = zlib.createGunzip();

const readStream = fs.createReadStream('./example2.gz'/*, 'utf8'*/);
const writeStream = fs.createWriteStream('uncompressed.txt');

// readStream.on('data', (chunk)=>{
//     writeStream.write(chunk);
// });

readStream.pipe(gunzip).pipe(writeStream);