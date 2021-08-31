const fs = require('fs');

// create a file
// fs.writeFile('example.txt', "this is an example",(err)=>{
//     if (err)
//         console.log(err);
//     else {
//         console.log('File successfuly created');
//         fs.readFile('example.txt', 'utf8', (err, file)=>{
//             if (err)
//                 console.log(err);
//             else
//                 console.log(file);
//         });
//     }
// });

// rename a file
// fs.rename('example.txt', 'example2.txt', (err)=>{
//     if (err)
//         console.log(err);
//     else 
//         console.log('Successfully renamed the file');
// });

// append data to a file
// fs.appendFile('example2.txt', 'Some data being appended',(err)=>{
//     if(err)
//         console.log(err)
//     else
//         console.log('successfully appended data to the file');
// });

// delete a file
fs.unlink('example2.txt',(err)=>{
    if (err)
        console.log(err);
    else
        console.log('successfully deleted the file');
});