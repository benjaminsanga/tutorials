const fs = require('fs');

// create a folder
// fs.mkdir('tutorial',(err)=>{
//     if(err)
//         console.log(err);
//     else {
//         // delete a folder
//         // fs.rmdir('tutorial', (err)=>{
//         //     if (err)
//         //         console.log(err);
//         //     else
//         //         console.log('successfully deleted folder');
//         // });

//         fs.writeFile('./tutorial/example.txt', '123', (err)=>{
//             if (err)
//                 console.log(err);
//             else
//                 console.log('successfully created file');
//         });

//     }
// });

// delete file and directory
// fs.unlink('./tutorial/example.txt',(err)=>{
//     if (err)
//         console.log(err);
//     else {
//         fs.rmdir('tutorial', (err)=>{
//             if (err)
//                 console.log(err);
//             else
//                 console.log('deleted folder');
//         });
//     }
// });

// delete multiple files
fs.readdir('example',(err,files)=>{
    if (err)
        console.log(err);
    else {
        for (let file of files) {
            fs.unlink('./example/' + file, (err)=>{
                if (err)
                    console.log(err);
                else {
                    console.log('successfully deleted file');
                }
            });
        }
    }
});