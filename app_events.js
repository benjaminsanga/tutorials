const EventEmitter = require('events');
const eventEmitter = new EventEmitter();

eventEmitter.on('tutorial', (num1, num2)=>{
    console.log(num1 + num2);
});

eventEmitter.emit('tutorial', 1, 2);

class Person extends EventEmitter {
    constructor(name) {
        super();
        this._name = name;
    }

    get name() {
        return this._name;
    }
}

let bily = new Person('Bily');
let lina = new Person('Lina');
lina.on('name', ()=>{
    console.log('my name is ' + lina.name);
});
bily.on('name', ()=> {
    console.log('my name is ' + bily.name);
});

lina.emit('name');
bily.emit('name');